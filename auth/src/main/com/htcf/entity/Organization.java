package com.htcf.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BASE_ORGANIZATION")
public class Organization
  implements Serializable
{
  private Long id;
  private String code;
  private String name;
  private String fullName;
  private String address;
  private Long pid;
  private String isLeaf;
  private Long layer;
  private String manager;
  private String manTel;
  private String description;
  private Long sequence;
  private Long role_id;

  public Organization()
  {
  }

  public Organization(String code, String name, String fullName, String address, Long pid, String isLeaf, Long layer, String manager, String manTel, String description, Long sequence, Long role_id)
  {
    this.code = code;
    this.name = name;
    this.fullName = fullName;
    this.address = address;
    this.pid = pid;
    this.isLeaf = isLeaf;
    this.layer = layer;
    this.manager = manager;
    this.manTel = manTel;
    this.description = description;
    this.sequence = sequence;
    this.role_id = role_id;
  }

  @Id
  @GeneratedValue
  @Column(name="ID", unique=true, nullable=false, precision=16, scale=0)
  public Long getId()
  {
    return this.id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  @Column(name="CODE", length=20)
  public String getCode()
  {
    return this.code;
  }

  public void setCode(String code)
  {
    this.code = code;
  }

  @Column(name="NAME", length=50)
  public String getName()
  {
    return this.name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  @Column(name="FULLNAME", length=100)
  public String getFullName()
  {
    return this.fullName;
  }

  public void setFullName(String fullName)
  {
    this.fullName = fullName;
  }

  @Column(name="ADDRESS", length=200)
  public String getAddress()
  {
    return this.address;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }

  @Column(name="PID", precision=16, scale=0)
  public Long getPid()
  {
    return this.pid;
  }

  public void setPid(Long pid)
  {
    this.pid = pid;
  }

  @Column(name="ISLEAF", length=10)
  public String getIsLeaf()
  {
    return this.isLeaf;
  }

  public void setIsLeaf(String isLeaf)
  {
    this.isLeaf = isLeaf;
  }

  @Column(name="LAYER", precision=2, scale=0)
  public Long getLayer()
  {
    return this.layer;
  }

  public void setLayer(Long layer)
  {
    this.layer = layer;
  }

  @Column(name="MANAGER", length=20)
  public String getManager()
  {
    return this.manager;
  }

  public void setManager(String manager)
  {
    this.manager = manager;
  }

  @Column(name="MANTEL", length=20)
  public String getManTel() {
    return this.manTel;
  }

  public void setManTel(String manTel)
  {
    this.manTel = manTel;
  }

  @Column(name="DESCRIPTION", length=100)
  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  @Column(name="SEQUENCE", precision=2, scale=0)
  public Long getSequence() {
    return this.sequence;
  }

  public void setSequence(Long sequence)
  {
    this.sequence = sequence;
  }

  @Column(name="ROLE_ID", precision=16, scale=0)
  public Long getRole_id()
  {
    return this.role_id;
  }

  public void setRole_id(Long role_id) {
    this.role_id = role_id;
  }
}