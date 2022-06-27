package com.iflytek.datasourcemultiple.config;

import com.iflytek.datasourcemultiple.entity.DataSourceEntity;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties("spring.datasource")
public class DataSourceConfig {

    private List<DataSourceEntity> multiple;

    private boolean enableMultiple;

}
