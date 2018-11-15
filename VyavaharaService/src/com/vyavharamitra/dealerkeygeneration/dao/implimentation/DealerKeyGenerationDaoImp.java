package com.vyavharamitra.dealerkeygeneration.dao.implimentation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.dealerkeygeneration.bean.DealerEncyKeyGenerationBean;
import com.vyavharamitra.dealerkeygeneration.bean.DealerKeyGenerationBean;
import com.vyavharamitra.dealerkeygeneration.dao.IDealerKeyGenerationDao;
import com.vyavharamitra.utils.Utils;

/**
 * @author : Mohan M
 * @created date :
 * @modified by :
 * @modified date :
 */
@Repository
public class DealerKeyGenerationDaoImp implements IDealerKeyGenerationDao {

	private Session session;

	DateFormat dateFormate = new SimpleDateFormat("HH:mm:ss");
	Calendar calenderObj = Calendar.getInstance();
	Date date = new Date();

	public DealerKeyGenerationBean dealerKeyGenerationCreateDao(SessionFactory sessionFactory,
			DealerKeyGenerationBean dealerKeyGenerationBean) {

		dealerKeyGenerationBean.setEnteredBy(dealerKeyGenerationBean.getEnteredBy());
		dealerKeyGenerationBean.setEnteredTime(dateFormate.format(calenderObj.getTime()));
		dealerKeyGenerationBean.setEnteredDate(date);
		dealerKeyGenerationBean.setKeyStatus("N");
		dealerKeyGenerationBean.setDealerID(dealerKeyGenerationBean.getDealerID());

		session = sessionFactory.openSession();
		session.save(dealerKeyGenerationBean);
		session.beginTransaction().commit();

		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(dealerKeyGenerationBean)) {
			return dealerKeyGenerationBean;
		}
		return dealerKeyGenerationBean;
	}

	public void dealerKeyGenerationCreateDao1(SessionFactory sessionFactory,
			DealerEncyKeyGenerationBean dealerEncyKeyGenerationBean) {
		dealerEncyKeyGenerationBean.setEnteredTime(dateFormate.format(calenderObj.getTime()));
		dealerEncyKeyGenerationBean.setEnteredDate(date);
		dealerEncyKeyGenerationBean.setKeyStatus("N");
		session = sessionFactory.openSession();
		session.save(dealerEncyKeyGenerationBean);
		session.beginTransaction().commit();

		if (session.isOpen()) {
			session.close();
		}
	}
}
