package org.yyf.gradleDemmo.domain;

import java.util.Date;

/**
 * Created by lazyguy on 2016-5-20.
 */
public class User {
    private Long id;
    private String name;
    private Date birthday;
    private Boolean ifOk;

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
}
