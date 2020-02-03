package cn.kgc.ssm.service;

import cn.kgc.ssm.entity.Authority;
import cn.kgc.ssm.entity.User;

import java.util.List;
import java.util.Map;

/**
 *   权限业务层接口
 */
public interface AuthService extends BaseService<Authority> {

    //根据登陆后获取此用户的菜单权限菜单
    List<Map<String,Object>> findAuthByLogin(User loginUser) throws Exception;

    //根据角色id查询其权限
    List<Authority> findAuthByRoleId(Integer roleId,Integer parent) throws Exception;

}
