package org.yyf.gradleDemo.domain;

/**
 * Created by lazyguy on 2016-6-4.
 */
public enum ColorEnum {
    red("红"),
    green("绿"),
    blue("蓝");

    private String label;

    ColorEnum(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
