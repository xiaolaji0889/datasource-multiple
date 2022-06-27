package com.iflytek.datasourcemultiple.entity;

import com.zaxxer.hikari.HikariConfig;
import lombok.Data;

@Data
public class DataSourceEntity extends HikariConfig {

    private boolean primary;

    private String tenant;

}
