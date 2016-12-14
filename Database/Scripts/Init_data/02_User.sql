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
	'5f902ca578ce5cdd711ea38ce321e3d0d4b8857c52679cc8b81657abb23eeb25',
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
	'c1c224b03cd9bc7b6a86d77f5dace40191766c485cd55dc48caf9ac873335d6f',
	'Admin',
	NULL,
	NULL,
  'A',
  NULL);
	
commit;

