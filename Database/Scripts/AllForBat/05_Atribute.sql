delete from  ns_admin.TBL_ATRIBUTE;
commit;
INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Order Number',
	1,
	1,
	7,
	1,
	10,
  'No Expression');
  
  INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Contact Name',
	1,
	1,
	7,
	1,
	20,
  '^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$');
  
    INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Contact Phone',
	1,
	1,
	7,
	1,
	20,
  '^((8|\+375)[\- ]?)?(\(?\d{3}\)?[\- ]?)?[\d\- ]{7,10}$');
  
    INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Contact Adress',
	1,
	1,
	7,
	1,
	30,
  '^[a-zA-Z][a-zA-Z0-9-_ \.]{1,20}$');
  
    INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Total',
	3,
	1,
	7,
	1,
	40,
  'No Expression');
  
    INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Created Date',
	4,
	1,
	7,
	1,
	50,
  'No Expression');
  
      INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Paid Date',
	4,
	1,
	7,
	1,
	60,
  'No Expression');
  
  --Product In Order--
  
  INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Price',
	3,
	1,
	8,
	1,
	10,
  'No Expression');
  INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'ProductID',
	2,
	1,
	8,
	1,
	20,
  'No Expression');  
  INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'OrderID',
	2,
	1,
	8,
	1,
	30,
  'No Expression');
    INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Quantity',
	2,
	1,
	8,
	1,
	40,
  'No Expression');
    INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'ImageURL',
	1,
	1,
	8,
	1,
	50,
  'No Expression');
    INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Summary',
	1,
	1,
	8,
	1,
	60,
  'No Expression');
  --Telephone--
  
INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Price',
	3,
	1,
	9,
	1,
	2,
  '\d+(\.,\d{0,2})?');
  INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Summary',
	1,
	1,
	9,
	1,
	3,
  '^[a-zA-Z][a-zA-Z0-9-_\. ]{5,140}$');
  
INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Operating System',
	1,
	1,
	9,
	1,
	5,
  '^[a-zA-Z][a-zA-Z0-9-_\. ]{1,20}$');
  
  INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Processor speed, GHz',
	3,
	1,
	9,
	1,
	8,
  '[0-9]{1,}');
INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Capacity, GB',
	2,
	1,
	9,
	1,
	10,
  '[0-9]{1,}');
  
  INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Display, inch',
	3,
	1,
	9,
	1,
	20,
  '\d+(\.\d{0,1})?');
  
  INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Height, mm',
	3,
	1,
	9,
	1,
	30,
  '\d+(\.\d{0,2})?');
    INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Width, mm',
	3,
	1,
	9,
	1,
	40,
  '\d+(\.\d{0,2})?');
      INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Depth, mm',
	3,
	1,
	9,
	1,
	50,
  '\d+(\.\d{0,2})?');
  
        INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Weight, grams',
	3,
	1,
	9,
	1,
	60,
  '[0-9]{1,}');
          INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Camera, MP',
	3,
	1,
	9,
	1,
	70,
  '[0-9]{1,}');
  
  INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Battery, hours',
	3,
	1,
	9,
	1,
	80,
  '[0-9]{1,}');
  
  INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'SIM Card',
	1,
	1,
	9,
	1,
	90,
  '^[a-zA-Z][a-zA-Z0-9-_\. ]{1,20}$');
    
    INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'ImageURL',
	1,
	1,
	9,
	1,
	900,
  '^(https?://)?(?:[a-z0-9\-]+\.)+[a-z]{2,6}(?:/[^/#?]+)+\.(?:jpg|gif|png)$');
  
   INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Fabricator',
	1,
	1,
	9,
	1,
	100,
  '^[a-zA-Z][a-zA-Z0-9-_\. ]{1,20}$');
  --Tablet--
  
INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Price',
	3,
	1,
	10,
	1,
	2,
  '\d+(\.,\d{0,2})?');
  INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Summary',
	1,
	1,
	10,
	1,
	3,
  '^[a-zA-Z][a-zA-Z0-9-_\. ]{5,140}$');

INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Operating System',
	1,
	1,
	10,
	1,
	5,
  '^[a-zA-Z][a-zA-Z0-9-_\. ]{1,20}$');
  
  INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Processor speed, GHz',
	3,
	1,
	10,
	1,
	8,
  '[0-9]{1,}');
INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Capacity, GB',
	2,
	1,
	10,
	1,
	10,
  '[0-9]{1,}');
  
  INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Display, inch',
	3,
	1,
	10,
	1,
	20,
  '\d+(\.\d{0,1})?');
  
  INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Height, mm',
	3,
	1,
	10,
	1,
	30,
  '\d+(\.\d{0,2})?');
    INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Width, mm',
	3,
	1,
	10,
	1,
	40,
  '\d+(\.\d{0,2})?');
      INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Depth, mm',
	3,
	1,
	10,
	1,
	50,
  '\d+(\.\d{0,2})?');
  
        INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Weight, grams',
	3,
	1,
	10,
	1,
	60,
  '[0-9]{1,}');
          INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Camera, MP',
	3,
	1,
	10,
	1,
	70,
  '[0-9]{1,}');
  INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Battery, hours',
	3,
	1,
	10,
	1,
	80,
  '[0-9]{1,}');
  
  INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'SIM Card',
	1,
	1,
	10,
	1,
	90,
  '^[a-zA-Z][a-zA-Z0-9-_\. ]{1,20}$');
  
   INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'ImageURL',
	1,
	1,
	10,
	1,
	900,
  '^(https?://)?(?:[a-z0-9\-]+\.)+[a-z]{2,6}(?:/[^/#?]+)+\.(?:jpg|gif|png)$');
   INSERT INTO ns_admin.TBL_ATRIBUTE (
  ATRIBUTEID,
	ATRIBUTENAME,
	ATRIBUTETYPEID,
	ISACTIVE,
	ENTITYTYPEID,
	ISREQUIRED,
	SORTORDER,
  REGULAREXPRESSION) 
	values
	(
	SQ_MAIN.nextval,
	'Fabricator',
	1,
	1,
	10,
	1,
	100,
  '^[a-zA-Z][a-zA-Z0-9-_\. ]{1,20}$');
  
    commit;

exit;
/
