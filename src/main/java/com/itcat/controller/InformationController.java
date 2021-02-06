package com.itcat.controller;

import com.itcat.entity.Information;
import com.itcat.entity.Replies;
import com.itcat.service.InformationService;
import com.itcat.service.RepliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class InformationController {
    @Autowired
    private InformationService informationService;

    @Autowired
    private RepliesService repliesService;
    /**
     * 展示所有资讯信息
     * @return
     */
    @RequestMapping("/phone")
    public ModelAndView queryAllInformation(){
        List<Information> informations = informationService.queryAllInformation();
//        for (Information item : informations) {
//            System.out.println(item.getTitle());
//        }
        ModelAndView modelAndView = new ModelAndView("index", "informations", informations);
        return modelAndView;
    }

    /**
     * 修改指定资讯的回复次数和最后回复时间
     * @param informationId
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/reply")
    public void newReply(@RequestParam(value = "informationId") int informationId, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //新增回复内容
        request.setCharacterEncoding("utf-8");
        String replyContent = request.getParameter("new-reply");
        //当前时间
        Date date = new Date();
        //创建replies对象，用于保存新增回复信息
        Replies replies = new Replies();
        replies.setContent(replyContent);
        replies.setInfold(informationId);
        replies.setReplyTime(date);

        //插入数据库
        repliesService.saveReplies(replies);
        //修改指定资讯的回复次数和最后回复时间
        informationService.updateInformationReplyCountAndLastReplyTime(informationId);
        String path = "details?informationId="+informationId;
        response.sendRedirect(path);
    }
}
