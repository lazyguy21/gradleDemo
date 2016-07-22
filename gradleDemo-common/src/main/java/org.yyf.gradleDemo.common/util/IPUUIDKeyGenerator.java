package org.yyf.gradleDemo.common.util;

import sun.net.util.IPAddressUtil;

import java.util.UUID;

/**
 * Created by tobi on 16-7-21.
 */
public class IPUUIDKeyGenerator {
    public static void main(String[] args) {
        getKey();
    }
    public static String getKey(){
        String s = UUID.randomUUID().toString();
        String ip = LocalIpAddressUtil.getIp();
        System.out.println(s);
        System.out.println(ip);
        return ip + s;
    }
}
