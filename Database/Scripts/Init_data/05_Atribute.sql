delete from  ns_admin.TBL_ATRIBUTE;
commit;
INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Order Number',
	1,
	1,
	7,
	1,
	10);
  
  INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Contact Name',
	1,
	1,
	7,
	1,
	20);
  
    INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Contact Phone',
	1,
	1,
	7,
	1,
	20);
  
    INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Contact Adress',
	1,
	1,
	7,
	1,
	30);
  
    INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Total',
	3,
	1,
	7,
	1,
	40);
  
    INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Created Date',
	4,
	1,
	7,
	1,
	50);
  
      INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Paid Date',
	4,
	1,
	7,
	1,
	60);
  
  --Product In Order--
  
  INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Price',
	3,
	1,
	8,
	1,
	10);
  INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'ProductID',
	2,
	1,
	8,
	1,
	20);  
  INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'OrderID',
	2,
	1,
	8,
	1,
	30);
    INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Quantity',
	2,
	1,
	8,
	1,
	40);
  --Telephone--
  
INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Price',
	3,
	1,
	9,
	1,
	2);
  INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Summary',
	1,
	1,
	9,
	1,
	3);
  
INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Operating System',
	1,
	1,
	9,
	1,
	5);
  
  INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Processor speed, GHz',
	3,
	1,
	9,
	1,
	8);
INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Capacity, GB',
	2,
	1,
	9,
	1,
	10);
  
  INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Display, inch',
	3,
	1,
	9,
	1,
	20);
  
  INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Height, mm',
	3,
	1,
	9,
	1,
	30);
    INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Width, mm',
	3,
	1,
	9,
	1,
	40);
      INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Depth, mm',
	3,
	1,
	9,
	1,
	50);
  
        INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Weight, grams',
	3,
	1,
	9,
	1,
	60);
          INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Camera, MP',
	3,
	1,
	9,
	1,
	70);
  INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Battery, hours',
	3,
	1,
	9,
	1,
	80);
  
  INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'SIM Card',
	1,
	1,
	9,
	1,
	90);
    
    INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'ImageURL',
	1,
	1,
	9,
	1,
	900);
   INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Fabricator',
	1,
	1,
	9,
	1,
	100);
  --Tablet--
  
INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Price',
	3,
	1,
	10,
	1,
	2);
  INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Summary',
	1,
	1,
	10,
	1,
	3);

INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Operating System',
	1,
	1,
	10,
	1,
	5);
  
  INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Processor speed, GHz',
	3,
	1,
	10,
	1,
	8);
INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Capacity, GB',
	2,
	1,
	10,
	1,
	10);
  
  INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Display, inch',
	3,
	1,
	10,
	1,
	20);
  
  INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Height, mm',
	3,
	1,
	10,
	1,
	30);
    INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Width, mm',
	3,
	1,
	10,
	1,
	40);
      INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Depth, mm',
	3,
	1,
	10,
	1,
	50);
  
        INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Weight, grams',
	3,
	1,
	10,
	1,
	60);
          INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Camera, MP',
	3,
	1,
	10,
	1,
	70);
  INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Battery, hours',
	3,
	1,
	10,
	1,
	80);
  
  INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'SIM Card',
	1,
	1,
	10,
	1,
	90);
  
   INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'ImageURL',
	1,
	1,
	10,
	1,
	900);
   INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER) 
	values
	(
	SQ_MAIN.nextval,
	'Fabricator',
	1,
	1,
	9,
	1,
	100);
  
    commit;
