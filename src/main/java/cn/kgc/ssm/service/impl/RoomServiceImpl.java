package cn.kgc.ssm.service.impl;

import cn.kgc.ssm.entity.Rooms;
import cn.kgc.ssm.service.RoomService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *   房屋的业务层实现类
 */
@Service
@Transactional(readOnly = false)
public class RoomServiceImpl extends BaseServiceImpl<Rooms> implements RoomService {

}
