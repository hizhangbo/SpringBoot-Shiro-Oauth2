package top.crazybanana.modules.account.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.crazybanana.domain.common.R;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/home")
public class HomeController {

    protected static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public R login(String username, String password){

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            logger.info(String.format("%s 登录成功", username));
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(403, e.getMessage());
        }
        return R.ok();
    }
}
