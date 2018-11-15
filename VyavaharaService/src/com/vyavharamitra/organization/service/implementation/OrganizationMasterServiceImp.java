package com.vyavharamitra.organization.service.implementation;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.vyavharamitra.dealerkeygeneration.bean.DealerEncyKeyGenerationBean;
import com.vyavharamitra.dealerkeygeneration.bean.DealerKeyGenerationBean;
import com.vyavharamitra.greetings.beans.BranchBean;
import com.vyavharamitra.organization.bean.BillVocherGenerationBean;
import com.vyavharamitra.organization.bean.ItemVocherGenerationBean;
import com.vyavharamitra.organization.bean.OrganizationLogoBean;
import com.vyavharamitra.organization.bean.OrganizationMasterBean;
import com.vyavharamitra.organization.dao.IOrganizationMasterDao;
import com.vyavharamitra.organization.service.IOrganizationMasterService;
import com.vyavharamitra.organization.to.request.OrganizationMasterRequest;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.Utils;

import resources.HibernateUtil;

/**
 * @author : lavanya
 * @created date : 24 Nov 2017
 * @modified by :
 * @modified date :
 */

@Service
public class OrganizationMasterServiceImp implements IOrganizationMasterService {

	@Autowired
	IOrganizationMasterDao iOrganizationMasterDao;
	
	private SessionFactory sessionFactory;
	DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	Date date = new Date();

	@Autowired
	private HttpServletRequest httpServletRequest;

	public OrganizationMasterServiceImp() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	/**
	 * create organization details
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
	public OrganizationMasterBean organizationMasterCreateService(OrganizationMasterRequest organizationMasterRequest) {
		OrganizationMasterBean organizationMasterBean = new OrganizationMasterBean();
		BranchBean branchBean = new BranchBean();
		UserCreationBean userCreationBean = new UserCreationBean();
		ItemVocherGenerationBean itemVocherGenerationBean = new ItemVocherGenerationBean();
		BillVocherGenerationBean billVocherGenerationBean = new BillVocherGenerationBean();
		DealerEncyKeyGenerationBean dealerEncyKeyGenerationBean = new DealerEncyKeyGenerationBean();
		DealerKeyGenerationBean dealerKeyGenerationBean = new DealerKeyGenerationBean();
		Integer dealerID=organizationMasterRequest.getDealerRegisterBean().getDealerId();
		System.out.println("dealer id in organisation service="+dealerID);
		
		UserCreationBean ucb = Utils.getCurrentUser(httpServletRequest);
    	organizationMasterRequest.getOrganizationMasterBean().setDealerId(dealerID);
    	
    	
		organizationMasterRequest.getOrganizationMasterBean()
				.setDealerKeyEncryption(organizationMasterRequest.getDealerEncyKeyGenerationBean().getDealerKey());
		organizationMasterBean = iOrganizationMasterDao.organizationMasterCreateDao(sessionFactory,
				organizationMasterRequest.getOrganizationMasterBean());

		if (organizationMasterBean != null) {
			organizationMasterBean = iOrganizationMasterDao.organizationSelectDao(sessionFactory,
					organizationMasterRequest.getOrganizationMasterBean());

			/**
			 * create branch details
			 */
			if (organizationMasterBean != null) {
				branchBean.setBranchMasterId(organizationMasterBean.getOrganizationId());
				branchBean.setBranchName(organizationMasterBean.getOrganzisationName());
				branchBean.setBranchAbbreviation(organizationMasterBean.getOrganzisationAbbreviation());
				branchBean.setBranchBuildingNo(organizationMasterBean.getOrganzisationBuildingNumber());
				branchBean.setBranchBuildingName(organizationMasterBean.getOrganzisationBuildingName());
				branchBean.setBranchStreet(organizationMasterBean.getOrganzisationStreet());
				branchBean.setBranchLocality(organizationMasterBean.getOrganzisationLocality());
				branchBean.setBranchDistrict(organizationMasterBean.getOrganzisationDistrict());
				branchBean.setBranchCity(organizationMasterBean.getOrganzisationCity());
				branchBean.setBranchState(organizationMasterBean.getOrganzisationState());
				branchBean.setBranchPinCode(organizationMasterBean.getOrganzisationPincode());
				branchBean.setBranchPhoneNumber(organizationMasterBean.getOrganzisationPhoneNumber1());
				branchBean.setBranchPhoneNumber2(organizationMasterBean.getOrganzisationPhoneNumber2());
				branchBean.setBranchPanNo(organizationMasterBean.getOrganzisationPermentAccountNumber());
				branchBean.setBranchTanNo(organizationMasterBean.getOrganzisationTaxAccountNumber());
				branchBean.setBranchOfficerId(organizationMasterBean.getOrganizationInchargeName());
				branchBean.setBranchDesignation(organizationMasterBean.getOfficerDesignation());
				branchBean.setBranchBuildingNo1(organizationMasterBean.getOfficerBuildingNumber());
				branchBean.setBranchBuildingName1(organizationMasterBean.getOfficerBuildingName());
				branchBean.setBranchStreet1(organizationMasterBean.getOfficerStreet());
				branchBean.setBranchLocality1(organizationMasterBean.getOfficerlocality());
				branchBean.setBranchDistrict1(organizationMasterBean.getOfficerDistrict());
				branchBean.setBranchCity1(organizationMasterBean.getOfficerCity());
				branchBean.setBranchState1(organizationMasterBean.getOfficerState());
				branchBean.setBranchPinCode1(organizationMasterBean.getOfficerPincode());
				branchBean.setBranchGstNo(organizationMasterBean.getGoodsAndServiceTaxNumber());
				branchBean = iOrganizationMasterDao.branchCreateDao(sessionFactory, branchBean);

				/**
				 * create user admin details
				 */

				userCreationBean.setEnteredBy(organizationMasterRequest.getUserCreationBean().getUserShortName());
				userCreationBean.setUserNumber(organizationMasterRequest.getUserCreationBean().getUserNumber());
				userCreationBean.setUserShortName(organizationMasterRequest.getUserCreationBean().getUserNumber());
				userCreationBean.setBranchNumber(organizationMasterBean.getOrganizationId());
				userCreationBean.setEnterDate(date);
				userCreationBean.setEnterTime(dateFormat.format(date));
				userCreationBean.setUserType("U");
				userCreationBean.setUserLevel("1");
				userCreationBean.setPasswordReset("Y");
				userCreationBean.setUserStatus("A");
				userCreationBean = iOrganizationMasterDao.userAdminCreateDao(sessionFactory, userCreationBean);

				/**
				 * updation of organization Id in item vocher generation table
				 */

				itemVocherGenerationBean.setBranchNumber(organizationMasterBean.getOrganizationId());
				itemVocherGenerationBean = iOrganizationMasterDao.itemVocherGenerationDao(sessionFactory,
						itemVocherGenerationBean);
				Integer branchNumber = organizationMasterBean.getOrganizationId();
				itemVocherGenerationBean = iOrganizationMasterDao.itemNumberUpdate(sessionFactory, branchNumber);

				/**
				 * updation of organization Id in bill vocher generation table
				 */

				billVocherGenerationBean.setBranchNumber(organizationMasterBean.getOrganizationId());
				billVocherGenerationBean = iOrganizationMasterDao.billVocherGenerationDao(sessionFactory,
						billVocherGenerationBean);
				billVocherGenerationBean = iOrganizationMasterDao.billNumberUpdate(sessionFactory, branchNumber);

				/**
				 * Updation of key status
				 */

			//	Integer dealerID = ucb.getDealerId();
				BigInteger dealerKey = organizationMasterRequest.getDealerKeyGenerationBean().getDealerKey();
				String dealerKeyEncy = organizationMasterRequest.getDealerEncyKeyGenerationBean().getDealerKey();
				dealerEncyKeyGenerationBean = iOrganizationMasterDao.dealerKeyGenerationDao(sessionFactory, dealerID,
						dealerKey, dealerKeyEncy);
			}
		}

		return organizationMasterBean;
	}

	/**
	 * update organization details
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
	public OrganizationMasterBean organizationMasterUpdateService(OrganizationMasterRequest organizationMasterRequest) {
		UserCreationBean ucb = Utils.getCurrentUser(httpServletRequest);
		String userNumber = ucb.getUserNumber();
		return iOrganizationMasterDao.organizationMasterUpdateDao(sessionFactory,
				organizationMasterRequest.getOrganizationMasterBean(), userNumber);

	}

	/**
	 * fetching of organization details based on user number
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true, isolation = Isolation.SERIALIZABLE)
	public List<UserCreationBean> organizationMasterFetch(String userNumber) {
		return iOrganizationMasterDao.organizationMasterFetch(sessionFactory, userNumber);
	}

	/**
	 * upload file organization
	 */
	@Override
	public OrganizationLogoBean organizationLogo(CommonsMultipartFile fileUpload, Integer orgId) {
		OrganizationLogoBean organizationLogoBean = new OrganizationLogoBean();

		organizationLogoBean.setFileData(fileUpload.getBytes());
		organizationLogoBean.setFileName(fileUpload.getOriginalFilename());
		organizationLogoBean.setOmgId(orgId);
		
		System.out.println(fileUpload.getContentType());
	
		return iOrganizationMasterDao.organizationLogo(sessionFactory, organizationLogoBean);
	}

	/**
	 * readFile organization
	 */

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
	public OrganizationLogoBean organisationLogofetch(Integer OmgId) {

		System.out.println("omg id=" + OmgId);
		return iOrganizationMasterDao.organisationLogoFetch(sessionFactory, OmgId);
	}

	@Override
	public OrganizationMasterBean organizationMasterFetchHeader(OrganizationMasterRequest organizationMasterRequest) {
		return  iOrganizationMasterDao.organisationHeaderFetch(sessionFactory, organizationMasterRequest);
	}

	@Override
	public OrganizationMasterBean organisationSmsStatusUpdateService(
			OrganizationMasterRequest organizationMasterRequest) {
		return iOrganizationMasterDao.organisationUpdateSmsStatusDao(sessionFactory, organizationMasterRequest);
		
	}

	

}
