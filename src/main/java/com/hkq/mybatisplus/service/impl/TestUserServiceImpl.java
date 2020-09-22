package com.hkq.mybatisplus.service.impl;

import com.hkq.mybatisplus.domain.TestUser;
import com.hkq.mybatisplus.mapper.TestUserMapper;
import com.hkq.mybatisplus.service.TestUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huangkaiqiang
 * @since 2020-09-10
 */
@Service
public class TestUserServiceImpl extends ServiceImpl<TestUserMapper, TestUser> implements TestUserService {

}
