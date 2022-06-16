package com.example.util;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import com.example.jdo.Distribuidor;

public class PrepareData {

	public static void main(String[] args) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Distribuidor distriA = new Distribuidor("eroski", "EROS", "passwd");
			pm.makePersistent(distriA);
			Distribuidor distriB = new Distribuidor("mercadona", "MERC", "passwd");
			pm.makePersistent(distriB);
			Distribuidor distriC = new Distribuidor("bm", "BM", "passwd");
			pm.makePersistent(distriC);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
}
