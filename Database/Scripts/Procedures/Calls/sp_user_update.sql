DECLARE 
   userID TBL_USER.UserID%TYPE := 6;
BEGIN
 ns_admin.sp_user_update(userID, NULL, 'newpassword', 'newname', 'newphone', null);	
  
  dbms_output.put_line(
	   'updated ' || TO_CHAR(userID)
	   );
end;	