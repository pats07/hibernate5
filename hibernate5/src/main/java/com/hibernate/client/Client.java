package com.hibernate.client;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.domain.PoLine;
import com.hibernate.domain.PrHeader;
import com.hibernate.domain.PrLine;
import com.hibernate.util.HibernateUtil;


public class Client {
	
	public static void main(String[] args) {
		
		PrHeader pr = new PrHeader();
		pr.setCostCenterId("0067");
		pr.setPrId(new BigDecimal(56));
		pr.setModifiedDateTime(new Timestamp(System.currentTimeMillis()));
		pr.setSsg("XYZ");
		pr.setRequestDate(new Timestamp(System.currentTimeMillis()));
		
		PrLine prLine = new PrLine();
		prLine.setPrId(new BigDecimal(56));
		prLine.setModifiedDatetime(new Timestamp(System.currentTimeMillis()));
		prLine.setPrLineId(new BigDecimal(10));
		prLine.setTotalLineAmount(new BigDecimal(12000.67));
		prLine.setDivision(56);
		
		PoLine poLine = new PoLine();
		poLine.setPoLine(new BigDecimal(10));
		poLine.setPrLineNumber("0010");
		poLine.setPrNumber("0056");
		poLine.setModifiedDateTime(new Timestamp(System.currentTimeMillis()));
		poLine.setPoLineAmount(new BigDecimal(2000));
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(pr);
		session.save(prLine);
		session.save(poLine);
		session.getTransaction().commit();
		session.close();		
		
	}
}
