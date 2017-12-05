package com.redscarf.admin.service.impl;

import com.redscarf.admin.common.vo.Response;
import com.redscarf.admin.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>function:
 * <p>User: LeeJohn
 * <p>Date: 2017/3/21
 * <p>Version: 1.0
 */
@Service
@Slf4j
public class TestServiceImpl implements TestService{

    //注意：1.5.3 spring boot 后，mongodb+dubbo整合，会涉及到bean依赖循环的异常，需要加lazy注解

    public TestServiceImpl(){
        log.info("TestServiceImpl constructor");
    }

    @Override
    public Response<String> test(String params1) {
        return Response.ok();
    }

}
