package com.vyavharamitra.reports.dashboard.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.vyavharamitra.dealer.bean.DealerRegisterBean;
import com.vyavharamitra.reports.dashboard.to.request.DashboardRequest;

public interface IDashboardDao {

	List<DealerRegisterBean> noofDealers(SessionFactory sessionFactory);

	List<DealerRegisterBean> dealerDatiels(SessionFactory sessionFactory);

	List<DealerRegisterBean> dOrgDatiels(DashboardRequest dashboardRequest, SessionFactory sessionFactory);

	List<DealerRegisterBean> orgNoOfBills(DashboardRequest dashboardRequest, SessionFactory sessionFactory);

	List<DealerRegisterBean> billNos(DashboardRequest dashboardRequest, SessionFactory sessionFactory);

	List<DealerRegisterBean> users(SessionFactory sessionFactory);

	List<DealerRegisterBean> noofBills(SessionFactory sessionFactory);

}
