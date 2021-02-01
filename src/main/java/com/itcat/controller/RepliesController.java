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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class RepliesController {
    @Autowired
    private RepliesService repliesService;
    @Autowired
    private InformationService informationService;
    /**
     * 查询指定资讯的全部回复信息
     * @param informationId
     * @return
     */
    @RequestMapping("/details")
    public ModelAndView checkDetails(@RequestParam(value = "informationId") int informationId){
        //更新当前资讯查看次数
        informationService.updateInformationViewCount(informationId);

        //获取全部回复信息
        List<Replies> replies = repliesService.queryAllReplies(informationId);
//        for (Replies item : replies) {
//            System.out.println(item.getContent());
//        }
        //获取当前资讯详情
        Information information = informationService.queryInformation(informationId);

        //保存当前资讯详情和相关回复信息
        HashMap<String, Object> map = new HashMap<>();
        map.put("replies",replies);
        map.put("information",information);

        //跳转页面
        ModelAndView modelAndView = new ModelAndView("details", "detailsMap", map);
        return modelAndView;
    }
}
