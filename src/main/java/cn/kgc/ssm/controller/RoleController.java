package cn.kgc.ssm.controller;

import cn.kgc.ssm.entity.Roles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *   角色控制器
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController<Roles> {

}
