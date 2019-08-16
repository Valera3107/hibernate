package com.ua.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "WORK")
public class Work {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(length = 80)
  private String name;

  @Column(length = 200)
  private String position;

  private int salary;

  @ManyToMany(mappedBy = "works")
  private Set<User> users;

  public Work() {
  }

  public Work(String name, String position, int salary) {
    this.name = name;
    this.position = position;
    this.salary = salary;
  }

  public Set<User> getUsers() {
    return users;
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Work)) return false;
    Work work = (Work) o;
    return getSalary() == work.getSalary() &&
      Objects.equals(getId(), work.getId()) &&
      Objects.equals(getName(), work.getName()) &&
      Objects.equals(getPosition(), work.getPosition());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getPosition(), getSalary());
  }

  @Override
  public String toString() {
    return "Work{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", position='" + position + '\'' +
      ", salary=" + salary +
      '}';
  }
}
