package com.iflytek.datasourcemultiple.config;

import com.iflytek.datasourcemultiple.entity.DataSourceEntity;
import com.zaxxer.hikari.HikariDataSource;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yjwang46
 * 动态多数据源配置器
 */
@Slf4j
@Configuration
@ConditionalOnProperty(prefix = "spring.datasource", name = "enableMultiple", havingValue = "true")
public class DataSourceInit {

    @Autowired
    private DataSourceConfig dataSourceConfig;


    @Bean(name = "multipleTransactionManager")
    @Primary
    public DataSourceTransactionManager multipleTransactionManager(@Qualifier("multipleDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @SneakyThrows
    @Bean(name = "multipleDataSource")
    @Primary
    public DataSource multipleDataSource() {
        List<DataSourceEntity> multiple = dataSourceConfig.getMultiple();
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        //加载全部数据源
        for (DataSourceEntity dataSourceEntity : multiple) {
            String tmpKey = dataSourceEntity.getTenant();
            //创建数据源对象
            HikariDataSource hikariDataSource = new HikariDataSource(dataSourceEntity);
            log.info("data source: {} connection is successful", tmpKey);
            //置入数据源对象
            targetDataSources.put(tmpKey, hikariDataSource);
            if (dataSourceEntity.isPrimary()) {
                // 默认使用的数据源
                dynamicDataSource.setDefaultTargetDataSource(hikariDataSource);
                DynamicDataSource.setDataSource(tmpKey);
            }
        }
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.afterPropertiesSet();
        return dynamicDataSource;
    }

}
