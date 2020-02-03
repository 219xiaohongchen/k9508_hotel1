package cn.kgc.ssm.service.impl;

import cn.kgc.ssm.entity.RoomType;
import cn.kgc.ssm.service.RoomTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *   房屋类型实现类
 */
@Service
@Transactional(readOnly = false)
public class RoomTypeServiceImpl extends BaseServiceImpl<RoomType> implements RoomTypeService {
}
