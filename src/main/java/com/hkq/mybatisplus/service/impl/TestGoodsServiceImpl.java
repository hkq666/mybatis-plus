package com.hkq.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hkq.mybatisplus.domain.TestGoods;
import com.hkq.mybatisplus.domain.TestUser;
import com.hkq.mybatisplus.mapper.TestGoodsMapper;
import com.hkq.mybatisplus.service.TestGoodsService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author huangkaiqiang
 * @since 2020-09-10
 */
@Service
public class TestGoodsServiceImpl extends ServiceImpl<TestGoodsMapper, TestGoods> implements TestGoodsService {

    @Override
    public TestGoods findById(TestUser testUser) {
        synchronized (testUser.getId()) {
            TestGoods testGoods = getOne(Wrappers.<TestGoods>lambdaQuery().eq(TestGoods::getUserId, 21));
            if (testGoods != null) {
                System.out.println("已存在");
                return null;
            }
            TestGoods testGoods1 = new TestGoods();
            testGoods1.setGoodsSn("dsdsd");
            testGoods1.setName("fsfsf");
            testGoods1.setName("测试1");
            testGoods1.setPrice(new BigDecimal("30"));
            testGoods1.setStatus(true);
            testGoods1.setSaleCount(30);
            testGoods1.setCreateTime(new Date());
            testGoods1.setUpdateTime(new Date());
            testGoods1.setUserId(2L);
            int j = 0;
            for (int i = 0; i < 10000; i++) {
                j = j + i;
            }
            save(testGoods1);
//            return testGoods1;
        }
        System.out.println("111111111111111");
        return null;

    }
}
