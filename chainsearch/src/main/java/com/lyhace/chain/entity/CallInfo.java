package com.lyhace.chain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "sms_corp_call_info")
public class CallInfo {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String chain_id;
    private String corp_id;
    private String request_corp_id;
    private String cdr_id;
    private Integer cdr_type;
    private String caller_phone;
    private String caller_phone_hash;
    private String called_phone;
    private String called_phone_hash;
    private Date start_time;
    private Date end_time;
    private String record_data;
    private String record_data_hash;
    private String record_data_url;
    private String record_chain_erid;
    private Integer state;
    private String fail_reason;
    private String create_by;
    private Date create_time;
    private String update_by;
    private Date update_time;
    private String remark;
}


