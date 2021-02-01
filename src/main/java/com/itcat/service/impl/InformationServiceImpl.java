package com.itcat.service.impl;

import com.itcat.dao.InformationDao;
import com.itcat.entity.Information;
import com.itcat.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InformationServiceImpl implements InformationService {
    @Autowired
    private InformationDao informationDao;
    @Override
    public List<Information> queryAllInformation() {
        return informationDao.queryAllInformation();
    }

    @Override
    public Information queryInformation(int id) {
        return informationDao.queryInformation(id);
    }

    @Override
    public void updateInformationViewCount(int id) {
        informationDao.updateInformationViewCount(id);
    }

    @Override
    public void updateInformationReplyCountAndLastReplyTime(int id) {
        informationDao.updateInformationReplyCountAndLastReplyTime(id);
    }
}
