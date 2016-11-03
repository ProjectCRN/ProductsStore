delete from  ns_admin.TBL_ENTITYTYPE;
commit;
INSERT INTO ns_admin.TBL_ENTITYTYPE (
  ENTITYTYPEID,
	ENTITYTYPENAME,
  ISACTIVE) 
	values
	(
	SQ_MAIN.nextval,
	'Order',
  1);
  
  INSERT INTO ns_admin.TBL_ENTITYTYPE (
  ENTITYTYPEID,
	ENTITYTYPENAME,
  ISACTIVE) 
	values
	(
	SQ_MAIN.nextval,
	'Product',
  1);
  
  INSERT INTO ns_admin.TBL_ENTITYTYPE (
  ENTITYTYPEID,
	ENTITYTYPENAME,
  ISACTIVE) 
	values
	(
	SQ_MAIN.nextval,
	'Telephone',
  1);
  
  INSERT INTO ns_admin.TBL_ENTITYTYPE (
  ENTITYTYPEID,
	ENTITYTYPENAME,
  ISACTIVE) 
	values
	(
	SQ_MAIN.nextval,
	'Tablet',
  1);
  
  commit;

exit;
/