package com.xf.config;

import com.xf.mapper.AccountMapper;
import com.xf.pojo.Account;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    AccountMapper accountMapper;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //认证
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        Account account = accountMapper.Logincheck(usernamePasswordToken.getUsername());
        //如果token中存的username在数据库中找不到,返回空
        if (account==null){
            return null;
        }

        //找到了username就进行认证
        //三个参数分别为Principal/密码/realmName
        //principal要传入实体类账户对象,作为当前登录的用户信息
        return new SimpleAuthenticationInfo(account,account.getPassword(),"");
    }
}
