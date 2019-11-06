package com.rl.shiro;

import com.rl.model.User;
import com.rl.service.PermissionService;
import com.rl.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        //给资源授权
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        //获取当前登陆的用户主体
        User user = (User)subject.getPrincipal();
        System.out.println(user.getAge());
        //查询当前用户的所有权限路径
        List<String> urlList =  permissionService.selectPermsUrlListById(user.getId());
        System.out.println(urlList);
       for (String url : urlList) {
           //给当前用户进行资源授权
            simpleAuthorizationInfo.addStringPermission(url);
        }
        return simpleAuthorizationInfo;
                }

/**
 * 认证
 * @param authenticationToken
 * @return
 * @throws AuthenticationException
 */
@Override
protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        //编写shiro判断逻辑，就是判断账号密码
        //判断,UsernamePasswordToken就是前端接收的用户名和密码
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        User user = userService.selectByName(token.getUsername());
        if(user == null){
        //用户不存在
        return null;
        }
        //判断密码，返回AuthenticationInfo子类
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
        }
        }
