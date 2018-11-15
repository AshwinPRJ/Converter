/**
 * @author : Mohan M
 * @created date : 
 * @modified by :
 * @modified date :
 */
package com.vyavharamitra.dealerkeygeneration.service.implimentation;

import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.common.service.implementation.AESencrypt;
import com.vyavharamitra.common.service.implementation.KeyGeneration;
import com.vyavharamitra.dealerkeygeneration.bean.DealerEncyKeyGenerationBean;
import com.vyavharamitra.dealerkeygeneration.bean.DealerKeyGenerationBean;
import com.vyavharamitra.dealerkeygeneration.dao.IDealerKeyGenerationDao;
import com.vyavharamitra.dealerkeygeneration.service.IDealerKeyGenerationService;
import com.vyavharamitra.dealerkeygeneration.to.request.DealerKeyGenerationRequest;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.Utils;

import resources.HibernateUtil;

@Service
public class DealerKeyGenerationServiceImp implements IDealerKeyGenerationService {

	@Autowired
	private IDealerKeyGenerationDao iDealerKeyGenerationDao;
	@Autowired
	private HttpServletRequest httpServletRequest;

	private SessionFactory sessionFactory;

	public DealerKeyGenerationServiceImp() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	KeyGeneration kg = new KeyGeneration();
	AESencrypt aes = new AESencrypt();

	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
	public DealerKeyGenerationBean dealerKeyGenerationCreateService(
			DealerKeyGenerationRequest dealerKeyGenerationRequest) {
		List<BigInteger> generatedKeysList = kg
				.delarKey(dealerKeyGenerationRequest.getDealerKeyGenerationBean().getNumberOfKeys());

		DealerKeyGenerationBean dealerKeyGenerationBean = new DealerKeyGenerationBean();
		DealerEncyKeyGenerationBean dealerEncyKeyGenerationBean = new DealerEncyKeyGenerationBean();
		String ency = "";

		int intDealerId = dealerKeyGenerationRequest.getDealerKeyGenerationBean().getDealerID();
		UserCreationBean ucb=    Utils.getCurrentUser(httpServletRequest);
		
		for (Object dealerKey : generatedKeysList) {
			dealerKeyGenerationRequest.getDealerKeyGenerationBean().setEnteredBy(ucb.getUserNumber());
			
			dealerKeyGenerationRequest.getDealerKeyGenerationBean().setDealerKey((BigInteger) dealerKey);
			dealerKeyGenerationBean = iDealerKeyGenerationDao.dealerKeyGenerationCreateDao(sessionFactory,
					dealerKeyGenerationRequest.getDealerKeyGenerationBean());
			
			int serialnumber=dealerKeyGenerationBean.getKeyNumber();
			dealerEncyKeyGenerationBean.setKeyNumber(serialnumber);
			dealerEncyKeyGenerationBean.setDealerID(intDealerId);
			dealerEncyKeyGenerationBean.setEnteredBy(ucb.getUserNumber());
			try {
				ency = aes.encrypt(dealerKey.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
			dealerEncyKeyGenerationBean.setDealerKey(ency);

			iDealerKeyGenerationDao.dealerKeyGenerationCreateDao1(sessionFactory, dealerEncyKeyGenerationBean);

		}
		return dealerKeyGenerationBean;
	}
}