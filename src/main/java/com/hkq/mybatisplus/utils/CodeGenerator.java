package com.hkq.mybatisplus.utils;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @author huangkaiqiang
 * @version 1.0
 * @description 代码生成器
 * @date 2020/8/24 15:41
 */
public class CodeGenerator {
    /**
     * 代码生成器的配置常量
     */
    private static final String outPutDir = "/src/main/java";
    private static final String dataName = "root";
    private static final String dataPwd = "123456";
    private static final String dataUrl = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&characterSetResults=utf8";
    private static final String driverName = "com.mysql.jdbc.Driver";
    private static final String parentPackage = "com.hkq.mybatisplus";
    private static final String mapperName = "dao";
    private static final String serviceName = "service";
    private static final String implName = "service.impl";
    private static final String pojoName = "domain";
    private static final String controllerName = "controller";
    private static final String xmlName = "mapper";
    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 当前工程路径
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + outPutDir);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setAuthor("huangkaiqiang");
        gc.setOpen(false);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        // 覆盖生成的文件
        gc.setFileOverride(true);
        gc.setServiceName("%sService");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(dataUrl);
        dsc.setDriverName(driverName);
        dsc.setUsername(dataName);
        dsc.setPassword(dataPwd);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(parentPackage)
//                .setMapper(mapperName)
                .setEntity(pojoName)
                .setService(serviceName)
                .setController(controllerName)
                .setServiceImpl(implName);
//                .setXml(null);
        mpg.setPackageInfo(pc);
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // 如果模板引擎是 velocity
         String templatePath = "/templates/mapper.xml.vm";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/"
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityTableFieldAnnotationEnable(true);
        strategy.setEntityLombokModel(true);
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        //默认生成全部
//                strategy.setExclude("map.xml");
//        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        mpg.execute();
    }
}
