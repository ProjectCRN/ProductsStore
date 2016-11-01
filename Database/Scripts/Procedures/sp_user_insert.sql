CREATE OR REPLACE PROCEDURE ns_admin.sp_user_insert(

 outUserID OUT TBL_USER.UserID%TYPE,

	inUserLogin IN TBL_USER.LOGIN%TYPE := NULL,
  inUserPassword IN TBL_USER.PASSWORD%TYPE :=NULL,
  inUserName IN TBL_USER.USERNAME%TYPE := NULL,
  inUserPhone IN TBL_USER.CONTACTPHONE%TYPE := NULL,
  inUserAdress IN TBL_USER.CONTACTADRESS%TYPE := NULL,
  inUserRoleID IN TBL_USER.ROLEID%TYPE := NULL
	)
IS
  --MUST HAVE--
  
	MyErrorCode INTEGER := 0;
	SystemErrorCode INTEGER := 0;
	LogMessage NVARCHAR2(2000) := 'Undefined error.';
	-- EXCEPTIONS --
	PROC_EXEC_FAILED EXCEPTION;
BEGIN

  SELECT SQ_MAIN.NEXTVAL
  INTO   outUserID
  FROM   dual;
  
  INSERT INTO TBL_USER (
  USERID,LOGIN,PASSWORD,USERNAME,CONTACTPHONE,CONTACTADRESS,ROLEID
  ) 
  VALUES (
  outUserID,inUserLogin,inUserPassword,inUserName,inUserPhone,inUserAdress,inUserRoleID
  );


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
END sp_user_insert;