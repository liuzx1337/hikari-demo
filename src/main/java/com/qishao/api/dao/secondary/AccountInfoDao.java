package com.qishao.api.dao.secondary;

import com.qishao.api.entity.AccountInfo;
import org.apache.ibatis.annotations.Param;

/**
 * TODO desc of class
 *
 * @author liuzixi
 * date 2019/11/19
 */
public interface AccountInfoDao {

    AccountInfo selectByThirdUserId(@Param("thirdUserId") String thirdUserId,
                                    @Param("thirdUserType") String thirdUserType);
}
