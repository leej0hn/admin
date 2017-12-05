package com.redscarf.admin.test.service;

import com.redscarf.admin.service.TestService;
import com.redscarf.admin.test.BaseDaoTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>function:
 * <p>User: LeeJohn
 * <p>Date: 2017/3/21
 * <p>Version: 1.0
 */
public class TestServiceTest extends BaseDaoTest {
    @Autowired
    TestService service;

    @Test
    public void test(){
        System.out.println(service.test("a"));
    }

}
