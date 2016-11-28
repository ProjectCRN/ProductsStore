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
	'iPhone6S',
	1,
	8,
	-2);
  INSERT INTO ns_admin.TBL_ENTITY (
  ENTITYID,
	ENTITYNAME,
	ISACTIVE,
	ENTITYTYPEID,
	USERID) 
	values
	(
	SQ_MAIN.nextval,
	'iPhone5S',
	1,
	8,
	-2);
  
  INSERT INTO ns_admin.TBL_ENTITY (
  ENTITYID,
	ENTITYNAME,
	ISACTIVE,
	ENTITYTYPEID,
	USERID) 
	values
	(
	SQ_MAIN.nextval,
	'Galaxy S7 Edge',
	1,
	8,
	-2);
    INSERT INTO ns_admin.TBL_ENTITY (
  ENTITYID,
	ENTITYNAME,
	ISACTIVE,
	ENTITYTYPEID,
	USERID) 
	values
	(
	SQ_MAIN.nextval,
	'iPad Air 2',
	1,
	9,
	-2);
  
      INSERT INTO ns_admin.TBL_ENTITY (
  ENTITYID,
	ENTITYNAME,
	ISACTIVE,
	ENTITYTYPEID,
	USERID) 
	values
	(
	SQ_MAIN.nextval,
	'iPad mini 4',
	1,
	9,
	-2);
  
      commit;

exit;
/