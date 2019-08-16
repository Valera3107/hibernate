package com.ua.service;

import com.ua.dao.AddressDao;
import com.ua.domain.Address;
import com.ua.util.SessionUtil;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class AddressService extends SessionUtil implements AddressDao {
  @Override
  public void save(Address obj) {
    openTransactionSession();
    getSession().save(obj);
    closeTransactionSession();
  }

  @Override
  public Address readById(int id) {
    openTransactionSession();
    Criteria criteria = getSession().createCriteria(Address.class);
    criteria.add(Restrictions.eq("id", id));
    Address address = (Address) criteria.uniqueResult();
    closeTransactionSession();
    return address;
  }

  @Override
  public List<Address> readAll() {
    openTransactionSession();
    Criteria criteria = getSession().createCriteria(Address.class);
    List<Address> addresses = criteria.list();
    closeTransactionSession();
    return addresses;
  }

  @Override
  public void delete(Address obj) {
    openTransactionSession();
    getSession().delete(obj);
    closeTransactionSession();
  }

  @Override
  public void update(Address obj) {
    openTransactionSession();
    getSession().update(obj);
    closeTransactionSession();
  }
}
