package org.yyf.gradleDemo.web.controller;

import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tobi on 16-7-13.
 */
@RestController
public class MonitorController {
    @RequestMapping("cl")
    public Map getClassLoadingInfo(){
        ClassLoadingMXBean classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();
        int loadedClassCount = classLoadingMXBean.getLoadedClassCount();
        long totalLoadedClassCount = classLoadingMXBean.getTotalLoadedClassCount();
        long unloadedClassCount = classLoadingMXBean.getUnloadedClassCount();
        HashMap<String, Object> result = Maps.newHashMap();
        result.put("loadedClassCount", loadedClassCount);
        result.put("totalLoadedClassCount", totalLoadedClassCount);
        result.put("unloadedClassCount", unloadedClassCount);
        return result;
    }
}
