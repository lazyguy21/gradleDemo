package org.yyf.gradleDemo.common;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class StringToDateConverter implements Converter<String,Date> {

//    private static final Logger logger = LoggerFactory.getLogger(StringToDateConverter.class);

    private String pattern;

    public StringToDateConverter(String pattern){
        this.pattern = pattern;
    }

    public Date convert(String s) {

        if(StringUtils.isEmpty(s)){
            return null;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        simpleDateFormat.setLenient(false);
        try{
            return simpleDateFormat.parse(s);
        }catch(ParseException e){
//            logger.error("转换日期异常："+e.getMessage() , e);
            throw new IllegalArgumentException("转换日期异常："+e.getMessage() , e);
        }
    }
}