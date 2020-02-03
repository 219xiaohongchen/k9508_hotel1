package cn.kgc.ssm.service.impl;

import cn.kgc.ssm.entity.Authority;
import cn.kgc.ssm.entity.Roles;
import cn.kgc.ssm.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 *   角色业务层实现类
 */
@Service
@Transactional(readOnly = false)
public class RoleServiceImpl extends BaseServiceImpl<Roles> implements RoleService {

    //重写角色的分页的方法
    @Override
    public Map<String, Object> findPageTByPramas(Integer page, Integer limit, Roles roles) throws Exception {
        Map<String, Object> map =  super.findPageTByPramas(page, limit, roles);
        //取出数据集合
        List<Roles> rolesList = (List<Roles>) map.get("data");
        //对角色集合进行遍历分别获取其权限
        for (Roles role:rolesList) {  //角色id 1
            //根据角色id查询其一级权限  权限：入住管理   订单管理   会员管理   客房管理  系统用户管理  数据统计
            List<Authority> authorities = authorityMapper.selAuthByRoleIdAndParent(role.getId(),0);
            String authNames = "";
            for (Authority auth:authorities) {  //入住管理，订单管理，会员管理，客房管理 ，系统用户管理，数据统计
                authNames += auth.getAuthorityName() + "，";
            }
            //将最后逗号去掉
            authNames = authNames.substring(0,authNames.length()-1);
            //将权限的名称字符串重新设置到角色对象中
            role.setAuthNames(authNames);
        }
        return map;
    }
}
