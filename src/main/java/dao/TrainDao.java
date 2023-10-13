package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Train;

public class TrainDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	public void save(Train train) {
		transaction.begin();
		manager.persist(train);
		transaction.commit();
	}
	
	public List<Train> fetchAll()
	{
		return manager.createQuery("select x from Train x").getResultList();
	}

	public void delete(int tnumber)
	{
		transaction.begin();
		manager.remove(manager.find(Train.class, tnumber));
		transaction.commit();
	}
	
	public Train fetch(int number)
	{
		return manager.find(Train.class, number);
	}
	
	public void update(Train train) {
		transaction.begin();
		manager.merge(train);
		transaction.commit();
	}
}