package org.yyf.gradleDemo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yyf.gradleDemo.service.TestService;

/**
 * Created by tobi on 16-5-24.
 */
@Service
@Transactional
public class TestServiceImpl implements TestService{
    @Override
    public void test() {
        int i = 1 / 0;
    }
}
