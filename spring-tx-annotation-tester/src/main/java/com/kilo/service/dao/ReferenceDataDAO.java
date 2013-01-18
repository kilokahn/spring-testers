
package com.kilo.service.dao;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class ReferenceDataDAO extends SqlMapClientDaoSupport {
    private static final Logger LOG = Logger.getLogger(ReferenceDataDAO.class);

    public void putReferenceData() {
        LOG.info("Getting reference data");
        Date date = (Date) getSqlMapClientTemplate().queryForObject(
                "ReferenceData.putReferenceData");
        System.out.println(date);
        throw new UnsupportedOperationException();
    }

}
