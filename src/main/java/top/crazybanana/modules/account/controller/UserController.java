package top.crazybanana.modules.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.crazybanana.domain.common.R;
import top.crazybanana.domain.modules.account.User;
import top.crazybanana.modules.account.service.UserService;
import top.crazybanana.modules.account.service.impl.UserServiceImpl;
import top.crazybanana.modules.base.controller.BaseController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    @RequestMapping("/list")
    public R list(){
        List<User> users = ((UserServiceImpl)userService).getAll();
        return R.ok(users);
    }
}
