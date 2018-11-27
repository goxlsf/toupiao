package com.nowcoder.dao;

import com.nowcoder.model.User;
import com.nowcoder.model.Voteoption;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by nowcoder on 2016/7/2.
 */
@Mapper
public interface UserDAO {
    String TABLE_NAME = "user";
    String INSET_FIELDS = " UserName, PassWord ";
    String SELECT_FIELDS = " Userid, UserName, PassWord  ";

    @Insert({"insert into ",TABLE_NAME, "(",INSET_FIELDS,")values (#{UserName},#{PassWord})"})
    int addUser(User user);

    List<User> selectByuserName(@Param("userName") String userName);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where Userid=#{id}"})
    User selectById(int id);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where UserName=#{name}"})
    User selectByName(String name);

    @Update({"update ", TABLE_NAME, " set PassWord=#{password}, where Userid=#{id}"})
    void updatePassword(User user);

    @Delete({"delete from ", TABLE_NAME, " where Userid=#{id}"})
    void deleteById(int id);
}
