 package com.vyavharamitra.organization.dao.implementation;

/**
 * @author : lavanya
 * @created date : 24 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.dealerkeygeneration.bean.DealerEncyKeyGenerationBean;
import com.vyavharamitra.greetings.beans.BranchBean;
import com.vyavharamitra.organization.bean.BillVocherGenerationBean;
import com.vyavharamitra.organization.bean.ItemVocherGenerationBean;
import com.vyavharamitra.organization.bean.OrganizationLogoBean;
import com.vyavharamitra.organization.bean.OrganizationMasterBean;
import com.vyavharamitra.organization.dao.IOrganizationMasterDao;
import com.vyavharamitra.organization.to.request.OrganizationMasterRequest;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.Utils;

@Repository
public class OrganizationMasterDaoImp implements IOrganizationMasterDao {
	private Session session;

	DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	Date date = new Date();

	/**
	 * create organization details
	 */

	public OrganizationMasterBean organizationMasterCreateDao(SessionFactory sessionFactory,
			OrganizationMasterBean organizationMasterBean) {
		session = sessionFactory.openSession();

		session.saveOrUpdate(organizationMasterBean);
		session.beginTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if (!Utils.isNullList(organizationMasterBean)) {
			return organizationMasterBean;
		}
		return organizationMasterBean;
	}

	/**
	 * update organization details
	 */

	public OrganizationMasterBean organizationMasterUpdateDao(SessionFactory sessionFactory,
			OrganizationMasterBean organizationMasterBean, String userNumber) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		String organzisationName = (organizationMasterBean.getOrganzisationName());
		String organzisationAbbreviation = (organizationMasterBean.getOrganzisationAbbreviation());
		String organzisationBuildingNumber = (organizationMasterBean.getOrganzisationBuildingNumber());
		String organzisationBuildingName = (organizationMasterBean.getOrganzisationBuildingName());
		String organzisationStreet = (organizationMasterBean.getOrganzisationStreet());
		String organzisationLocality = (organizationMasterBean.getOrganzisationLocality());
		String organzisationDistrict = (organizationMasterBean.getOrganzisationDistrict());
		String organzisationCity = (organizationMasterBean.getOrganzisationCity());
		String organzisationState = (organizationMasterBean.getOrganzisationState());
		BigInteger organzisationPincode = (organizationMasterBean.getOrganzisationPincode());
		BigInteger organzisationPhoneNumber1 = (organizationMasterBean.getOrganzisationPhoneNumber1());
		BigInteger organzisationPhoneNumber2 = (organizationMasterBean.getOrganzisationPhoneNumber2());
		String organzisationPermentAccountNumber = (organizationMasterBean.getOrganzisationPermentAccountNumber());
		String organzisationTaxAccountNumber = (organizationMasterBean.getOrganzisationTaxAccountNumber());
		String organizationInchargeName = (organizationMasterBean.getOrganizationInchargeName());
		String officerDesignation = (organizationMasterBean.getOfficerDesignation());
		String officerBuildingNumber = (organizationMasterBean.getOfficerBuildingNumber());
		String officerBuildingName = (organizationMasterBean.getOfficerBuildingName());
		String officerStreet = (organizationMasterBean.getOfficerStreet());
		String officerlocality = (organizationMasterBean.getOfficerlocality());
		String officerDistrict = (organizationMasterBean.getOfficerDistrict());
		String officerCity = (organizationMasterBean.getOfficerCity());
		String officerState = (organizationMasterBean.getOfficerState());
		BigInteger officerPincode = (organizationMasterBean.getOfficerPincode());
		BigInteger officerMobileNumber = (organizationMasterBean.getOfficerMobileNumber());
		String officerEmailId = (organizationMasterBean.getOfficerEmailId());
		String goodsAndServiceTaxNumber = (organizationMasterBean.getGoodsAndServiceTaxNumber());
		String organzisationImageFile = null;
		/**
		 * organization details update query
		 */

		Query organizationUpdateQuery = session.createSQLQuery("UPDATE bil_om SET om_name =:organzisationName,"
				+ "om_abbrv =:organzisationAbbreviation,om_bdno =:organzisationBuildingNumber,om_bdname =:organzisationBuildingName,"
				+ "om_srt =:organzisationStreet,om_lty =:organzisationLocality,om_dist =:organzisationDistrict,"
				+ "om_city =:organzisationCity,om_st =:organzisationState,om_pin =:organzisationPincode,om_ph1 =:organzisationPhoneNumber1,"
				+ "om_ph2 =:organzisationPhoneNumber2,om_pan =:organzisationPermentAccountNumber,om_tan =:organzisationTaxAccountNumber,"
				+ "om_gst =:goodsAndServiceTaxNumber,om_imgfile =:organzisationImageFile,om_oi =:organizationInchargeName,om_dsg =:officerDesignation,"
				+ "om_bdno1 =:officerBuildingNumber,om_bdname1 =:officerBuildingName,om_srt1 =:officerStreet,om_lty1 =:officerlocality,"
				+ "om_dist1 =:officerDistrict,om_city1 =:officerCity,om_st1 =:officerState,om_pin1 =:officerPincode,"
				+ "om_mobno =:officerMobileNumber,om_eid =:officerEmailId from bil_usm where usm_uid =:userNumber and usm_bid=om_id");
		organizationUpdateQuery = organizationUpdateQuery.setParameter("organzisationName", organzisationName);
		organizationUpdateQuery = organizationUpdateQuery.setParameter("organzisationAbbreviation",
				organzisationAbbreviation);
		organizationUpdateQuery = organizationUpdateQuery.setParameter("organzisationBuildingNumber",
				organzisationBuildingNumber);
		organizationUpdateQuery = organizationUpdateQuery.setParameter("organzisationBuildingName",
				organzisationBuildingName);
		organizationUpdateQuery = organizationUpdateQuery.setParameter("organzisationStreet", organzisationStreet);
		organizationUpdateQuery = organizationUpdateQuery.setParameter("organzisationLocality", organzisationLocality);
		organizationUpdateQuery = organizationUpdateQuery.setParameter("organzisationDistrict", organzisationDistrict);
		organizationUpdateQuery = organizationUpdateQuery.setParameter("organzisationCity", organzisationCity);
		organizationUpdateQuery = organizationUpdateQuery.setParameter("organzisationState", organzisationState);
		organizationUpdateQuery = organizationUpdateQuery.setParameter("organzisationPincode", organzisationPincode);
		organizationUpdateQuery = organizationUpdateQuery.setParameter("organzisationPhoneNumber1",
				organzisationPhoneNumber1);
		organizationUpdateQuery = organizationUpdateQuery.setParameter("organzisationPhoneNumber2",
				organzisationPhoneNumber2);
		organizationUpdateQuery = organizationUpdateQuery.setParameter("organzisationPermentAccountNumber",
				organzisationPermentAccountNumber);
		organizationUpdateQuery = organizationUpdateQuery.setParameter("organzisationTaxAccountNumber",
				organzisationTaxAccountNumber);
		organizationUpdateQuery = organizationUpdateQuery.setParameter("goodsAndServiceTaxNumber",
				goodsAndServiceTaxNumber);
		organizationUpdateQuery = organizationUpdateQuery.setParameter("organzisationImageFile",
				organzisationImageFile);
		organizationUpdateQuery = organizationUpdateQuery.setParameter("organizationInchargeName",
				organizationInchargeName);
		organizationUpdateQuery = organizationUpdateQuery.setParameter("officerDesignation", officerDesignation);
		organizationUpdateQuery = organizationUpdateQuery.setParameter("officerBuildingNumber", officerBuildingNumber);
		organizationUpdateQuery = organizationUpdateQuery.setParameter("officerBuildingName", officerBuildingName);
		organizationUpdateQuery = organizationUpdateQuery.setParameter("officerStreet", officerStreet);
		organizationUpdateQuery = organizationUpdateQuery.setParameter("officerlocality", officerlocality);
		organizationUpdateQuery = organizationUpdateQuery.setParameter("officerDistrict", officerDistrict);
		organizationUpdateQuery = organizationUpdateQuery.setParameter("officerCity", officerCity);
		organizationUpdateQuery = organizationUpdateQuery.setParameter("officerState", officerState);
		organizationUpdateQuery = organizationUpdateQuery.setParameter("officerPincode", officerPincode);
		organizationUpdateQuery = organizationUpdateQuery.setParameter("officerMobileNumber", officerMobileNumber);
		organizationUpdateQuery = organizationUpdateQuery.setParameter("officerEmailId", officerEmailId);
		organizationUpdateQuery = organizationUpdateQuery.setParameter("userNumber", userNumber);
		organizationUpdateQuery.executeUpdate();

		/**
		 * branch details update query
		 */

		Query branchUpdateQuery = session
				.createSQLQuery("UPDATE bil_bm SET bm_name =:organzisationName,bm_abbrv =:organzisationAbbreviation,"
						+ "bm_bdno =:organzisationBuildingNumber,bm_bdname =:organzisationBuildingName,bm_srt =:organzisationStreet,"
						+ "bm_lty =:organzisationLocality,bm_dist =:organzisationDistrict,bm_city =:organzisationCity,bm_st =:organzisationState,"
						+ "bm_pin =:organzisationPincode,bm_ph1 =:organzisationPhoneNumber1,bm_ph2 =:organzisationPhoneNumber2,"
						+ "bm_pan =:organzisationPermentAccountNumber,bm_tan =:organzisationTaxAccountNumber,bm_gstin =:goodsAndServiceTaxNumber,"
						+ "bm_imgfile =:organzisationImageFile,bm_oi =:organizationInchargeName,bm_dsg =:officerDesignation,"
						+ "bm_bdno1 =:officerBuildingNumber,bm_bdname1 =:officerBuildingName,bm_srt1 =:officerStreet,bm_lty1 =:officerlocality,"
						+ "bm_dist1 =:officerDistrict,bm_city1 =:officerCity,bm_st1 =:officerState,bm_pin1 =:officerPincode,bm_mobno =:officerMobileNumber,"
						+ "bm_eid =:officerEmailId from bil_usm,bil_om where usm_uid =:userNumber and  usm_bid=om_id and om_id=bm_id");
		branchUpdateQuery = branchUpdateQuery.setParameter("organzisationName", organzisationName);
		branchUpdateQuery = branchUpdateQuery.setParameter("organzisationAbbreviation", organzisationAbbreviation);
		branchUpdateQuery = branchUpdateQuery.setParameter("organzisationBuildingNumber", organzisationBuildingNumber);
		branchUpdateQuery = branchUpdateQuery.setParameter("organzisationBuildingName", organzisationBuildingName);
		branchUpdateQuery = branchUpdateQuery.setParameter("organzisationStreet", organzisationStreet);
		branchUpdateQuery = branchUpdateQuery.setParameter("organzisationLocality", organzisationLocality);
		branchUpdateQuery = branchUpdateQuery.setParameter("organzisationDistrict", organzisationDistrict);
		branchUpdateQuery = branchUpdateQuery.setParameter("organzisationCity", organzisationCity);
		branchUpdateQuery = branchUpdateQuery.setParameter("organzisationState", organzisationState);
		branchUpdateQuery = branchUpdateQuery.setParameter("organzisationPincode", organzisationPincode);
		branchUpdateQuery = branchUpdateQuery.setParameter("organzisationPhoneNumber1", organzisationPhoneNumber1);
		branchUpdateQuery = branchUpdateQuery.setParameter("organzisationPhoneNumber2", organzisationPhoneNumber2);
		branchUpdateQuery = branchUpdateQuery.setParameter("organzisationPermentAccountNumber",
				organzisationPermentAccountNumber);
		branchUpdateQuery = branchUpdateQuery.setParameter("organzisationTaxAccountNumber",
				organzisationTaxAccountNumber);
		branchUpdateQuery = branchUpdateQuery.setParameter("goodsAndServiceTaxNumber", goodsAndServiceTaxNumber);
		branchUpdateQuery = branchUpdateQuery.setParameter("organzisationImageFile", organzisationImageFile);
		branchUpdateQuery = branchUpdateQuery.setParameter("organizationInchargeName", organizationInchargeName);
		branchUpdateQuery = branchUpdateQuery.setParameter("officerDesignation", officerDesignation);
		branchUpdateQuery = branchUpdateQuery.setParameter("officerBuildingNumber", officerBuildingNumber);
		branchUpdateQuery = branchUpdateQuery.setParameter("officerBuildingName", officerBuildingName);
		branchUpdateQuery = branchUpdateQuery.setParameter("officerStreet", officerStreet);
		branchUpdateQuery = branchUpdateQuery.setParameter("officerlocality", officerlocality);
		branchUpdateQuery = branchUpdateQuery.setParameter("officerDistrict", officerDistrict);
		branchUpdateQuery = branchUpdateQuery.setParameter("officerCity", officerCity);
		branchUpdateQuery = branchUpdateQuery.setParameter("officerState", officerState);
		branchUpdateQuery = branchUpdateQuery.setParameter("officerPincode", officerPincode);
		branchUpdateQuery = branchUpdateQuery.setParameter("officerMobileNumber", officerMobileNumber);
		branchUpdateQuery = branchUpdateQuery.setParameter("officerEmailId", officerEmailId);
		branchUpdateQuery = branchUpdateQuery.setParameter("userNumber", userNumber);
		branchUpdateQuery.executeUpdate();

		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if (!Utils.isNullList(organizationMasterBean)) {
			return organizationMasterBean;
		}
		return organizationMasterBean;

	}

	/**
	 * create branch details
	 */

	public BranchBean branchCreateDao(SessionFactory sessionFactory, BranchBean branchBean) {
		session = sessionFactory.openSession();

		session.save(branchBean);
		session.beginTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if (!Utils.isNullList(branchBean)) {
			return branchBean;
		}
		return branchBean;
	}

	/**
	 * creation of user admin details
	 */

	public UserCreationBean userAdminCreateDao(SessionFactory sessionFactory, UserCreationBean userCreationBean) {
		session = sessionFactory.openSession();

		session.save(userCreationBean);
		session.beginTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if (!Utils.isNullList(userCreationBean)) {
			return userCreationBean;
		}
		return userCreationBean;
	}

	/**
	 * creation of organization Id in item vocher generation table
	 */

	public ItemVocherGenerationBean itemVocherGenerationDao(SessionFactory sessionFactory,
			ItemVocherGenerationBean itemVocherGenerationBean) {
		session = sessionFactory.openSession();

		session.save(itemVocherGenerationBean);
		session.beginTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if (!Utils.isNullList(itemVocherGenerationBean)) {
			return itemVocherGenerationBean;
		}
		return itemVocherGenerationBean;
	}

	public ItemVocherGenerationBean itemNumberUpdate(SessionFactory sessionFactory, Integer branchNumber) {
		ItemVocherGenerationBean itemVocherGenerationBean = new ItemVocherGenerationBean();
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query itemNumberUpdateQuery = session
				.createSQLQuery("update bil_bitem set bitem_itemid='0' where bitem_bid =:branchNumber");
		itemNumberUpdateQuery = itemNumberUpdateQuery.setParameter("branchNumber", branchNumber);
		itemNumberUpdateQuery.executeUpdate();

		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if (!Utils.isNullList(itemVocherGenerationBean)) {
			return itemVocherGenerationBean;
		}
		return itemVocherGenerationBean;
	}

	/**
	 * creation of organization Id in bill vocher generation table
	 */

	public BillVocherGenerationBean billVocherGenerationDao(SessionFactory sessionFactory,
			BillVocherGenerationBean billVocherGenerationBean) {
		session = sessionFactory.openSession();

		session.save(billVocherGenerationBean);
		session.beginTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if (!Utils.isNullList(billVocherGenerationBean)) {
			return billVocherGenerationBean;
		}
		return billVocherGenerationBean;
	}

	public BillVocherGenerationBean billNumberUpdate(SessionFactory sessionFactory, Integer branchNumber) {
		BillVocherGenerationBean billVocherGenerationBean = new BillVocherGenerationBean();
		session = sessionFactory.openSession();
		session.beginTransaction();

		Query billNumberUpdateQuery = session
				.createSQLQuery("update bil_vn set vn_billno='0' where vn_bid =:branchNumber ");
		billNumberUpdateQuery = billNumberUpdateQuery.setParameter("branchNumber", branchNumber);
		billNumberUpdateQuery.executeUpdate();

		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if (!Utils.isNullList(billVocherGenerationBean)) {
			return billVocherGenerationBean;
		}
		return billVocherGenerationBean;
	}

	/**
	 * Updation of key status
	 */

	public DealerEncyKeyGenerationBean dealerKeyGenerationDao(SessionFactory sessionFactory, Integer dealerID,
			BigInteger dealerKey, String dealerKeyEncy) {
		DealerEncyKeyGenerationBean dealerEncyKeyGenerationBean = new DealerEncyKeyGenerationBean();
		session = sessionFactory.openSession();
		session.beginTransaction();

		Query keystatusUpdateQuery = session.createSQLQuery("update bil_dlrkey set dlrkey_status='Y' ,dlrkey_adate='"
				+ date
				+ "', dlrkey_atime = to_char(now(),'HH24:MI:SS')   where  dlrkey_id =:dealerID and cast(dlrkey_key as numeric) =:dealerKey ");
		keystatusUpdateQuery = keystatusUpdateQuery.setParameter("dealerID", dealerID);
		keystatusUpdateQuery = keystatusUpdateQuery.setParameter("dealerKey", dealerKey);
		keystatusUpdateQuery.executeUpdate();

		Query keystatusUpdateQueryEncy = session.createSQLQuery(
				"update bil_dlrkeyen set dlrkeyen_status='Y' where  dlrkeyen_id =:dealerID and dlrkeyen_enkey =:dealerKeyEncy");
		keystatusUpdateQueryEncy = keystatusUpdateQueryEncy.setParameter("dealerID", dealerID);
		keystatusUpdateQueryEncy = keystatusUpdateQueryEncy.setParameter("dealerKeyEncy", dealerKeyEncy);
		keystatusUpdateQueryEncy.executeUpdate();

		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if (!Utils.isNullList(dealerEncyKeyGenerationBean)) {
			return dealerEncyKeyGenerationBean;
		}

		return dealerEncyKeyGenerationBean;
	}

	/**
	 * selection of organization details
	 */

	public OrganizationMasterBean organizationSelectDao(SessionFactory sessionFactory,
			OrganizationMasterBean organizationMasterBean) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		OrganizationMasterBean categoryDetails = (OrganizationMasterBean) session
				.createCriteria(OrganizationMasterBean.class)
				.add(Restrictions.eq("organizationId", organizationMasterBean.getOrganizationId())).uniqueResult();
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if (!Utils.isNullList(categoryDetails)) {
			return categoryDetails;
		}
		return categoryDetails;
	}

	/**
	 * fetching of organization details based on user number
	 */
	@SuppressWarnings("unchecked")
	public List<UserCreationBean> organizationMasterFetch(SessionFactory sessionFactory, String userNumber) {
		List<UserCreationBean> organizationList = Collections.emptyList();
		try {
			session = sessionFactory.openSession();
			Criteria organizationDetails = session.createCriteria(UserCreationBean.class)
					.add(Restrictions.eq("userStatus", "A")).add(Restrictions.eq("userNumber", userNumber));
			organizationList = organizationDetails.list();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		}
		if (!Utils.isNullList(organizationList)) {
			return organizationList;
		}
		return organizationList;
	}

	@Override
	public OrganizationLogoBean organizationLogo(SessionFactory sessionFactory,
			OrganizationLogoBean organizationLogoBean) {
		session = sessionFactory.openSession();
		session.saveOrUpdate(organizationLogoBean);
		session.beginTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		return organizationLogoBean;
	}

	/**
	 * readFile organization file
	 */
	@SuppressWarnings("unchecked")
	public OrganizationLogoBean organisationLogoFetch(SessionFactory sessionFactory, Integer OmgId) {

		
		session = sessionFactory.openSession();
		session.beginTransaction();
		OrganizationLogoBean organisationLogoDetails = (OrganizationLogoBean) session
				.createCriteria(OrganizationLogoBean.class).add(Restrictions.eq("omgId", OmgId)).uniqueResult();
		session.getTransaction().commit();
		
		if (session.isOpen()) {
			session.close();
		}
		if (!Utils.isNullList(organisationLogoDetails)) {
			return organisationLogoDetails;
		}

		return organisationLogoDetails;
	}

	@Override
	public OrganizationMasterBean organisationHeaderFetch(SessionFactory sessionFactory, OrganizationMasterRequest organizationMasterRequest) {
		OrganizationMasterBean organizationMasterBean;
		session = sessionFactory.openSession();
		session.beginTransaction();
		organizationMasterBean = (OrganizationMasterBean) session.createCriteria(OrganizationMasterBean.class).add(Restrictions.eq("organizationId", organizationMasterRequest.getOrganizationMasterBean().getOrganizationId())).uniqueResult();
		if (session.isOpen()) {
			session.close();
		}
		if (!Utils.isNullList(organizationMasterBean)) {
			return organizationMasterBean;
		}

		return organizationMasterBean;
	}

	@Override
	@SuppressWarnings("unchecked")
	public OrganizationMasterBean organisationUpdateSmsStatusDao(SessionFactory sessionFactory,
			OrganizationMasterRequest organizationMasterRequest) {
	OrganizationMasterBean organizationMasterBean=new OrganizationMasterBean();
	session=sessionFactory.openSession();
	session.beginTransaction();
	Integer OrgId=	organizationMasterRequest.getOrganizationMasterBean().getOrganizationId();
	String orgSmsStatus=organizationMasterRequest.getOrganizationMasterBean().getOrgSmsStatus();
	System.out.println("organisationId="+OrgId);
	System.out.println("orgStatus="+orgSmsStatus);
	
     /*Query orgUpdateQuery=	session.createSQLQuery("update bil_om set om_smsstatus='" + orgSmsStatus
			+ "'  from bil_om where om_id='"
			+ OrgId + "' ");*/
	
	/*Query orgQuery = session.createQuery("UPDATE bil_om SET om_smsstatus = '"+ orgSmsStatus +"' WHERE om_id = '"+OrgId+ "'");
	//Query orgQuery=session.createQuery("update bil_om set om_smsstatus= '"+orgSmsStatus+"' from bil_om where om_id='"+OrgId+"" );
	
	orgQuery.executeUpdate();*/
     
     OrganizationMasterBean orgBean = (OrganizationMasterBean) session.get(OrganizationMasterBean.class, OrgId);
     orgBean.setOrgSmsStatus(orgSmsStatus);
	session.getTransaction().commit();
	if(session.isOpen())
	{
		session.close();
	}
	
	if(!Utils.isNullList(organizationMasterBean))
	{
		return organizationMasterBean;
	}
	
	return organizationMasterBean;
	}

	
}