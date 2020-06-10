package com.thuni.his.business.bean.enums;

public enum UserType {
    /**
     * 员工
     */
    employee("员工"),
    /**
     * 管理员
     */
    admin("管理员");

    private String value;

    UserType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
