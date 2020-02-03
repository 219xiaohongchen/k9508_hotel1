package cn.kgc.ssm.service;

import cn.kgc.ssm.entity.RoomSale;

import java.util.List;
import java.util.Map;

/**
 *   消费记录的业务层接口
 */
public interface RoomSaleService extends BaseService<RoomSale> {

    //查询房间的销售金额,返回Map
    Map<String, List<Object>> findPriceByRoomNum() throws Exception;
}
