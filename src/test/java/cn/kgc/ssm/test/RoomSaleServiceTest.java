package cn.kgc.ssm.test;

import cn.kgc.ssm.entity.RoomSale;
import cn.kgc.ssm.service.RoomSaleService;
import cn.kgc.ssm.service.impl.RoomSaleServiceImpl;
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
public class RoomSaleServiceTest {

    //日志对象
    private static final Logger log = LogManager.getLogger(RoomSaleServiceTest.class);

    //依赖引入员工业务层对象
    private RoomSaleService roomSaleService;

    //读取spring.xml文件
    @Before
    public void init() {
        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("spring-main.xml");
        roomSaleService = cxt.getBean("roomSaleServiceImpl", RoomSaleServiceImpl.class);
    }

    //测试分页
    @Test
    public void test01(){
        RoomSale roomSalePra = new RoomSale();
        try {
            Map<String,Object> map = roomSaleService.findPageTByPramas(1,3,roomSalePra);
            log.info(map.get("count"));
            List<RoomSale> roomSales = (List<RoomSale>) map.get("data");
            for (RoomSale roomSale:roomSales) {
                log.info(roomSale);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
