package com.ua.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "USER")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String name;

  private int age;

  @OneToOne(cascade = CascadeType.ALL)
  private Address address;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(name = "user_work",
  joinColumns = @JoinColumn(name = "user_id"),
  inverseJoinColumns = @JoinColumn(name = "word_id"))
  private Set<Work> works;

  public User() {
  }

  public User(String name, int age, Address address, Set<Work> works) {
    this.name = name;
    this.age = age;
    this.address = address;
    this.works = works;
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

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Set<Work> getWorks() {
    return works;
  }

  public void setWorks(Set<Work> works) {
    this.works = works;
  }

  @Override
  public String toString() {
    return "User{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", age=" + age +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof User)) return false;
    User user = (User) o;
    return getAge() == user.getAge() &&
      Objects.equals(getId(), user.getId()) &&
      Objects.equals(getName(), user.getName()) &&
      Objects.equals(getAddress(), user.getAddress()) &&
      Objects.equals(getWorks(), user.getWorks());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getAge(), getAddress(), getWorks());
  }
}
