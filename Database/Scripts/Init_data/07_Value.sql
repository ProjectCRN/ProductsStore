delete from  ns_admin.TBL_VALUE;
commit;
INSERT INTO ns_admin.TBL_VALUE (
  VALUEID,
	VALUE,
	ENTITYID,
	ATRIBUTEID) 
	values
	(
	SQ_MAIN.nextval,
	'32Gb',
	39,
	14);
  
      commit;

exit;
/