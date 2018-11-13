package com.pb.news.servlet;

import com.pb.news.dao.vo.UserMapperExt;
import com.pb.news.entity.User;
import com.pb.news.services.RoleService;
import com.pb.news.services.UserService;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by cdyoue on 2016/10/21.
 */

public class ShiroRealm extends AuthorizingRealm {
    //private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserMapperExt userMapperExt;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //logger.info("doGetAuthorizationInfo+"+principalCollection.toString());

        //username:principalCollection.getPrimaryPrincipal()
        User user = userService.getUserByUserName((String) principalCollection.getPrimaryPrincipal());

        User test2 = userMapperExt.test2();
        //List<Map<String,Object>> test = userMapperExt.test();


        //获取role
        List<Map<String,Object>> roleList = new ArrayList<>();
        //roleList = roleService.getRolesByUser(user.getId());

        //获取permission
        List<Map<String,Object>> permissionList = new ArrayList<>();
        permissionList = roleService.getRolesPermissionByUser(user.getId());

        //把principals放session中 key=userId value=principals
        SecurityUtils.getSubject().getSession().setAttribute(String.valueOf(user.getId()),SecurityUtils.getSubject().getPrincipals());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //赋予角色
        //Set<String> roleNameSet = new HashSet<>();
        /*if(roleList.size() > 0){
            for (Iterator<Map<String, Object>> iterator = roleList.iterator(); iterator.hasNext(); ) {
                Map<String, Object> next = iterator.next();
                String roleName = (String) next.get("rname");
                if(StringUtils.isNoneBlank(roleName)){
                    info.addRole(roleName);
                }
            }
        }*/

        //赋予权限和角色
        if(permissionList.size() > 0){
            for (Iterator<Map<String, Object>> iterator = permissionList.iterator(); iterator.hasNext(); ) {
                Map<String, Object> next = iterator.next();
                String roleName = (String) next.get("rname");
                String pname = (String) next.get("pname");
                if(StringUtils.isNoneBlank(roleName)){
                    info.addRole(roleName);
                }
                if(StringUtils.isNoneBlank(pname)){
                    info.addStringPermission(pname);
                }
            }
        }
       /* for(Permission permission:permissionService.getByUserId(user.getId())){
//            if(StringUtils.isNotBlank(permission.getPermCode()))
                info.addStringPermission(permission.getName());
        }*/

        //设置登录次数、时间
//        userService.updateUserLogin(user);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //logger.info("doGetAuthenticationInfo +"  + authenticationToken.toString());

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName=token.getUsername();
       // logger.info(userName+token.getPassword());

        User user = userService.getUserByUserName(token.getUsername());
        if (user != null) {
//            byte[] salt = Encodes.decodeHex(user.getSalt());
//            ShiroUser shiroUser=new ShiroUser(user.getId(), user.getLoginName(), user.getName());
            //设置用户session
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("user", user);
            return new SimpleAuthenticationInfo(userName,user.getPassword(),getName());
        } else {
            return null;
        }
//        return null;
    }

}
