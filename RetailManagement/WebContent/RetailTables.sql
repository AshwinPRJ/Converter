	/* ADMIN TABLE DETAILS */
DROP TABLE admin_details;
CREATE TABLE admin_details
(
  admin_details_id serial,
  admin_details_userid character varying(20),
  admin_details_password character varying(20),
  admin_details_birth_place character varying(20),
  admin_details_birth_city character varying(20),
  admin_details_dob date,
  admin_details_sta char(1) default 'A',
  admin_details_created_by character Varying(20),
  admin_details_created_on date,
  admin_details_created_time character Varying(10)
);
INSERT INTO ADMIN_DETAILS (ADMIN_DETAILS_USERID,ADMIN_DETAILS_PASSWORD) VALUES ('admin','shoppy');
/* CUSTOMER DETAILS TABLE */
DROP TABLE customer_details;
CREATE TABLE customer_details
(
  customer_details_id serial,
  customer_details_name character varying(30),
  customer_details_password character varying(20),
  customer_details_shop_name character varying(30),
  customer_details_place character varying(30),
  customer_details_city character varying(30),
  customer_details_wallet_amount numeric(15,2),
  customer_details_foodItems numeric(5,2),
  customer_details_nonfoodItems numeric(5,2),
  customer_details_since date,
  customer_details_last_recharge date,
  customer_details_last_debited date,
  customer_details_wallet_amount_left numeric(15,2),
  customer_details_wallet_amount_debited_till_date numeric(15,2),
  customer_details_sta char(1) default 'A',
  customer_details_pswd_reset char(1) default 'N',
  customer_details_items_percent_change character(1) default 'N',
  customer_details_product_change character(1) default 'N',
  customer_details_created_by character varying(20),
  customer_details_created_on date,
  customer_details_created_time character varying(10),
  customer_details_updated_by character varying(20),
  customer_details_updated_on date,
  customer_details_updated_time character varying(10)
);
/*USER DETAILS TABLE */
DROP TABLE user_details;
CREATE TABLE user_details
(
  user_details_id serial,
  user_details_grahakid character varying(50),
  user_details_fullname character varying(100),
  user_details_mobile numeric,
  user_details_address character varying(200),
  user_details_city character varying(30),
  user_details_state character varying(30),
  user_details_email character varying(100),
  user_details_is_admin character (1) default 'N',
  user_details_last_visit date,
  user_details_last_totamt_purchased numeric(15,2),
  user_details_earned_points integer default 0,
  user_details_sta char(1) default 'A',
  user_details_created_by character varying(20),
  user_details_created_on date,
  user_details_created_time character varying(10),
  user_details_updated_by character varying(20),
  user_details_updated_on date,
  user_details_updated_time character varying(10)
);
/*USER POINTS TABLE */
DROP TABLE user_points_details;
CREATE TABLE user_points_details
(
  user_points_id serial,
  user_points_grahakid character varying(50),
  user_points_user_points integer,
  user_points_created_by character varying(20),
  user_points_created_on date,
  user_points_created_time character varying(10),
  user_points_update_by character varying(20),
  user_points_updated_on date,
  user_points_update_time character varying(10)
);
/* USER TRANSACTIONS TABLE */
DROP TABLE user_transactions;
CREATE TABLE user_transactions
(
  user_transactions_id serial,
  user_transactions_grahakid character varying(50),
  user_transactions_user_number character varying(30),
  user_transactions_food_purchased numeric(15,2),
  user_transactions_nonfood_purchased numeric(15,2),
  user_transactions_total_amount_purchased numeric(15,2),
  user_transactions_earned_points integer,
  user_transactions_created_by character varying(20),
  user_transactions_created_on date,
  user_transactions_created_time character varying(10),
  user_transactions_updated_by character varying(20),
  user_transactions_updated_on date,
  user_transactions_updated_time character varying(10)
);
/*Customer Transaction Table*/
DROP TABLE cust_transactions;
CREATE TABLE cust_transactions
(
  cust_transactions_id serial,
  cust_transactions_cust_id integer,
  cust_transactions_total_amount_purchased numeric(15,2),
  cust_transactions_created_by character varying(20),
  cust_transactions_created_on date,
  cust_transactions_created_time character varying(10)
);
/* Products List */
DROP TABLE products;
CREATE TABLE products
(
  products_slno serial,
  products_name character varying(50),
  products_mrp numeric(15,2),
  products_gpprice numeric(15,2),
  products_points numeric(15,0),
  products_sta character (1) default 'A'
);
/*Old Product Details*/
/*
insert into products (products_name,products_gpprice,products_points) values ('RADIATION SAFE GUARD',2450,709);
insert into products (products_name,products_gpprice,products_points) values ('KISAN SANJEEVINI',1600,679);
insert into products (products_name,products_gpprice,products_points) values ('GAS SAFTY DEVICE',2200,717);
insert into products (products_name,products_gpprice,products_points) values ('OZONE WATER PURIFIER',3750,1447);
insert into products (products_name,products_gpprice,products_points) values ('DIABETIC CARE + NONI DROPS',1300,700);
insert into products (products_name,products_gpprice,products_points) values ('FEMOWIN (LADY CARE) + PREMIMUM NONI 800 ML',1450,700);
insert into products (products_name,products_gpprice,products_points) values ('KALPAMURTHA + PREMIMUM NONI 800 ML',2450,709);
insert into products (products_name,products_gpprice,products_points) values ('OBESITY CARE + FEMOWIN (LADY CARE)',1500,700);
insert into products (products_name,products_gpprice,products_points) values ('ORTHO CARE + ALOE POWER',1500,700);
insert into products (products_name,products_gpprice,products_points) values ('SPECIAL GRAHAK COMBO',1225,700);
insert into products (products_name,products_gpprice,products_points) values ('ETHERIC LAMP',5000,700);
insert into products (products_name,products_gpprice,products_points) values ('BRACELET, PENDENT AND RING',9000,4200);
insert into products (products_name,products_gpprice,products_points) values ('MULTI TABLE',2450,700);
insert into products (products_name,products_gpprice,products_points) values ('GRAHAK COMBO',3500,700);
*/
/*New Product Details on 2nd Jan 2017*/
insert into products (products_name,products_mrp,products_gpprice,products_points) values ('AQUAZON WATER PURIFIER',3900,3750,2000);
insert into products (products_name,products_mrp,products_gpprice,products_points) values ('AIR PURIFIER',3999,2750,1000);
insert into products (products_name,products_mrp,products_gpprice,products_points) values ('EMI RADIATION GUARD',3500,2450,1000);
insert into products (products_name,products_mrp,products_gpprice,products_points) values ('PAIN MANAGEMENT',7800,6500,2500);
insert into products (products_name,products_mrp,products_gpprice,products_points) values ('GAS SAFETY DEVICE ',2495,2200,1004);
insert into products (products_name,products_mrp,products_gpprice,products_points) values ('ETHERIC LAMP',5000,2200,1000);
insert into products (products_name,products_mrp,products_gpprice,products_points) values ('KISSAN SANJEVEENI ',1999,1600,900);
insert into products (products_name,products_mrp,products_gpprice,products_points) values ('AROWGYAPLUS DIABETIC CARE',999,950,600);
insert into products (products_name,products_mrp,products_gpprice,products_points) values ('AROWGYAPLUS OBESITY CARE',1499,1100,700);
insert into products (products_name,products_mrp,products_gpprice,products_points) values ('AROWGYAPLUS ALOE POWER JUICE',1299,1250,725);
insert into products (products_name,products_mrp,products_gpprice,products_points) values ('AROWGYAPLUS FEMOWIN LADYCARE',799,760,500);
insert into products (products_name,products_mrp,products_gpprice,products_points) values ('AROWGYAPLUS KALP AMRUTHA',799,799,500);
insert into products (products_name,products_mrp,products_gpprice,products_points) values ('AROWGYAPLUS NONI PREMIUM 800ML',1499,1050,700);
insert into products (products_name,products_mrp,products_gpprice,products_points) values ('AROWGYAPLUS ORTHO CARE',999,750,500);
insert into products (products_name,products_mrp,products_gpprice,products_points) values ('GT SOLUTION',198,190,100);

/*Individual Customers Products List*/
DROP TABLE custproducts;
CREATE TABLE custproducts
(
  custproducts_productid integer,  
  custproducts_custname character varying(50),
  custproducts_sta character (1) default 'A',
  custproducts_quantity numeric(6,0) default '0'
);

insert into custproducts (custproducts_productid,custproducts_custname) select products_slno,customer_details_name  from products,customer_details


/*Items Master Table*/
drop table items_master;
CREATE TABLE items_master
(
    items_master_id serial,
    items_master_name character varying(100),
    items_master_retailmrp numeric(15,2),
    items_master_warehousemrp numeric(15,2),
    items_master_sta character(1) default 'A',
    items_master_created_by character varying(30),
    items_master_created_on date,
    items_master_created_time character varying(10),
    items_master_updated_by character varying(50),
    items_master_updated_on date,
    items_master_updated_time character varying(10)
);

/*Retailers Master Table*/
drop table retailers_master;
CREATE TABLE retailers_master
(
    retailers_master_id serial,
    retailers_master_name character varying(30),
    retailers_master_password character varying(20),
    retailers_master_description character varying(100),
    retailers_master_sta character(1) default 'A',
    retailers_master_created_by character varying(30),
    retailers_master_created_on date,
    retailers_master_created_time character varying(10),
    retailers_master_updated_by character varying(30),
    retailers_master_updated_on date,
    retailers_master_updated_time character varying(10)
);

/*Shop & Retailers Purchase Order*/
drop TABLE shop_purchase_orders;
CREATE TABLE shop_purchase_orders
(
    shop_purchase_orders_id serial,
    shop_purchase_orders_shoppyid integer,
    shop_purchase_orders_retailerid integer,
    shop_purchase_orders_shop_totalprice numeric(15,2),
    shop_purchase_orders_retailer_totalprice numeric(15,2),
    shop_purchase_orders_expecteddate date,
    shop_purchase_orders_remarks character varying(150),
    shop_purchase_orders_sta character(1) default 'E', /*E - Entered */
    shop_purchase_orders_amt_sta character(1),   /* T - Transfered, P- Pending*/
    shop_purchase_orders_shop_created_by character varying(30),
    shop_purchase_orders_shop_created_on date,
    shop_purchase_orders_shop_created_time character varying(10),
    shop_purchase_orders_retailer_created_by character varying(30),
    shop_purchase_orders_retailer_created_on date,
    shop_purchase_orders_retailer_created_time character varying(10),
    shop_purchase_orders_updated_by character varying(30),
    shop_purchase_orders_updated_on date,
    shop_purchase_orders_updated_time character varying(10)
);

CREATE TABLE shop_purchase_items
(
    shop_purchase_orders_id integer,
    shop_purchase_orders_itemsid integer,
    shop_purchase_orders_itemsquantity integer,
    shop_purchase_orders_shop_itemsprice numeric(15,2),
    shop_purchase_orders_retailer_itemsprice numeric(15,2),
    shop_purchase_orders_quantity_received integer
);


CREATE TABLE warehouse_delivery
(
    warehouse_delivery_id integer,
    warehouse_delivery_shop_order_id integer,
    warehouse_delivery_shoppy_id integer,
    warehouse_delivery_retailer_id integer,
    warehouse_delivery_sta character(1) default 'P',
    warehouse_delivery_created_by character varying(30),
    warehouse_delivery_created_on date,
    warehouse_delivery_created_time character varying(10),
    warehouse_delivery_updated_by character varying(30),
    warehouse_delivery_updated_on date,
    warehouse_delivery_updated_time character varying(10)
);