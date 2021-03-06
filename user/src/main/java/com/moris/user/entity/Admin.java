package com.moris.user.entity;

/**
 * 管理员
 */
public class Admin {

    private int id;
    private String adminName;
    private String adminPassword;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", adminName=" + adminName +
                ", adminPassword=" + adminPassword +
                '}';
    }
}
