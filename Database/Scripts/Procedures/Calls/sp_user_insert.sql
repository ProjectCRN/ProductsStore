DECLARE 
   outUserID TBL_USER.UserID%TYPE;
BEGIN
 ns_admin.sp_user_insert(NULL,'qwer','qw','qw','qw','U',outUserID);	
  
  dbms_output.put_line(
	   TO_CHAR(outUserID)
	   );
end;	