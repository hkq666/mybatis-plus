package com.hkq.mybatisplus.service;

import com.hkq.mybatisplus.domain.TestGoods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hkq.mybatisplus.domain.TestUser;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huangkaiqiang
 * @since 2020-09-10
 */
public interface TestGoodsService extends IService<TestGoods> {

    TestGoods findById(TestUser testUser);
}
