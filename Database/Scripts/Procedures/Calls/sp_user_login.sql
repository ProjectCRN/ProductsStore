DECLARE 
   outUserID TBL_USER.UserID%TYPE;
  outPassword TBL_USER.Password%TYPE;
BEGIN
 ns_admin.sp_user_login('Admin',outUserID,outPassword);	
  
  dbms_output.put_line(
	   TO_CHAR(outUserID) || ' ' || TO_CHAR(outPassword)
	   );
end;	