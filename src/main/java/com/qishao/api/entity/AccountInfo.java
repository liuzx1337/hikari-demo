package com.qishao.api.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * TODO desc of class
 *
 * @author liuzixi
 * date 2019/11/19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AccountInfo {

    /**
     * 主键
     */
    private String accountId;
    /**
     * 系统id
     */
    private String systemId;
    /**
     * 登录id
     */
    private String thirdUserId;
    /**
     * 用户类型
     */
    private String thirdUserType;
    /**
     * 账户类型
     */
    private String accountType;
    /**
     * 账户状态
     */
    private Integer accountStatus;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 修改时间
     */
    private Date modifiedTime;
    /**
     * 修改人
     */
    private String modifiedBy;
    /**
     * 备注
     */
    private String remark;
    /**
     * 是否有效
     */
    private Integer isActivate;
    /**
     * 是否删除
     */
    private Integer isDel;
}
