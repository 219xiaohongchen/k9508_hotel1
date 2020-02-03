package cn.kgc.ssm.test;

import cn.kgc.ssm.entity.Vip;
import cn.kgc.ssm.service.VipService;
import cn.kgc.ssm.service.impl.VipServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *   订单测试类
 */
public class VipServiceTest {

    //日志对象
    private static final Logger log = LogManager.getLogger(VipServiceTest.class);

    //依赖引入员工业务层对象
    private VipService vipService;

    //读取spring.xml文件
    @Before
    public void init() {
        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("spring-main.xml");
        vipService = cxt.getBean("vipServiceImpl", VipServiceImpl.class);
    }

    //测试根据条件查询数据条数
    @Test
    public void test01(){
        Vip vip = new Vip();
        vip.setIdcard("421123198912120012");
        try {
            Integer count = vipService.getCountByPramas(vip);
            System.out.println("数据条数为："+count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
