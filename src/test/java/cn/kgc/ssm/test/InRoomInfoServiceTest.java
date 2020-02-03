package cn.kgc.ssm.test;

import cn.kgc.ssm.entity.InRoomInfo;
import cn.kgc.ssm.service.InRoomInfoService;
import cn.kgc.ssm.service.impl.InRoomInfoServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

/**
 *   房屋入住信息业务层测试类
 */
public class InRoomInfoServiceTest {

    //日志对象
    private static final Logger log = LogManager.getLogger(InRoomInfoServiceTest.class);

    //依赖引入员工业务层对象
    private InRoomInfoService inRoomInfoService;

    //读取spring.xml文件
    @Before
    public void init() {
        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("spring-main.xml");
        inRoomInfoService = cxt.getBean("inRoomInfoServiceImpl", InRoomInfoServiceImpl.class);
    }

    //测试根据条件查询入住信息数据
    @Test
    public void test01(){
        InRoomInfo inRoomInfoPra = new InRoomInfo();
        try {
            Map<String, Object> map = inRoomInfoService.findPageTByPramas(1, 2, inRoomInfoPra);
            log.info("总的数据条数："+map.get("count")+"条");
            List<InRoomInfo> inRoomInfos = (List<InRoomInfo>) map.get("data");
            for (InRoomInfo inRoomInfo:inRoomInfos) {
                log.info(inRoomInfo);
                log.info(inRoomInfo.getRooms());
                log.info(inRoomInfo.getRooms().getRoomType());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
