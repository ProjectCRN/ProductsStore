CREATE OR REPLACE PROCEDURE ns_admin.sp_user_get_list(

  outUserList OUT SYS_REFCURSOR,
  
	inUserRoleID IN TBL_USER.ROLEID%TYPE :=NULL
	)
IS
  --MUST HAVE--
	MyErrorCode INTEGER := 0;
	SystemErrorCode INTEGER := 0;
	LogMessage NVARCHAR2(2000) := 'Undefined error.';
	-- EXCEPTIONS --
	PROC_EXEC_FAILED EXCEPTION;
BEGIN
  
  OPEN outUserList FOR
    SELECT 
            U.USERID ,
            U.LOGIN ,
            U.USERNAME ,
            U.CONTACTPHONE ,
            U.CONTACTADRESS ,
            U.ROLEID,
            R.ROLENAME
    FROM TBL_USER U 
    INNER JOIN TBL_ROLE R
    ON U.ROLEID=R.ROLEID
    WHERE ((inUserRoleID is NULL) OR ((inUserRoleID is not NULL)AND(inUserRoleID =R.ROLEID)));


	COMMIT;

---- FAILED
	EXCEPTION 
		WHEN PROC_EXEC_FAILED THEN
		BEGIN
			ROLLBACK;
      LogMessage := fn_error_message_get(MyErrorCode);
			RAISE_APPLICATION_ERROR(MyErrorCode,LogMessage);
		END;
		WHEN OTHERS THEN
		BEGIN
			SystemErrorCode := SQLCODE;
			LogMessage := SQLERRM;
			ROLLBACK;
			RAISE;
		END;  
END sp_user_get_list;