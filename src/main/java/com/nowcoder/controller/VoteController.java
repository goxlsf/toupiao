package com.nowcoder.controller;


import com.nowcoder.model.OptionProject;
import com.nowcoder.model.People;
import com.nowcoder.model.ViewObject;
import com.nowcoder.model.Voteoption;
import com.nowcoder.service.OptionService;
import com.nowcoder.service.PeopleService;
import com.nowcoder.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/vote")
public class VoteController {
    @Autowired
    OptionService optionService;

    @Autowired
    VoteService voteService;

    @Autowired
    PeopleService peopleService;
    private List<ViewObject> getNews(int questionId) {
        List<OptionProject> optionList = optionService.getLatestOptions(questionId);

        List<ViewObject> vos = new ArrayList<>();
        for (OptionProject ques : optionList) {
            ViewObject vo = new ViewObject();
            vo.set("ques", ques);
            vos.add(vo);
        }
        return vos;
    }
    @RequestMapping(value = "/option",method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView vote(@RequestParam(name="questionId", required = false)int queid){
        Voteoption voteoption = voteService.getOptionByid(queid);
        List<ViewObject> vos = getNews(queid);
        ModelAndView mv = new ModelAndView("addModel");
        mv.addObject("vos",vos);
        mv.addObject("vote",voteoption);
        /*model.addAttribute("vos", vos);
        model.addAttribute("vote",voteoption);*/
        return mv;
    }

    @RequestMapping(value = "/add",method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView add(){
        ModelAndView mv = new ModelAndView("addVote");
        return mv;
    }
    @RequestMapping(value = "/alter",method = {RequestMethod.GET, RequestMethod.POST})
    public String alter(Model model, @RequestParam(name="questionId", required = false)int queid){
        Voteoption voteoption = voteService.getOptionByid(queid);
        List<ViewObject> vos = getNews(queid);

        model.addAttribute("vos", vos);
        model.addAttribute("vote",voteoption);
        return "alter";

    }
    @RequestMapping(path="/chose",method = {RequestMethod.GET, RequestMethod.POST})
    public void put(Model model, @RequestParam("que") String optionid, @RequestParam("questionId")String questionId,@RequestParam("user")String user){
        OptionProject optionProject = optionService.selectOption(Integer.parseInt(optionid),Integer.parseInt(questionId));
        int i = optionProject.getCount()+1;
        optionService.updateCount(i,optionProject.getQuestionId(),optionProject.getOptionId());

        Voteoption vote = voteService.getOptionByid(Integer.parseInt(questionId));
        int j= vote.getCount()+1;
        voteService.updateCount(j,vote.getQuestionId());

        People people = new People();
        people.setOptionId(Integer.parseInt(optionid));
        people.setQuestionId(Integer.parseInt(questionId));
        people.setUserName(user);
        peopleService.addPeople(people);
    }
}
