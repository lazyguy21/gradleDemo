package org.yyf.gradleDemo.service;

import org.springframework.stereotype.Service;
import org.yyf.gradleDemo.common.profiler.RMI;

import java.util.concurrent.TimeUnit;


/**
 * Created by tobi on 16-6-14.
 */
@Service
public class MockRMIService {
    @RMI
    public void sleepDouble(){
        sleep2();
        sleep3();
    }
    @RMI
    public void sleep2(){
//        System.out.println("wozaiservicelimian");
        System.out.println("aaa");
        System.out.println("aa1");
        System.out.println(111);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @RMI
    public void sleep3(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @RMI
    public void sleep1(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
