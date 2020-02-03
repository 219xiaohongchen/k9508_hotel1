package cn.kgc.ssm.service.impl;

import cn.kgc.ssm.entity.Vip;
import cn.kgc.ssm.service.VipService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *   vip业务层的实现类
 */
@Service
@Transactional(readOnly = false)
public class VipServiceImpl extends BaseServiceImpl<Vip> implements VipService {

}
