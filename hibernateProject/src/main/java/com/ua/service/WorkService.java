package com.ua.service;

import com.ua.dao.WorkDao;
import com.ua.domain.Work;
import com.ua.util.SessionUtil;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class WorkService extends SessionUtil implements WorkDao {
  @Override
  public void save(Work obj) {
    openTransactionSession();
    getSession().save(obj);
    closeTransactionSession();
  }

  @Override
  public Work readById(int id) {
    openTransactionSession();
    Criteria criteria = getSession().createCriteria(Work.class);
    criteria.add(Restrictions.eq("id", id));
    Work work = (Work) criteria.uniqueResult();
    closeTransactionSession();
    return work;
  }

  @Override
  public List<Work> readAll() {
    openTransactionSession();
    Criteria criteria = getSession().createCriteria(Work.class);
    List<Work> works = criteria.list();
    closeTransactionSession();
    return works;
  }

  @Override
  public void delete(Work obj) {
    openTransactionSession();
    getSession().delete(obj);
    closeTransactionSession();
  }

  @Override
  public void update(Work obj) {
    openTransactionSession();
    getSession().update(obj);
    closeTransactionSession();
  }
}
