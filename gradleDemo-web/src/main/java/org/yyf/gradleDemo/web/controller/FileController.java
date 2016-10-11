package org.yyf.gradleDemo.web.controller;

import com.google.common.io.ByteStreams;
import com.google.common.io.Resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by tobi on 16-10-10.
 */
@RestController
public class FileController {

//    @RequestMapping("/d1")
//    public StreamingResponseBody d1(HttpServletResponse response) throws IOException {
//        return outputStream -> {
//            String name = "/testfile.txt";
//            URL resource = Resources.getResource(name);
//            byte[] bytes = Resources.toByteArray(resource);
//
////            response.setHeader("Content-Disposition", "attachment; filename=\"" + name + "\"");
//            response.setHeader("Content-Disposition", "attachment; filename=" + name);
//            response.setContentType("application/octet-stream; charset=utf-8");
////            response.setBufferSize(2048);
//            response.getOutputStream().write(bytes);
//        };
//    }

    @RequestMapping("/d2")
    public void d2(HttpServletResponse response) {
        String name = "中文名文件.txt";
        URL resource = Resources.getResource(name);
//            byte[] bytes = Resources.toByteArray(resource);
        try (InputStream inputStream = resource.openStream()) {
            byte[] bytes = ByteStreams.toByteArray(inputStream);
            String nameTransferred = new String(name.getBytes("utf-8"), "iso-8859-1");
            response.setHeader("Content-Disposition", "attachment; filename=" + nameTransferred);
            response.setContentType("application/octet-stream; charset=utf-8");
//            response.setBufferSize(2048);
            response.getOutputStream().write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
