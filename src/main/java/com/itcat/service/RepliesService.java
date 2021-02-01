package com.itcat.service;

import com.itcat.entity.Replies;

import java.util.List;

public interface RepliesService {
    /**
     * 查询指定资讯的全部回复信息
     * @param id
     * @return
     */
    List<Replies> queryAllReplies(int id);

    /**
     * 保存回复信息
     */
    void saveReplies(Replies replies);
}
