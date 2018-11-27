package com.nowcoder.controller;

import com.nowcoder.model.HostHolder;
import com.nowcoder.model.ViewObject;
import com.nowcoder.model.Voteoption;
import com.nowcoder.service.VoteService;
import com.nowcoder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {
    @Autowired
    VoteService voteService;

    @Autowired
    UserService userService;

    @Autowired
    HostHolder hostHolder;

    private List<ViewObject> getNews(int questionId) {
        List<Voteoption> voteList = voteService.getLatestNews(questionId);

        List<ViewObject> vos = new ArrayList<>();
        for (Voteoption votes : voteList) {
            ViewObject vo = new ViewObject();
            vo.set("votes", votes);
            vos.add(vo);
        }
        return vos;
    }

    private List<ViewObject> getNewsForCount(int questionId) {
        List<Voteoption> voteList = voteService.getLatestNewsForCount(questionId);
        List<ViewObject> vos = new ArrayList<>();
        for (Voteoption votes : voteList) {
            ViewObject vo = new ViewObject();
            vo.set("votes", votes);
            vos.add(vo);
        }
        return vos;
    }

    @RequestMapping(path = {"/"}, method = {RequestMethod.GET, RequestMethod.POST})

    public String index(Model model,@RequestParam(value = "pop",defaultValue = "0") int pop) {

        return "home";
    }


    @RequestMapping("/index")
    @ResponseBody
    public List<Voteoption> getUserListPage(String questionName,HttpServletRequest request){
        List<Voteoption> list = voteService.getVoteListPage(questionName);
        return list;
    }
    @RequestMapping("/index1")
    @ResponseBody
    public List<Voteoption> getUserListPage1(String questionName,HttpServletRequest request){
        List<Voteoption> list = voteService.getVoteListPage1(questionName);
        return list;
    }

/*
    @RequestMapping(path = {"/user/{userId}/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String userIndex(Model model, @PathVariable("userId") int userId) {
        model.addAttribute("vos", getNews(userId, 0, 10));
        return "home";
    }

*/

}
