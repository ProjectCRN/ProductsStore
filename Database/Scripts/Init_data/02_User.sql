delete from  ns_admin.TBL_USER;
commit;
INSERT INTO ns_admin.TBL_USER (
    UserID,
	Login,
	Password,
	UserName,
	RoleID,
	ContactPhone,
	ContactAdress) 
	values
	(
	-1,
	'Ananymous',
	'Ananymous',
	'Ananymous',
	'U',
	NULL,
	NULL);

INSERT INTO ns_admin.TBL_USER (
    UserID,
	Login,
	Password,
	UserName,
	RoleID,
	ContactPhone,
	ContactAdress) 
	values
	(
	-2,
	'Admin',
	'Admin',
	'Admin',
	'A',
	NULL,
	NULL);
	
commit;

exit;
/