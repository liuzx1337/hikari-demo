package com.qishao.api.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 描述：
 * CLASSPATH: BaseRuleSceneInfo
 * VERSION:   1.0
 * Created by gaowei
 * DATE:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BaseRuleSceneInfo {
    /**
     * 主键ID
     */
    private String sceneId;
    /**
     * 标识
     */
    private String sceneIdentify;
    /**
     * 类型
     */
    private Integer sceneType;
    /**
     * 名称
     */
    private String sceneName;
    /**
     * 描述
     */
    private String sceneDesc;
    /**
     * 业务系统ID
     */
    private String systemId;
    /**
     * 积分项ID
     */
    private String pointsId;
    /**
     * 回调接口
     */
    private String callbackInterface;
    /**
     * 生效时间
     */
    private Date effectiveTime;

    /**
     * 创建人
     */
    private String creUserId;

    /**
     * 最后修改人
     */
    private String mfiUserId;
    /**
     * 创建时间
     */
    private Date creTime;

    /**
     * 最后修改时间
     */
    private Date mfiTime;
    /**
     * 备注
     */
    private String remark;
    /**
     * 是否有效
     */
    private Integer isEffect;
}
