package com.ibtech.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ibtech.model.Address;

import com.ibtech.util.HibernateUtil;

public class AddressDao {
	
	//save object
	public void saveAddress(Address address) {
		
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//save object
			session.save(address);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}
	//update object
	public void updateAddress(Address address) {
		
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//save object
			session.saveOrUpdate(address);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}	
	//delete object
	public void deleteAddress(long id) {
		
		Address address = null;
		
		Transaction transaction = null;

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//delete object
			address = session.get(Address.class, id);
			session.delete(address);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}	

	//read object
	public Object getAddressById(long id) {
		
		Address address = null;
		
		Transaction transaction = null;

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//save object
			address = session.get(Address.class, id);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
		return address;
		
	}
	
	//read all Addresss
	@SuppressWarnings("unchecked")
	public List<Address> getAllAddresses() {
		
		List<Address> addresss = null;
		
		Transaction transaction = null;

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//get addresss
			addresss = session.createQuery("from address").list();
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}	
		return addresss;
	}
	
}
