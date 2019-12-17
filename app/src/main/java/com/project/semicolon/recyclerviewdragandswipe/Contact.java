package com.project.semicolon.recyclerviewdragandswipe;

public class Contact {
    private String name;
    private String phone;
    private String avatarUrl;

    public Contact(String name, String phone, String avatarUrl) {
        this.name = name;
        this.phone = phone;
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
