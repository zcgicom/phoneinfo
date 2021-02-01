package com.itcat.dao;

import com.itcat.entity.Information;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformationDao {
    /**
     * 查询所有资讯并根据最后回复时间降序排列
     * @return
     */
    @Select("select * from information")
    List<Information> queryAllInformation();

    /**
     * 根据资讯id查询资讯信息
     * @param id
     * @return
     */
    @Select("select * from information where id=#{id}")
    Information queryInformation(@Param("id") int id);

    /**
     * 修改指定资讯的查看次数
     * @param id
     */
    @Update("update information set viewCount = viewCount + 1 where id = #{id}")
    void updateInformationViewCount(@Param("id") int id);

    /**
     * 修改指定资讯的回复次数和最后回复时间
     * @param id
     */
    @Update("update information fn,(select r.replyTime from replies as r\n" +
            "   left join information as i on r.infold = i.id where r.infold = #{id} ORDER BY r.replyTime desc LIMIT 1) tt " +
            "       set fn.replyCount = fn.replyCount + 1,fn.lastPostTime = tt.replyTime where fn.id = #{id}")
    void updateInformationReplyCountAndLastReplyTime(int id);
//    update information fn,(select r.replyTime from replies as r
//    left join information as i on r.infold = i.id where r.infold = 1 ORDER BY r.replyTime desc LIMIT 1) tt set fn.replyCount = fn.replyCount + 1,fn.lastPostTime = tt.replyTime where fn.id=1
}
