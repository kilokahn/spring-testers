/*
 * SimpleBean.java
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

public class SimpleBean {

    private static Logger LOG = Logger.getLogger(SimpleBean.class);

    private String property1;

    private String property2;

    private String property3;

    private String property4;

    public void doSimpleThings() {
        LOG.info("I have done something simple for " + property1 + " "
                + property2 + " " + property3 + " " + property4);
    }

    public void setProperty1(String property1) {
        this.property1 = property1;
    }

    public void setProperty2(String property2) {
        this.property2 = property2;
    }

    public void setProperty3(String property3) {
        this.property3 = property3;
    }

    public void setProperty4(String property4) {
        this.property4 = property4;
    }
}
