
package com.kilo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A vanilla test class
 */
public class FirstVanillaTest extends BaseTest {

    private static Logger LOG = LoggerFactory.getLogger(FirstVanillaTest.class);

    @Test
    public void test() {
        LOG.info("Running vanilla test");
    }
}
