package com.naggi.springboot.lazyinit.data;
// default package
// Generated 2015/08/20 19:15:06 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * RoleGroupRole generated by hbm2java
 */
public class RoleGroupRole implements java.io.Serializable {


  private int roleGroupRoleId;
  private Integer roleGroupId;
  private Integer roleId;
  private Boolean deleteFlag;
  private Date updatedDate;
  private Date createdDate;
  private Integer createdUser;
  private Integer updatedUser;

  public RoleGroupRole() {}


  public RoleGroupRole(int roleGroupRoleId) {
    this.roleGroupRoleId = roleGroupRoleId;
  }

  public RoleGroupRole(int roleGroupRoleId, Integer roleGroupId, Integer roleId,
      Boolean deleteFlag, Date updatedDate, Date createdDate, Integer createdUser,
      Integer updatedUser) {
    this.roleGroupRoleId = roleGroupRoleId;
    this.roleGroupId = roleGroupId;
    this.roleId = roleId;
    this.deleteFlag = deleteFlag;
    this.updatedDate = updatedDate;
    this.createdDate = createdDate;
    this.createdUser = createdUser;
    this.updatedUser = updatedUser;
  }

  public int getRoleGroupRoleId() {
    return this.roleGroupRoleId;
  }

  public void setRoleGroupRoleId(int roleGroupRoleId) {
    this.roleGroupRoleId = roleGroupRoleId;
  }

  public Integer getRoleGroupId() {
    return this.roleGroupId;
  }

  public void setRoleGroupId(Integer roleGroupId) {
    this.roleGroupId = roleGroupId;
  }

  public Integer getRoleId() {
    return this.roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }

  public Boolean getDeleteFlag() {
    return this.deleteFlag;
  }

  public void setDeleteFlag(Boolean deleteFlag) {
    this.deleteFlag = deleteFlag;
  }

  public Date getUpdatedDate() {
    return this.updatedDate;
  }

  public void setUpdatedDate(Date updatedDate) {
    this.updatedDate = updatedDate;
  }

  public Date getCreatedDate() {
    return this.createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public Integer getCreatedUser() {
    return this.createdUser;
  }

  public void setCreatedUser(Integer createdUser) {
    this.createdUser = createdUser;
  }

  public Integer getUpdatedUser() {
    return this.updatedUser;
  }

  public void setUpdatedUser(Integer updatedUser) {
    this.updatedUser = updatedUser;
  }



}
