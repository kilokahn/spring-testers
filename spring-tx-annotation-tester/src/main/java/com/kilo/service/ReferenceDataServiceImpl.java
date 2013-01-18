
package com.kilo.service;

import org.springframework.transaction.annotation.Transactional;

import com.kilo.service.dao.ReferenceDataDAO;

public class ReferenceDataServiceImpl implements ReferenceDataService {

    private ReferenceDataDAO referenceDataDAO;

    private ReferenceDataDAO referenceDataDAO2;

    @Override
    @Transactional
    public void putReferenceData() {
        referenceDataDAO.putReferenceData();
    }

    @Override
    @Transactional
//    @Transactional(value = "dataSource2Related")
    public void getReferenceData2() {
        referenceDataDAO2.putReferenceData();
    }

    public void setReferenceDataDAO(ReferenceDataDAO referenceDataDAO) {
        this.referenceDataDAO = referenceDataDAO;
    }

    public void setReferenceDataDAO2(ReferenceDataDAO referenceDataDAO2) {
        this.referenceDataDAO2 = referenceDataDAO2;
    }

}
