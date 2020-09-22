package com.hkq.mybatisplus.controller;


import com.hkq.mybatisplus.common.R;
import com.hkq.mybatisplus.domain.TestGoods;
import com.hkq.mybatisplus.service.TestGoodsService;
import com.hkq.mybatisplus.service.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huangkaiqiang
 * @since 2020-09-10
 */
@RestController
@RequestMapping("/testGoods")
public class TestGoodsController {
    @Autowired
    private TestGoodsService testGoodsService;
    @Autowired
    private TestUserService userService;

    @GetMapping("/find")
    public R<TestGoods> findById(@RequestParam("id") Long id){
        return R.ok( testGoodsService.findById(userService.getById(id)));
    }
}

