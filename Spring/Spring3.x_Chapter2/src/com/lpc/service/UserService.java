package com.lpc.service;

import com.lpc.dao.LoginLogDao;
import com.lpc.dao.UserDao;
import com.lpc.domain.LoginLog;
import com.lpc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 在业务层中看不到事务的影子，这正是Spring的高明之处。
 * 在实际的情形中，不会直接保存用户的密码，而是用MD5摘要比较多，无法反推出原密码。
 */
@Service //将UserService注解为一个容器中的Bean
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginLogDao loginLogDao;

    public boolean hasMatchUser(String userName,String password){
        int matchCount = userDao.getMatchCount(userName,password);
        return matchCount > 0;
    }

    public User findUserByUserName(String userName){
        return userDao.findUserByUserName(userName);
    }

    public void loginSuccess(User user){
        user.setCredits(5 + user.getCredits());
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
    }
}
