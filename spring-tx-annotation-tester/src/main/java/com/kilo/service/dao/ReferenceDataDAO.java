
package com.kilo.service.dao;

import java.util.Date;

import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class ReferenceDataDAO extends SqlSessionDaoSupport {
    private static final Logger LOG = Logger.getLogger(ReferenceDataDAO.class);

    public void putReferenceData() {
        LOG.info("Getting reference data");
        Date date = getSqlSession().selectOne("ReferenceData.putReferenceData");
        System.out.println(date);
        throw new UnsupportedOperationException();
    }

}
