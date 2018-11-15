package com.vyavharamitra.organization.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.SessionFactory;

import com.vyavharamitra.dealerkeygeneration.bean.DealerEncyKeyGenerationBean;
import com.vyavharamitra.greetings.beans.BranchBean;
import com.vyavharamitra.organization.bean.BillVocherGenerationBean;
import com.vyavharamitra.organization.bean.ItemVocherGenerationBean;
import com.vyavharamitra.organization.bean.OrganizationLogoBean;
import com.vyavharamitra.organization.bean.OrganizationMasterBean;
import com.vyavharamitra.organization.to.request.OrganizationMasterRequest;
import com.vyavharamitra.usercreation.bean.UserCreationBean;

/**
 * @author : lavanya
 * @created date : 24 Nov 2017
 * @modified by : 
 * @modified date :
 */


public interface IOrganizationMasterDao {

	public OrganizationMasterBean organizationMasterCreateDao(SessionFactory sessionFactory, OrganizationMasterBean organizationMasterBean);

	public OrganizationMasterBean organizationSelectDao(SessionFactory sessionFactory, OrganizationMasterBean organizationMasterBean);

	public BranchBean  branchCreateDao(SessionFactory sessionFactory, BranchBean branchBean);

	public OrganizationMasterBean organizationMasterUpdateDao(SessionFactory sessionFactory, OrganizationMasterBean organizationMasterBean, String userNumber);

	public UserCreationBean  userAdminCreateDao(SessionFactory sessionFactory, UserCreationBean userCreationBean);

	public ItemVocherGenerationBean  itemVocherGenerationDao(SessionFactory sessionFactory, ItemVocherGenerationBean itemVocherGenerationBean);

	public BillVocherGenerationBean  billVocherGenerationDao(SessionFactory sessionFactory, BillVocherGenerationBean billVocherGenerationBean);

	public DealerEncyKeyGenerationBean dealerKeyGenerationDao(SessionFactory sessionFactory, Integer dealerID,
			BigInteger dealerKey, String dealerKeyEncy);


	public List<UserCreationBean> organizationMasterFetch(SessionFactory sessionFactory,String userNumber);

	public BillVocherGenerationBean billNumberUpdate(SessionFactory sessionFactory,Integer branchNumber);

	public ItemVocherGenerationBean itemNumberUpdate(SessionFactory sessionFactory, Integer branchNumber);

	public OrganizationLogoBean organizationLogo(SessionFactory sessionFactory,	OrganizationLogoBean organizationLogoBean);

    public OrganizationLogoBean organisationLogoFetch(SessionFactory sessionFactory,Integer OmgId );

	public OrganizationMasterBean organisationHeaderFetch(SessionFactory sessionFactory,
			OrganizationMasterRequest organizationMasterRequest);
   
   public OrganizationMasterBean organisationUpdateSmsStatusDao(SessionFactory  sessionFactory,OrganizationMasterRequest organizationMasterRequest);


}
