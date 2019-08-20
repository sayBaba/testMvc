package com.hz.testMvc.service.impl;



import com.hz.testMvc.dao.TestMapper;
import com.hz.testMvc.model.UserBean;
import com.hz.testMvc.service.ITestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestServiceImpl implements ITestService {

    @Resource
    TestMapper testMapper;

    private final static Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);



    @Override
    public List<UserBean> queryLike(String name) {
        logger.info("name-------------------{}",name);
        List<UserBean> listLike = testMapper.queryLike(name);
        return listLike;
    }

    @Override
    public List<UserBean> queryLimit(Integer currentPage, Integer limit) {

        List<UserBean> listLimit = testMapper.queryLimit((currentPage-1)*limit, limit);
        return listLimit;
    }

    @Override
    public int deleteOne(Integer id) {
        int count = testMapper.deleteOne(id);
        //受影响行数
        return count;
    }

    @Override
    public int insertOne(UserBean userBean) {
        int count = testMapper.insertOne(userBean);
        //受影响行数
        return count;
    }

    @Override
    public int updateOne(UserBean userBean) {
        int count = testMapper.updateOne(userBean);
        //受影响行数
        return count;
    }

    @Override
    public int deleteSome(Integer[] ids) {
        int count = testMapper.deleteSome(ids);
        //受影响行数
        return count;
    }
}
