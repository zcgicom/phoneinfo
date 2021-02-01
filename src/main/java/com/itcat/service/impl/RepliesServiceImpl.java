package com.itcat.service.impl;

import com.itcat.dao.RepliesDao;
import com.itcat.entity.Replies;
import com.itcat.service.RepliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RepliesServiceImpl implements RepliesService {
    @Autowired
    private RepliesDao repliesDao;
    @Override
    public List<Replies> queryAllReplies(int id) {
        return repliesDao.queryAllReplies(id);
    }

    @Override
    public void saveReplies(Replies replies) {
        repliesDao.saveReplies(replies);
    }
}
