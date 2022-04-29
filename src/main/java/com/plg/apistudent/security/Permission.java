package com.plg.apistudent.security;

public enum Permission {
  STUDENT_READ("student:read"),
  STUDENT_WRITE("student:write"),
  COURS_READ("cours:read"),
  COURS_WRITE("cours:write");

  private final String permission;

  Permission(String permission) {
    this.permission = permission;
  }

  public String getPermission() {
    return this.permission;
  }

}
