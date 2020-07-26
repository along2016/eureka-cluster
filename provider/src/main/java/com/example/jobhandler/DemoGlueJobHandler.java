package com.example.jobhandler;

import com.example.service.UserService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import org.springframework.beans.factory.annotation.Autowired;

public class DemoGlueJobHandler extends IJobHandler {

    @Autowired
    private UserService userService;

    @Override
    public ReturnT<String> execute(String s) throws Exception {

        System.out.println("==============================" + userService.list());
        return ReturnT.SUCCESS;
    }
}
