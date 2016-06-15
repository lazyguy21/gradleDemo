package org.yyf.gradleDemo.web.aop;

import com.google.common.base.Stopwatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.yyf.gradleDemo.common.profiler.LogProfiler;
import org.yyf.gradleDemo.common.profiler.RMI;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by tobi on 16-6-14.
 */
@Aspect
public class WebAOP {
    private static final Logger logger = LogManager.getLogger();
    public static final ThreadLocal<Map<String,AnalysisInfo>> invokedMethod   = new ThreadLocal<Map<String,AnalysisInfo>>(){
        @Override
        protected Map<String,AnalysisInfo> initialValue() {
            Map map = new HashMap<>();
            return map;
        }
    };
    /**
     * 拦截所有Controller
     */
    @Pointcut("within(org.yyf.gradleDemo.service.MockRMIService)")
    public void type(){
    }
    @Pointcut("within(org.yyf.gradleDemo.web.controller.TestController)")
    public void testController(){
    }
    @Pointcut("execution(public * *(..))")
    public void anyMethod(){

    }
    @Around(value = "testController()&&anyMethod()")
    public Object logAroundC(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object proceed = proceedingJoinPoint.proceed();
        Map<String, AnalysisInfo> invokedMethodMap = invokedMethod.get();
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, AnalysisInfo> stringAnalysisInfoEntry : invokedMethodMap.entrySet()) {
            String key = stringAnalysisInfoEntry.getKey();
            AnalysisInfo value = stringAnalysisInfoEntry.getValue();
            stringBuilder.append("\n"+key + " : " + value.toString()  );
        }
        logger.info(stringBuilder.toString());
        //因为服务器用的是线程池，这里不clean的话，threadlocal里会保存同一个线程的数据，造成数据翻倍。
        invokedMethod.remove();
        return proceed;

    }
    @Around(value = "type()&&anyMethod()")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Signature signature = proceedingJoinPoint.getSignature();
        String methodName = signature.getName();
        Stopwatch stopwatch = Stopwatch.createStarted();
        Object proceed = proceedingJoinPoint.proceed();
        stopwatch.stop();
        long elapsedSeconds = stopwatch.elapsed(TimeUnit.SECONDS);
//        Set<LogProfiler.MethodEntry> methodEntries = LogProfiler.entryStack.get();
        Map<String, AnalysisInfo> invokedMethodMap = invokedMethod.get();
        if(!invokedMethodMap.containsKey(methodName)){
            AnalysisInfo analysisInfo = new AnalysisInfo();
            analysisInfo.setInvokedTimes(1);
            analysisInfo.setElapsedSeconds(elapsedSeconds);
            invokedMethodMap.put(methodName, analysisInfo);
        }else {
            AnalysisInfo analysisInfo = invokedMethodMap.get(methodName);
            analysisInfo.setElapsedSeconds(analysisInfo.getElapsedSeconds()+elapsedSeconds);
            analysisInfo.setInvokedTimes(analysisInfo.getInvokedTimes()+1);
        }

        return proceed;

    }
    static class AnalysisInfo{
        private Integer invokedTimes;
        private Long elapsedSeconds;

        @Override
        public String toString() {
            return "AnalysisInfo{" +
                    "invokedTimes=" + invokedTimes +
                    ", elapsedSeconds=" + elapsedSeconds +
                    '}';
        }

        public Integer getInvokedTimes() {
            return invokedTimes;
        }

        public void setInvokedTimes(Integer invokedTimes) {
            this.invokedTimes = invokedTimes;
        }

        public Long getElapsedSeconds() {
            return elapsedSeconds;
        }

        public void setElapsedSeconds(Long elapsedSeconds) {
            this.elapsedSeconds = elapsedSeconds;
        }
    }
}
