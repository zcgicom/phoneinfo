package com.itcat.dao;

import com.itcat.entity.Replies;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepliesDao {
    /**
     * 查询指定资讯的全部回复信息
     * @param id
     * @return
     */
    @Select("SELECT replies.id,replies.content,replies.replyTime,replies.infold from replies\n" +
            "            left join information on information.id = replies.infold\n" +
            "                where information.id = #{id}")
    List<Replies> queryAllReplies(int id);

    /**
     * 保存回复信息
     */
    @Insert("insert into replies (id,content,replyTime,infold) values (#{id},#{content},#{replyTime},#{infold})")
    void saveReplies(Replies replies);
}
