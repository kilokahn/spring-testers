
package com.kilo;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageListenerTest extends BaseTest {

    private static final Logger LOG = LoggerFactory
            .getLogger(MessageListenerTest.class);

    @Resource(name = "testMessageListener")
    private TestMessageListener testMessageListener;

    @Test
    public void test() throws InterruptedException {
        LOG.info("Running the test case and waiting for background threads to listen to messages");
        Thread.sleep(60 * 1_000);
    }

}
