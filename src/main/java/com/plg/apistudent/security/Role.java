package com.plg.apistudent.security;

import java.util.Set;

import com.google.common.collect.Sets;

public enum Role {
  STUDENT(Sets.newHashSet()),
  ADMIN(Sets.newHashSet(
      Permission.STUDENT_READ,
      Permission.STUDENT_WRITE,
      Permission.COURS_READ,
      Permission.COURS_WRITE)),
  ADMINTRANEE(Sets.newHashSet(
      Permission.STUDENT_READ,
      Permission.COURS_READ));

  private final Set<Permission> permissions;

  Role(Set<Permission> permissions) {
    this.permissions = permissions;
  }

  public Set<Permission> getPermissions() {
    return this.permissions;
  }
}
