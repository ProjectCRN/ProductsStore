delete from  ns_admin.TBL_ATRIBUTETYPE;
commit;
INSERT INTO ns_admin.TBL_ATRIBUTETYPE (
  ATRIBUTETYPEID,
	ATRIBUTETYPENAME) 
	values
	(
	SQ_MAIN.nextval,
	'String');
  
  INSERT INTO ns_admin.TBL_ATRIBUTETYPE (
  ATRIBUTETYPEID,
	ATRIBUTETYPENAME) 
	values
	(
	SQ_MAIN.nextval,
	'Integer');
  
  INSERT INTO ns_admin.TBL_ATRIBUTETYPE (
  ATRIBUTETYPEID,
	ATRIBUTETYPENAME) 
	values
	(
	SQ_MAIN.nextval,
	'Decimal');
  
  INSERT INTO ns_admin.TBL_ATRIBUTETYPE (
  ATRIBUTETYPEID,
	ATRIBUTETYPENAME) 
	values
	(
	SQ_MAIN.nextval,
	'Date');
  
  INSERT INTO ns_admin.TBL_ATRIBUTETYPE (
  ATRIBUTETYPEID,
	ATRIBUTETYPENAME) 
	values
	(
	SQ_MAIN.nextval,
	'Boolean');
  
    INSERT INTO ns_admin.TBL_ATRIBUTETYPE (
  ATRIBUTETYPEID,
	ATRIBUTETYPENAME) 
	values
	(
	SQ_MAIN.nextval,
	'Link');
  
  commit;

exit;
/