package com.nowcoder.service;

import com.nowcoder.dao.LoginTicketDAO;
import com.nowcoder.dao.UserDAO;
import com.nowcoder.model.LoginTicket;
import com.nowcoder.model.User;
import com.nowcoder.model.Voteoption;
import com.nowcoder.util.ToutiaoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang.StringUtils;

import java.util.*;

/**
 * Created by nowcoder on 2016/7/2.
 */
@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    LoginTicketDAO loginTicketDAO;

    public User getUser(int id) {
        return userDAO.selectById(id);
    }
    public String addLoginTicket(int userId){
        LoginTicket ticket = new LoginTicket();
        Date date = new Date();
        date.setTime(date.getTime() + 1000*3600*24);
        ticket.setUserId(userId);
        ticket.setExpired(date);
        ticket.setStatus(0);
        ticket.setTicket(UUID.randomUUID().toString().replace("-",""));
        loginTicketDAO.addTicket(ticket);
        return ticket.getTicket();
    }
    public Map<String,Object> register(String username, String password){
        Map<String,Object> map = new HashMap<String, Object>();
        if(StringUtils.isBlank(username)){
            map.put("msgname","用户名不能为空");
            return map;
        }
        if(StringUtils.isBlank(password)){
            map.put("msgpwd","密码不能为空");
            return map;
        }
        User user = userDAO.selectByName(username);

        if(user != null){
            map.put("msgname","用户名已经被注册");
            return map;
        }
        user = new User();
        user.setUserName(username);
        user.setPassWord(password);
        userDAO.addUser(user);

        String ticket = addLoginTicket(user.getId());
        map.put("ticket",ticket);
        return map;
    }
    public Map<String,Object> login(String username, String password){
        Map<String,Object> map = new HashMap<String, Object>();
        if(StringUtils.isBlank(username)){
            map.put("msgname","用户名不能为空");
            return map;
        }
        if(StringUtils.isBlank(password)){
            map.put("msgpwd","密码不能为空");
            return map;
        }
        User user = userDAO.selectByName(username);
        System.out.print(user.getId());
        if(user == null){
            map.put("msgname","用户名不存在");
            return map;
        }
        if(!(password).equals(user.getPassWord())){
            map.put("msgpwd","密码不正确");
            return map;
        }

        System.out.print(user.getId());
        String ticket = addLoginTicket(user.getId());
        map.put("ticket",ticket);
        return map;
    }
    public List<User> getLatestUsers(String userName) {
        return userDAO.selectByuserName(userName);
    }
    public void logout(String ticket){
        loginTicketDAO.updateStatus(ticket,1);
    }
    public void deleteByuserId(int userId){
        userDAO.deleteById(userId);
    }

}
