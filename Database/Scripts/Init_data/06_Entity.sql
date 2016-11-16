delete from  ns_admin.TBL_ENTITY;
commit;
INSERT INTO ns_admin.TBL_ENTITY (
  ENTITYID,
	ENTITYNAME,
	ISACTIVE,
	ENTITYTYPEID,
	USERID) 
	values
	(
	SQ_MAIN.nextval,
	'iPhone7S',
	1,
	8,
	-2);
  
      commit;

exit;
/