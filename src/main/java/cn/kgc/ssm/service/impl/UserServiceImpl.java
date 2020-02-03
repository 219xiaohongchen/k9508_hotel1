package cn.kgc.ssm.service.impl;

import cn.kgc.ssm.entity.Authority;
import cn.kgc.ssm.entity.User;
import cn.kgc.ssm.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 *   用户业务层实现类
 */
@Service
@Transactional(readOnly = false)
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    //重写用户分页的方法
    @Override
    public Map<String, Object> findPageTByPramas(Integer page, Integer limit, User user) throws Exception {
        Map<String, Object> map = super.findPageTByPramas(page, limit, user);
        //取出数据集合
        List<User> users = (List<User>) map.get("data");
        for (User u:users) {
            //根据角色id查询其一级权限  权限：入住管理   订单管理   会员管理   客房管理  系统用户管理  数据统计
            List<Authority> authorities = authorityMapper.selAuthByRoleIdAndParent(u.getRoleId(),0);
            String authNames = "";
            for (Authority auth:authorities) {  //入住管理，订单管理，会员管理，客房管理 ，系统用户管理，数据统计
                authNames += auth.getAuthorityName() + "，";
            }
            //将最后逗号去掉
            authNames = authNames.substring(0,authNames.length()-1);
            //将权限的名称字符串重新设置到角色对象中
            u.setAuthNames(authNames);
        }
        return map;
    }
}
