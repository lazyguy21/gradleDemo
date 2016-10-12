package org.yyf.gradleDemo.web.controller;

import com.google.common.io.ByteStreams;
import com.google.common.io.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yyf.gradleDemo.service.IStrategy;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by tobi on 16-10-10.
 */
@RestController
public class StrategyController {

    @Autowired
    private List<IStrategy> strategyList;

    @RequestMapping("/stra")
    public void d2(HttpServletResponse response) {
        for (IStrategy iStrategy : strategyList) {
            System.out.println(iStrategy);
        }
    }
}
