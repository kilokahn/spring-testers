/*
 * DAO1.java
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

import org.springframework.jdbc.core.support.JdbcDaoSupport;

//@formatter:off
/**
 * @author baigm
 * @version $Id: eclipse-codetemplates.xml 413456 2010-08-10 07:03:38Z baigm $
 */
//@formatter:on
public class DAO1 extends JdbcDaoSupport {

    public void foo(String str) {
        getJdbcTemplate().update("INSERT INTO temp_mb(col) VALUES(?)",
                new Object[] { str });
    }

}
