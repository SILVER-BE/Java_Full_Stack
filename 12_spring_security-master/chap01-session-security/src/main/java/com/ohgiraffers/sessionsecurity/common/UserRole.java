package com.ohgiraffers.sessionsecurity.common;

public enum UserRole {

    //선언하면 반드시 상수값 (enum이라)
    USER("USER"),
    ADMIN("ADMIN");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "role='" + role + '\'' +
                '}';
    }
}
