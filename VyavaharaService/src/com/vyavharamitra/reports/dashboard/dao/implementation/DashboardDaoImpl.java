package com.vyavharamitra.reports.dashboard.dao.implementation;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.dealer.bean.DealerRegisterBean;
import com.vyavharamitra.reports.dashboard.dao.IDashboardDao;
import com.vyavharamitra.reports.dashboard.to.request.DashboardRequest;
import com.vyavharamitra.utils.Utils;

@Repository

public class DashboardDaoImpl implements IDashboardDao {
	private Session session;

	@SuppressWarnings("unchecked")
	public List<DealerRegisterBean> noofDealers(SessionFactory sessionFactory) {
		List<DealerRegisterBean> dealerRegisterBean = null;
		try {
			 session = sessionFactory.openSession();
			session.getTransaction().begin();
			dealerRegisterBean = session.createSQLQuery("select count(dlr_id) as dealercount from bil_dlr ").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();

			}
		}
		if(!Utils.isNullList(dealerRegisterBean))
		{
			return dealerRegisterBean;
		}
		return dealerRegisterBean;
	}
	
	@SuppressWarnings("unchecked")
	public List<DealerRegisterBean> noofBills(SessionFactory sessionFactory) {
		List<DealerRegisterBean> dealerRegisterBean = null;
		try {
			 session = sessionFactory.openSession();
			session.getTransaction().begin();
			dealerRegisterBean = session.createSQLQuery("select count(sellitem_billno) as billcount from bil_sellitem").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();

			}
		}
		if(!Utils.isNullList(dealerRegisterBean))
		{
			return dealerRegisterBean;
		}
		return dealerRegisterBean;
	}

	@SuppressWarnings("unchecked")
	public List<DealerRegisterBean> dealerDatiels(SessionFactory sessionFactory) {
		List<DealerRegisterBean> dealerRegisterBean = null;
		try {
			 session = sessionFactory.openSession();
			session.getTransaction().begin();
			dealerRegisterBean = session
					.createSQLQuery(
							"select d.dlr_id as id,d.dlr_name as name,d.dlr_add1 as add1,d.dlr_add2 as add2,d.dlr_loclity as loclity,d.dlr_street as street,d.dlr_pincode as pincode,count(k.dlrkey_key) as total,count(case dlrkey_status when 'N' then 1 else null end ) as Inactive , count(case dlrkey_status when 'Y' then 1 else null end ) as active,d.dlr_eby as eby,to_char(d.dlr_eon, 'dd Mon yyyy') as eon,d.dlr_etime as etime from bil_dlr d LEFT JOIN bil_dlrkey k on d.dlr_id=k.dlrkey_id group by d.dlr_id,d.dlr_name order by d.dlr_id ")
					.list();
			session.getTransaction().commit();
		} catch (Exception e) {
		Utils.logger("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();

			}
		}
		if(!Utils.isNullList(dealerRegisterBean))
		{
			return dealerRegisterBean;
		}
		return dealerRegisterBean;
	}

	@SuppressWarnings("unchecked")
	public List<DealerRegisterBean> dOrgDatiels(DashboardRequest dashboardRequest, SessionFactory sessionFactory) {
		List<DealerRegisterBean> dealerRegisterBean = null;
		try {
			 session = sessionFactory.openSession();
			session.getTransaction().begin();
			Integer dealerId = (dashboardRequest.getDealerRegisterBean().getDealerId());
			dealerRegisterBean = (List<DealerRegisterBean>) session.createSQLQuery(
					"select om_id,om_name , om_bdno,om_bdname,om_srt,om_lty,om_dist,om_city,om_pin,to_char(om_date,'dd Mon yyyy') as om_date ,dlr_name   from bil_om, bil_dlr where dlr_id=om_dlrid and dlr_id='"
							+ dealerId + "' order by om_id ")
					.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();

			}
		}
		if(!Utils.isNullList(dealerRegisterBean))
		{
			return dealerRegisterBean;
		}
		return dealerRegisterBean;
	}

	@SuppressWarnings("unchecked")
	public List<DealerRegisterBean> orgNoOfBills(DashboardRequest dashboardRequest, SessionFactory sessionFactory) {
		List<DealerRegisterBean> dealerRegisterBean = null;
		try {
			 session = sessionFactory.openSession();
			session.getTransaction().begin();
			Integer orgId = (dashboardRequest.getDealerRegisterBean().getOrgId());
			dealerRegisterBean = (List<DealerRegisterBean>) session
					.createSQLQuery(
							"select to_char(sellitem_edate,'yyyy-mm-dd') as sellitem_edate ,count(sellitem_billno) as sellitem_billno ,sellitem_bid from bil_sellitem where sellitem_bid='"
									+ orgId + "' group by  sellitem_edate,sellitem_bid order by sellitem_edate ")
					.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();

			}
		}
		if(!Utils.isNullList(dealerRegisterBean))
		{
			return dealerRegisterBean;
		}
		return dealerRegisterBean;
	}

	@SuppressWarnings("unchecked")
	public List<DealerRegisterBean> billNos(DashboardRequest dashboardRequest, SessionFactory sessionFactory) {
		List<DealerRegisterBean> dealerRegisterBean = null;
		try {
			 session = sessionFactory.openSession();
			session.getTransaction().begin();
			Integer orgId = (dashboardRequest.getDealerRegisterBean().getOrgId());
			Date orgdate = (dashboardRequest.getDealerRegisterBean().getOrgdate());
			dealerRegisterBean = (List<DealerRegisterBean>) session
					.createSQLQuery("select sellitem_sid,sellitem_billno,sellitem_bid from bil_sellitem where sellitem_bid='" + orgId
							+ "' and sellitem_edate='" + orgdate + "' ")
					.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();

			}
		}
		if(!Utils.isNullList(dealerRegisterBean))
		{
			return dealerRegisterBean;
		}
		return dealerRegisterBean;
	}

	@SuppressWarnings("unchecked")
	public List<DealerRegisterBean> users(SessionFactory sessionFactory) {
		List<DealerRegisterBean> dealerRegisterBean = null;
		try {
			 session = sessionFactory.openSession();
			session.getTransaction().begin();
			dealerRegisterBean = (List<DealerRegisterBean>) session
					.createSQLQuery("select  distinct usmlog_bid,sellitem_billno,usmlog_lidt,sellitem_sid,sellitem_eby,to_char(sellitem_sdate,'yyyy-mm-dd') as sellitem_sdate from bil_usmlog,bil_sellitem where usmlog_bid=sellitem_bid and usmlog_lidt=sellitem_sdate order by usmlog_lidt desc ")
					.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();

			}
		}
		if(!Utils.isNullList(dealerRegisterBean))
		{
			return dealerRegisterBean;
		}
		return dealerRegisterBean;
	}

}
