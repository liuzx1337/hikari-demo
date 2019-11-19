package com.qishao.api.dao.primary;

import com.qishao.api.entity.BaseRuleSceneInfo;

/**
 * dao层
 *
 * @author liuzixi
 * date 2019/10/18
 */
public interface RuleSceneDao {

    int insert(BaseRuleSceneInfo baseRuleSceneInfo);

    BaseRuleSceneInfo getOneById(String id);
}
