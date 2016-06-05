package org.yyf.gradleDemo.common;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MilliSecondsStringToDateConverter implements Converter<String,Date> {

//    private static final Logger logger = LoggerFactory.getLogger(StringToDateConverter.class);



    @Override
    public Date convert(String source) {
        if (source == null ) {
            return null;
        }
        return new Date(Long.valueOf(source));
    }

}

