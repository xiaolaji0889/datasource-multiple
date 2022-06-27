package com.iflytek.datasourcemultiple.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("dim_ext")
public class DimExtDTO {
    @TableId(type = IdType.AUTO)
    Long id;
    @TableField("CODE_ID")
    String codeId;
    @TableField("CODE_NAME")
    String codeName;
    @TableField("PAR_CODE_ID")
    String parCodeId;
    @TableField("PAR_CODE_NAME")
    String parCodeName;
    @TableField("CENJI_ID")
    Long cenjiId;
    @TableField("ORDER_NO")
    Long orderNo;
    @TableField("IS_CALL_API")
    Long isCallApi;
    @TableField("CREATE_BY")
    String createBy;
    @TableField("UPDATE_TIME")
    Date updateTime;
    @TableField("CREATE_TIME")
    Date createTime;

}
