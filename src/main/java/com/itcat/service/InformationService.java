package com.itcat.service;

import com.itcat.entity.Information;

import java.util.List;

public interface InformationService {
    /**
     * 查询所有资讯并根据最后回复时间降序排列
     * @return
     */
    List<Information> queryAllInformation();

    /**
     * 根据资讯id查询资讯信息
     * @param id
     * @return
     */
    Information queryInformation(int id);

    /**
     * 修改指定资讯的查看次数
     * @param id
     */
    void updateInformationViewCount(int id);

    /**
     * 修改指定资讯的回复次数和最后回复时间
     * @param id
     */
    void updateInformationReplyCountAndLastReplyTime(int id);
}
