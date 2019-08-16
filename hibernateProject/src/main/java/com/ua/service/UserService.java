package com.ua.service;

import com.ua.dao.UserDao;
import com.ua.domain.User;
import com.ua.util.SessionUtil;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UserService extends SessionUtil implements UserDao {
  @Override
  public void save(User obj) {
    openTransactionSession();
    getSession().save(obj);
    closeTransactionSession();
  }

  @Override
  public User readById(int id) {
    openTransactionSession();
    Criteria criteria = getSession().createCriteria(User.class);
    criteria.add(Restrictions.eq("id", id));
    User user = (User) criteria.uniqueResult();
    closeTransactionSession();
    return user;
  }

  @Override
  public List<User> readAll() {
    openTransactionSession();
    Criteria criteria = getSession().createCriteria(User.class);
    List<User> users = criteria.list();
    closeTransactionSession();
    return users;
  }

  @Override
  public void delete(User obj) {
    openTransactionSession();
    getSession().delete(obj);
    closeTransactionSession();
  }

  @Override
  public void update(User obj) {
    openTransactionSession();
    getSession().update(obj);
    closeTransactionSession();
  }
}
