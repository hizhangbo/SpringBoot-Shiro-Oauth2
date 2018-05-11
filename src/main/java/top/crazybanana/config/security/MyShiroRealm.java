package top.crazybanana.config.security;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import top.crazybanana.domain.modules.account.User;
import top.crazybanana.modules.account.service.UserService;

public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken utoken = (UsernamePasswordToken) authenticationToken;
        String username = utoken.getUsername();
        User user = userService.getByName(username);

        return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user=(User) principalCollection.fromRealm(this.getClass().getName()).iterator().next();//获取session中的用户
//        List<String> permissions=new ArrayList<>();
//        Set<Role> roles = user.getRoles();
//        if(roles.size()>0) {
//            for(Role role : roles) {
//                Set<Module> modules = role.getModules();
//                if(modules.size()>0) {
//                    for(Module module : modules) {
//                        permissions.add(module.getMname());
//                    }
//                }
//            }
//        }
//        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
//        info.addStringPermissions(permissions);//将权限放入shiro中.
//        return info;

        SimpleAuthenticationInfo authenticationInfo =
                new SimpleAuthenticationInfo(
                        user, //用户名
                        user.getPassword(), //密码
                        getName()  //realm name
                );
        return null;
    }
}
