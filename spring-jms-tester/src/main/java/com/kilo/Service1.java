/*
 * Service1.java
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

//@formatter:off
/**
 * @author baigm
 * @version $Id: eclipse-codetemplates.xml 413456 2010-08-10 07:03:38Z baigm $
 */
//@formatter:on
public class Service1 {

    private static Logger LOG = Logger.getLogger(Service1.class);

    private DAO1 dao1;

    public void foo(String str) {
        LOG.info("Am in Service1 for input " + str);
        dao1.foo(str);
    }

    public void setDao1(DAO1 dao1) {
        this.dao1 = dao1;
    }
}
