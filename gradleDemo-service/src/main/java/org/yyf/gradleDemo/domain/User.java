package org.yyf.gradleDemo.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by lazyguy on 2016-5-20.
 */
public class User {
    private Long id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;
    private Boolean ifOk;
    private ColorEnum colorEnum;

    public ColorEnum getColorEnum() {
        return colorEnum;
    }

    public void setColorEnum(ColorEnum colorEnum) {
        this.colorEnum = colorEnum;
    }

    public User() {

    }

    public User(Long id, String name, Date birthday, Boolean ifOk) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.ifOk = ifOk;
    }

    public Boolean getIfOk() {
        return ifOk;
    }

    public void setIfOk(Boolean ifOk) {
        this.ifOk = ifOk;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", ifOk=" + ifOk +
                ", colorEnum=" + colorEnum +
                '}';
    }
}
