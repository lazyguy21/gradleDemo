package org.yyf.gradleDemo.common.util;

import com.google.common.collect.Maps;

import java.lang.management.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tobi on 16-7-13.
 */
public class JVMMonitorUtil {
    private final static ClassLoadingMXBean classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();
    //    private final static CompilationMXBean CompilationMXBean = ManagementFactory.getClassLoadingMXBean();
    private final static MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
    private final static ThreadMXBean ThreadMXBean = ManagementFactory.getThreadMXBean();
    //    private final static RuntimeMXBean RuntimeMXBean = ManagementFactory.getClassLoadingMXBean();
//    private final static OperatingSystemMXBean OperatingSystemMXBean = ManagementFactory.getClassLoadingMXBean();
    private final static List<GarbageCollectorMXBean> GARBAGE_COLLECTOR_MX_BEAN_LIST = ManagementFactory.getGarbageCollectorMXBeans();
//    private final static MemoryManagerMXBean MemoryManagerMXBean = ManagementFactory.getClassLoadingMXBean();
//    private final static MemoryPoolMXBean MemoryPoolMXBean = ManagementFactory.getClassLoadingMXBean();
    private static final int RATIO = 1024 * 1024;

    public static Map getClassLoadingInfo() {
        int loadedClassCount = classLoadingMXBean.getLoadedClassCount();
        long totalLoadedClassCount = classLoadingMXBean.getTotalLoadedClassCount();
        long unloadedClassCount = classLoadingMXBean.getUnloadedClassCount();
        HashMap<String, Object> result = Maps.newHashMap();
        result.put("loadedClassCount", loadedClassCount);
        result.put("totalLoadedClassCount", totalLoadedClassCount);
        result.put("unloadedClassCount", unloadedClassCount);
        return result;
    }
//    public static Map getGarbageCollectorInfo(){
//
//    }
    public static Map getMemoryInfo() {
        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        HashMap<String, Object> result = Maps.newHashMap();
        result.put("initHeapMemory", heapMemoryUsage.getInit() / RATIO);
        result.put("usedHeapMemory", heapMemoryUsage.getUsed() / RATIO);
        result.put("committedHeapMemory", heapMemoryUsage.getCommitted() / RATIO);
        result.put("maxHeapMemory", heapMemoryUsage.getMax() / RATIO);
        return result;
    }

//    public static Map getThreadInfo() {
//        ThreadMXBean.
//        HashMap<String, Object> result = Maps.newHashMap();
//        result.put("initNonHeapMemoryUsage", nonHeapMemoryUsage.getInit() / RATIO);
//        result.put("usedNonHeapMemoryUsage", nonHeapMemoryUsage.getUsed() / RATIO);
//        result.put("committedNonHeapMemoryUsage", nonHeapMemoryUsage.getCommitted() / RATIO);
//        result.put("maxNonHeapMemoryUsage", nonHeapMemoryUsage.getMax() / RATIO);
//        return result;
//    }

    public static Map getNonHeapMemoryUsage() {
        MemoryUsage nonHeapMemoryUsage = memoryMXBean.getNonHeapMemoryUsage();
        HashMap<String, Object> result = Maps.newHashMap();
        result.put("initNonHeapMemoryUsage", nonHeapMemoryUsage.getInit() / RATIO);
        result.put("usedNonHeapMemoryUsage", nonHeapMemoryUsage.getUsed() / RATIO);
        result.put("committedNonHeapMemoryUsage", nonHeapMemoryUsage.getCommitted() / RATIO);
        result.put("maxNonHeapMemoryUsage", nonHeapMemoryUsage.getMax() / RATIO);
        return result;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
//        while(true){
//            executorService.execute(() -> {
//                Map classLoadingInfo = getClassLoadingInfo();
//                System.out.println(classLoadingInfo);
//            });
//
//        }
//        for (int i = 0; i < 10; i++) {
//            executorService.execute(() -> {
//                Map memoryInfo = getMemoryInfo();
//                System.out.println(memoryInfo);
//            });
//        }
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                Map memoryInfo = getNonHeapMemoryUsage();
                System.out.println(memoryInfo);
            });
        }

    }
}
