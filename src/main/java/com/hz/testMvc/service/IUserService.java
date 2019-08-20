package com.hz.testMvc.service;

import com.hz.testMvc.req.PageReq;
import com.hz.testMvc.resp.ResponseData;

/**
 * 用户信息相关接口
 */
public interface IUserService {

    /**
     * 获取用户信息列表
     */
    public ResponseData getUserInfo(PageReq req)throws Exception;


}
