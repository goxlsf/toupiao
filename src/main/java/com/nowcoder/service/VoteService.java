package com.nowcoder.service;

import com.nowcoder.dao.VoteDAO;
import com.nowcoder.model.Voteoption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nowcoder on 2016/7/2.
 */
@Service
public class VoteService {
    @Autowired
    private VoteDAO voteDAO;


    public void addVote(Voteoption voteoption){
        voteDAO.addNews(voteoption);
    }

    public List<Voteoption> getLatestNewsForCount(int questionId) {
        return voteDAO.selectForCount(questionId);
    }
    public List<Voteoption> getLatestNews(int questionId) {
        return voteDAO.selectByquestionId(questionId);
    }
    public List<Voteoption> getVoteListPage(String questionName){
        return voteDAO.getVoteListPage(questionName);
    }
    public List<Voteoption> getVoteListPage1(String questionName){
        return voteDAO.getVoteListPage1(questionName);
    }
    public Voteoption getOptionByid(int id){
        return voteDAO.selectById(id);
    }
    public Voteoption getOptionByName(String name){
        return voteDAO.selectByName(name);
    }
    public void updateCount(int count, int queid){
        voteDAO.updateCount(count,queid);
    }

    public void updateVote(Voteoption voteoption){
        voteDAO.updateVote(voteoption);
    }

    public void deleteOption(int queid){
        voteDAO.deleteOption(queid);
    }
}
