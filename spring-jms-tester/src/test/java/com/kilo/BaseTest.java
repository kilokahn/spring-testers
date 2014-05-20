
package com.kilo;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/com/kilo/spring/logging.xml",
        "/com/kilo/spring/applicationContext.xml" })
public abstract class BaseTest {

}
