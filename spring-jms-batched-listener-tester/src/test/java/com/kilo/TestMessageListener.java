
package com.kilo;

import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMessageListener implements MessageListener,
        SessionAwareBatchMessageListener<Message> {

    private static final Logger LOG = LoggerFactory
            .getLogger(TestMessageListener.class);

    @Override
    public void onMessage(Message message) {
        LOG.info("Received single message: {}", message);
    }

    /**
     * {@inheritDoc}
     * 
     * @param session
     *            intentionally unused
     */
    @Override
    public void onMessages(Session session, List<Message> messages)
            throws JMSException {
        LOG.info("Received bulk messages ({}): {}", messages.size(), messages);
    }

}
