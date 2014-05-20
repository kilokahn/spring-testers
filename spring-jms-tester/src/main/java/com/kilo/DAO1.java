
package com.kilo;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class DAO1 extends JdbcDaoSupport {

    public void foo(String str) {
        getJdbcTemplate().update("INSERT INTO temp_mb(col) VALUES(?)",
                new Object[] { str });
    }

}
