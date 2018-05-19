package top.crazybanana.modules.base.controller;

import org.apache.shiro.SecurityUtils;
import top.crazybanana.domain.modules.account.User;

public abstract class BaseController {

    public User getCurrentUser(){

        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        return user;
    }
}
