delete from  ns_admin.TBL_USER;
commit;
INSERT INTO ns_admin.TBL_USER (
    UserID,
	Login,
	Password,
	UserName,
	ContactPhone,
	ContactAdress,
  RoleID,
  EMAIL) 
	values
	(
	-1,
	'Ananymous',
	'Ananymous',
	'Ananymous',
	NULL,
	NULL,
  'U',
  NULL);

INSERT INTO ns_admin.TBL_USER (
    UserID,
	Login,
	Password,
	UserName,
	ContactPhone,
	ContactAdress,
  RoleID,  
  EMAIL) 
	values
	(
	-2,
	'Admin',
	'Admin',
	'Admin',
	NULL,
	NULL,
  'A',
  NULL);
	
commit;

exit;
/

