/*
 * BaseTest.java
 * 
 * $HeadURL: $
 * $Id: eclipse-codetemplates.xml 413456 2010-08-10 07:03:38Z baigm $
 */

/*
 * Copyright (c) 2012 D. E. Shaw & Co., L.P. All rights reserved.
 *  
 * This software is the confidential and proprietary information
 * of D. E. Shaw & Co., L.P. ("Confidential Information").  You
 * shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with D. E. Shaw & Co., L.P.
 */

package com.kilo;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@formatter:off
/**
 * Base class for tests
 * 
 * @author baigm
 * @version $Id: eclipse-codetemplates.xml 413456 2010-08-10 07:03:38Z baigm $
 */
//@formatter:on
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/com/kilo/spring/logging.xml",
        "/com/kilo/spring/applicationContext.xml" })
public abstract class BaseTest {

}
