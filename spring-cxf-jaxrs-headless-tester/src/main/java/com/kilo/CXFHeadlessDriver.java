/*
 * CXFHeadlessDriver.java
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

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@formatter:off
/**
 * @author baigm
 * @version $Id: eclipse-codetemplates.xml 413456 2010-08-10 07:03:38Z baigm $
 */
//@formatter:on
public class CXFHeadlessDriver {

    private static Logger LOG = Logger.getLogger(CXFHeadlessDriver.class);

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext(
                "classpath:com/kilo/cxf/logging.xml",
                "classpath:com/kilo/cxf/applicationContext.xml");
        LOG.info("Inited");
    }

}
