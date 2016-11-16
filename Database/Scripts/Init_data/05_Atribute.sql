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
	'Capacity',
	1,
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
	'Display',
	1,
	1,
	8,
	1,
	20);
  
    commit;

exit;
/