package com.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gulimall.common.utils.PageUtils;
import com.gulimall.coupon.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author Banana69
 * @email junminn@126.com
 * @date 2023-02-10 22:16:00
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

