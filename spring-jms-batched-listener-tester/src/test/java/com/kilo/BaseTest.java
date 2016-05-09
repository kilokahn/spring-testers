
package com.kilo;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "/com/kilo/spring/test-applicationContext.xml",
        "/com/kilo/spring/logging.xml" })
public class BaseTest {

}
