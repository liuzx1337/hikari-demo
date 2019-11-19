package com.qishao.api.service;

import com.qishao.api.dao.primary.RuleSceneDao;
import com.qishao.api.dao.secondary.AccountInfoDao;
import com.qishao.api.entity.AccountInfo;
import com.qishao.api.entity.BaseRuleSceneInfo;
import com.qishao.api.vo.TestScene;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * TODO desc of class
 *
 * @author liuzixi
 * date 2019/10/18
 */
@Service
public class TestService {

    @Autowired
    private RuleSceneDao ruleSceneDao;

    @Autowired
    private AccountInfoDao accountInfoDao;

    public void insertScene(TestScene testScene) {
        BaseRuleSceneInfo baseRuleSceneInfo = new BaseRuleSceneInfo();
        baseRuleSceneInfo.setSceneId(UUID.randomUUID().toString().replace("-", ""));
        baseRuleSceneInfo.setSceneName(testScene.getSceneName());
        baseRuleSceneInfo.setSceneIdentify(testScene.getSceneIdentify());
        // account
        AccountInfo accountInfo = accountInfoDao.selectByThirdUserId("liuzixi", "ebiz");
        baseRuleSceneInfo.setCreUserId(accountInfo.getAccountId());
        baseRuleSceneInfo.setMfiUserId(accountInfo.getAccountId());
        Date now = new Date();
        baseRuleSceneInfo.setCreTime(now);
        baseRuleSceneInfo.setMfiTime(now);

        ruleSceneDao.insert(baseRuleSceneInfo);
    }
}
