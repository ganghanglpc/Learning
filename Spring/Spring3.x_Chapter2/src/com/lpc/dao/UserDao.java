package com.lpc.dao;

import com.lpc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserDao有三个方法：
 * 1：根据用户名和密码获取匹配的用户数。等于1表示用户名/密码正确，0表示错误。
 * 2：根据用户名获取User对象
 * 3：更新用户积分，最后登录IP及时间。
 *
 * 这里使用JDBC技术实现。
 */
@Repository    //通过Spring定义的Dao
public class UserDao {

    @Autowired   //自动注入JdbcTemplate的Bean
    private JdbcTemplate jdbcTemplate;

    public int getMatchCount(String userName,String password){
        String sqlStr = "select count(*) from t_user where user_name = ? and password = ?";
        return jdbcTemplate.queryForInt(sqlStr,new Object[]{userName,password});
    }

    public User findUserByUserName(final String userName){
        String sqlStr = "select user_id,user_name,credits from t_user where user_name = ?";
        final  User user = new User();
                   //匿名类方式实现回调函数。
        jdbcTemplate.query(sqlStr, new Object[]{userName},
                new RowCallbackHandler() {
                    @Override
                    public void processRow(ResultSet resultSet) throws SQLException {
                        user.setUserId(resultSet.getInt("user_id"));
                        user.setUserName(userName);
                        user.setCredits(resultSet.getInt("credits"));
                    }
                });
        return user;
    }

    public void updateLoginInfo(User user){
        String sqlStr = "update t_user set last_visit = ?,last_ip=?,credits=? where user_id = ?";
        jdbcTemplate.update(sqlStr,new Object[]{user.getLastVisit(),user.getLastIp(),user.getCredits(),user.getUserId()});
    }
}
