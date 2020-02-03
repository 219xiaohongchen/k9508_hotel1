package cn.kgc.ssm.service.impl;

import cn.kgc.ssm.entity.RoomSale;
import cn.kgc.ssm.service.RoomSaleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *   消费记录业务层实现类
 */
@Service
@Transactional(readOnly = false)
public class RoomSaleServiceImpl extends BaseServiceImpl<RoomSale> implements RoomSaleService {

    //查询房间的销售金额,返回Map
    @Override
    public Map<String, List<Object>> findPriceByRoomNum() throws Exception {
        List<Map<String,Object>> mapList = roomSaleMapper.selPriceByRoomNum();
        //房间编号的list集合
        List<Object> roomNumList = new ArrayList<Object>();
        //房间的销售金额list集合
        List<Object> salePriceList = new ArrayList<Object>();
        for (Map<String,Object> map:mapList) {  //map： room_num:8201  salePrice:1900.0
            //存房间编号
            roomNumList.add((String)map.get("room_num"));
            //存房间的销售金额
            salePriceList.add((Double) map.get("saleprices"));
        }
        //新建响应回页面的map集合
        Map<String, List<Object>> listMap = new HashMap<String, List<Object>>();
        //分别将数据装入到集合中
        listMap.put("roomNumList",roomNumList);
        listMap.put("salePriceList",salePriceList);
        return listMap;
    }
}
