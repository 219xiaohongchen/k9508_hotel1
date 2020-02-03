package cn.kgc.ssm.test;

import cn.kgc.ssm.entity.Authority;
import cn.kgc.ssm.entity.User;
import cn.kgc.ssm.service.AuthService;
import cn.kgc.ssm.service.impl.AuthServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

/**
 *   订单测试类
 */
public class AuthServiceTest {

    //日志对象
    private static final Logger log = LogManager.getLogger(AuthServiceTest.class);

    //依赖引入员工业务层对象
    private AuthService authService;

    //读取spring.xml文件
    @Before
    public void init() {
        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("spring-main.xml");
        authService = cxt.getBean("authServiceImpl", AuthServiceImpl.class);
    }

    //测试登陆后查询菜单权限
    @Test
    public void test01(){
        User loginUser = new User();
        loginUser.setRoleId(1);
        try {
            List<Map<String, Object>> listMap = authService.findAuthByLogin(loginUser);
            for (Map<String, Object> map:listMap) {
                log.info("一级权限名称："+map.get("pName")+"\t\t"+"一级权限id："+map.get("pId"));
                List<Authority> secAuths = (List<Authority>) map.get("secAuths");
                for (Authority secAuth:secAuths) {
                    log.info(secAuth);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
