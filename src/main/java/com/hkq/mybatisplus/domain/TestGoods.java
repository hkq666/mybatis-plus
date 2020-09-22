package com.hkq.mybatisplus.domain;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author huangkaiqiang
 * @since 2020-09-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("test_goods")
public class TestGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    /**
     * 商品编码
     */
    @TableField("goods_sn")
    private String goodsSn;

    /**
     * 商品名称
     */
    @TableField("name")
    private String name;

    /**
     * 标题
     */
    @TableField("title")
    private String title;

    /**
     * 售价
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * 商品状态
     */
    @TableField("status")
    private Boolean status;

    /**
     * 销量
     */
    @TableField("sale_count")
    private Integer saleCount;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;

    @TableField("user_id")
    private Long userId;


}
