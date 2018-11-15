package com.vyavharamitra.reports.dashboard.service;

import java.util.List;

import com.vyavharamitra.dealer.bean.DealerRegisterBean;
import com.vyavharamitra.reports.dashboard.to.request.DashboardRequest;

public interface IDashboardService {


	List<DealerRegisterBean> noofDealers();

	List<DealerRegisterBean> dealerDatiels();

	List<DealerRegisterBean> dOrgDatiels(DashboardRequest dashboardRequest);

	List<DealerRegisterBean> orgNoOfBills(DashboardRequest dashboardRequest);

	List<DealerRegisterBean> billNos(DashboardRequest dashboardRequest);

	List<DealerRegisterBean> users();

	List<DealerRegisterBean> noofBills();

}
