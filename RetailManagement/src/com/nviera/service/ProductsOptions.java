package com.nviera.service;

import java.sql.ResultSet;

import com.nviera.constants.QueryConstants;
import com.nviera.dao.DbConnection;

public class ProductsOptions {
	
	public void ProductsAdding(String productName, double productMRP,double productGPPRice,int productPoints,String strEnteredBy) throws Exception {
		StringBuilder productsInsertQuery = new StringBuilder();
		StringBuilder productsSelectQuery = new StringBuilder();
		
		StringBuilder customerProductsInsertQuery = new StringBuilder();
		DbConnection db = new DbConnection();
		productsInsertQuery.append(QueryConstants.PRODUCTS_INSERT + " ('"+productName+"','"+productMRP+"','"+productGPPRice+"','"+productPoints+"' ) ");
		db.runPreparedStmt(productsInsertQuery.toString());
		productsSelectQuery.append(QueryConstants.PRODUCTS_SELECT + " WHERE PRODUCTS_NAME = '"+productName+"'  ");
		ResultSet rs = db.executeSelectQuery(productsSelectQuery.toString());
		if (rs.next()) {
			String strProsductId=rs.getString("PRODUCTS_SLNO");
			customerProductsInsertQuery.append("INSERT INTO CUSTPRODUCTS (CUSTPRODUCTS_CUSTNAME,CUSTPRODUCTS_PRODUCTID) SELECT CUSTOMER_DETAILS_NAME ,'"+strProsductId+"' FROM  CUSTOMER_DETAILS");
			db.runPreparedStmt(customerProductsInsertQuery.toString());
		}
		db.closeConnection();
	}
	
	public void ChangeProductsActDeact(String strProductId,String strStatus,String strEnteredBy) throws Exception {
		StringBuilder changeCustomerItemsUpdateQuery = new StringBuilder();
		StringBuilder changeCustomerProductsItemsUpdateQuery = new StringBuilder();
		DbConnection db = new DbConnection();
		changeCustomerItemsUpdateQuery.append(QueryConstants.PRODUCTS_UPDATION + " PRODUCTS_STA='"+strStatus+"' WHERE PRODUCTS_SLNO = '"+strProductId+"'");
		db.runPreparedStmt(changeCustomerItemsUpdateQuery.toString());
		changeCustomerProductsItemsUpdateQuery.append("UPDATE CUSTPRODUCTS SET CUSTPRODUCTS_STA='"+strStatus+"'  WHERE custproducts_PRODUCTID = '"+strProductId+"'");
		db.runPreparedStmt(changeCustomerProductsItemsUpdateQuery.toString());
		db.closeConnection();
	}
	
	public void ChangeCustProductsActDeact(String strShoppyName,String strProductId,String strStatus,int intQuantity,String strEnteredBy) throws Exception {
		StringBuilder changeCustomerProductsItemsUpdateQuery = new StringBuilder();
		DbConnection db = new DbConnection();
		changeCustomerProductsItemsUpdateQuery.append("UPDATE CUSTPRODUCTS SET CUSTPRODUCTS_STA='"+strStatus+"',custproducts_quantity = custproducts_quantity + '"+intQuantity+"'  WHERE CUSTPRODUCTS_PRODUCTID = '"+strProductId+"' and CUSTPRODUCTS_CUSTNAME ='"+strShoppyName+"' ");
		db.runPreparedStmt(changeCustomerProductsItemsUpdateQuery.toString());
		db.closeConnection();
	}

}
