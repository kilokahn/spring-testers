
package com.kilo;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.springframework.jms.connection.ConnectionFactoryUtils;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.support.JmsUtils;
import org.springframework.transaction.TransactionStatus;

/**
 * Borrowed from http://sleeplessinslc.blogspot.com/2010/04/batchmessagelistenercontainer-using.html
 */
public class BatchMessageListenerContainer extends
        DefaultMessageListenerContainer {

    public static final int DEFAULT_BATCH_SIZE = 100;
    private int batchSize = DEFAULT_BATCH_SIZE;

    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }

    /**
     * The doReceiveAndExecute() method has to be overriden to support multiple-message receives.
     * 
     * @param status
     *            intentionally unused
     */
    @Override
    protected boolean doReceiveAndExecute(Object invoker, Session session,
            MessageConsumer consumer, TransactionStatus status)
            throws JMSException {
        Connection conToClose = null;
        MessageConsumer consumerToClose = null;
        Session sessionToClose = null;

        try {
            Session sessionToUse = session;
            MessageConsumer consumerToUse = consumer;

            if (sessionToUse == null) {
                Connection conToUse = null;
                if (sharedConnectionEnabled()) {
                    conToUse = getSharedConnection();
                } else {
                    conToUse = createConnection();
                    conToClose = conToUse;
                    conToUse.start();
                }
                sessionToUse = createSession(conToUse);
                sessionToClose = sessionToUse;
            }

            if (consumerToUse == null) {
                consumerToUse = createListenerConsumer(sessionToUse);
                consumerToClose = consumerToUse;
            }

            List<Message> messages = new ArrayList<Message>();

            int count = 0;
            Message message = null;
            // Attempt to receive messages with the consumer
            do {
                message = receiveMessage(consumerToUse);
                if (message != null) {
                    messages.add(message);
                }
            }
            // Exit loop if no message was received in the time out specified, or
            // if the max batch size was met
            while ((message != null) && (++count < batchSize));

            if (messages.size() > 0) {
                // Only if messages were collected, notify the listener to consume the same.
                try {
                    doExecuteListener(sessionToUse, messages);
                    sessionToUse.commit();
                } catch (Throwable ex) {
                    handleListenerException(ex);
                    if (ex instanceof JMSException) {
                        throw (JMSException) ex;
                    }
                }
                return true;
            }

            // No message was received for the period of the timeout, return false.
            noMessageReceived(invoker, sessionToUse);
            return false;
        } finally {
            JmsUtils.closeMessageConsumer(consumerToClose);
            JmsUtils.closeSession(sessionToClose);
            ConnectionFactoryUtils.releaseConnection(conToClose,
                    getConnectionFactory(), true);
        }
    }

    protected void doExecuteListener(Session session, List<Message> messages)
            throws JMSException {
        if (!isAcceptMessagesWhileStopping() && !isRunning()) {
            if (logger.isWarnEnabled()) {
                logger.warn("Rejecting received messages because of the listener container "
                        + "having been stopped in the meantime: " + messages);
            }
            rollbackIfNecessary(session);
            throw new JMSException(
                    "Rejecting received messages as listener container is stopping");
        }

        @SuppressWarnings("unchecked")
        SessionAwareBatchMessageListener<Message> lsnr =
                (SessionAwareBatchMessageListener<Message>) getMessageListener();

        try {
            lsnr.onMessages(session, messages);
        } catch (JMSException ex) {
            rollbackOnExceptionIfNecessary(session, ex);
            throw ex;
        } catch (RuntimeException ex) {
            rollbackOnExceptionIfNecessary(session, ex);
            throw ex;
        } catch (Error err) {
            rollbackOnExceptionIfNecessary(session, err);
            throw err;
        }
    }

    @Override
    protected void checkMessageListener(Object messageListener) {
        if (!(messageListener instanceof SessionAwareBatchMessageListener)) {
            throw new IllegalArgumentException(
                    "Message listener needs to be of type ["
                            + SessionAwareBatchMessageListener.class.getName()
                            + "]");
        }
    }

    @Override
    protected void validateConfiguration() {
        if (batchSize <= 0) {
            throw new IllegalArgumentException(
                    "Property batchSize must be a value greater than 0");
        }
    }
}