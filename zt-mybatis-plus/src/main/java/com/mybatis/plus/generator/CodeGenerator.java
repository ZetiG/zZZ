package com.mybatis.plus.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.converts.SqliteTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.*;

/**
 * Description: 代码生成
 *
 * @Date 2019/9/26 13:50
 * @Author Zeti
 */
@Slf4j
public class CodeGenerator {

    /**
     * 代码所在服务名
     */
    private static String serviceName = "zt-mybatis-plus";
    /**
     * 代码生成的包名
     */
    private static String packageName = "com.zt.mybatis";
    /**
     * 代码后端生成的地址
     */
    private static String packageDir;

    /**
     * 需要去掉的表前缀
     */
    private static String[] tablePrefix = {""};
    /**
     * 需要生成的表名(两者只能取其一)
     */
    private static String[] includeTables = {"shop_user"};
    /**
     * 需要排除的表名(两者只能取其一)
     */
    private static String[] excludeTables = {};
    /**
     * 是否包含基础业务字段
     */
    private static Boolean hasSuperEntity = Boolean.FALSE;
    /**
     * 基础业务字段
     */
    private static String[] superEntityColumns = {"id", "create_user", "update_user", "create_time", "update_time",
            "is_deleted"};
    /**
     * 是否启用swagger
     */
    private static Boolean isSwagger2 = Boolean.TRUE;

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Properties properties = getProperties();
        AutoGenerator mpg = new AutoGenerator();
        GlobalConfig gc = new GlobalConfig();
        String outputDir = getOutputDir();
        gc.setOutputDir(outputDir);
        String author = properties.getProperty("author");
        gc.setAuthor(author);
        gc.setFileOverride(true);
        gc.setOpen(false);
        gc.setActiveRecord(false);
        gc.setEnableCache(false);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("I%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        gc.setSwagger2(isSwagger2);
        mpg.setGlobalConfig(gc);
        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setDbType(DbType.MYSQL);
//        dsc.setTypeConvert(new MySqlTypeConvert());
        dsc.setDbType(DbType.SQLITE);
        dsc.setTypeConvert(new SqliteTypeConvert());
        //指定数据库信息
        dsc.setUrl(properties.getProperty("spring.datasource.url"));
        dsc.setDriverName(properties.getProperty("spring.datasource.driver-class-name"));
        dsc.setUsername(properties.getProperty("spring.datasource.username"));
        dsc.setPassword(properties.getProperty("spring.datasource.password"));
        mpg.setDataSource(dsc);
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名
        // strategy.setDbColumnUnderline(true);//全局下划线命名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setTablePrefix(tablePrefix);
        if (includeTables.length > 0) {
            strategy.setInclude(includeTables);
        }
        if (excludeTables.length > 0) {
            strategy.setExclude(excludeTables);
        }
        //继承base
//        strategy.setSuperEntityClass("com.mybatis.plus.generator.BaseEntity");
//        strategy.setSuperEntityColumns(superEntityColumns);
//        strategy.setSuperServiceClass("com.mybatis.plus.generator.BaseService");
//        strategy.setSuperServiceImplClass("com.mybatis.plus.generator.BaseServiceImpl");
        // 自定义 controller 父类
        strategy.setSuperControllerClass("com.mybatis.plus.base.BaseController");
        strategy.setEntityBuilderModel(false);
        strategy.setEntityLombokModel(true);
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        // 控制台扫描
        pc.setModuleName(null);
        pc.setParent(packageName);
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setXml("mapper");
        mpg.setPackageInfo(pc);
        mpg.setCfg(getInjectionConfig());
        mpg.execute();
    }

    /**
     * 模板转换
     *
     * @return
     */
    private static InjectionConfig getInjectionConfig() {
        String servicePackage = serviceName.split("-").length > 1 ? serviceName.split("-")[1] : serviceName;
        // 自定义配置
        Map<String, Object> map = new HashMap<>(16);
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                map.put("serviceName", serviceName);
                map.put("servicePackage", servicePackage);
                this.setMap(map);
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/entityVO.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                map.put("entityKey", humpToLine(tableInfo.getEntityName()));
                return getOutputDir() + "/" + packageName.replace(".", "/") + "/" + "vo" + "/" + tableInfo.getEntityName() + "VO" + StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig("/templates/entityDTO.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return getOutputDir() + "/" + packageName.replace(".", "/") + "/" + "dto" + "/" + tableInfo.getEntityName() + "DTO" + StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig("/templates/wrapper.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return getOutputDir() + "/" + packageName.replace(".", "/") + "/" + "wrapper" + "/" + tableInfo.getEntityName() + "Wrapper" + StringPool.DOT_JAVA;
            }
        });

        cfg.setFileOutConfigList(focList);
        return cfg;
    }

    /**
     * 获取配置文件
     *
     * @return 配置Properties
     */
    private static Properties getProperties() {
        // 读取配置文件
        Resource resource = new ClassPathResource("/generator.properties");
        Properties props = new Properties();
        try {
            props = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            log.error("获取配置文件失败" + e);
        }
        return props;
    }

    /**
     * 生成到项目中
     *
     * @return outputDir
     */
    public static String getOutputDir() {
        return (StringUtils.isBlank(packageDir) ? System.getProperty("user.dir") : packageDir) + "/src/main/java";
    }

    /**
     * 驼峰转横线
     *
     * @param para 字符串
     * @return String
     */
    public static String humpToLine(String para) {
        para = StringUtils.uncapitalize(para);
        StringBuilder sb = new StringBuilder(para);
        int temp = 0;
        for (int i = 0; i < para.length(); i++) {
            if (Character.isUpperCase(para.charAt(i))) {
                sb.insert(i + temp, "-");
                temp += 1;
            }
        }
        return sb.toString().toLowerCase();
    }


}
