package com.ua.dao;

import java.util.*;

public interface CommonDao<T> {

  void save(T obj);

  T readById(int id);

  List<T> readAll();

  void delete(T obj);

  void update(T obj);
}
