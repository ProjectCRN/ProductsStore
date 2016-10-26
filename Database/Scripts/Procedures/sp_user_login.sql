CREATE OR REPLACE PROCEDURE ns_admin.sp_user_login(

	-- User Login
	inLogin IN TBL_USER.Login%TYPE := '',
	-- User ID
	outUserID OUT TBL_USER.UserID%TYPE,
  outPassword OUT TBL_USER.Password%TYPE
	)
IS
  --MUST HAVE--
	MyErrorCode INTEGER := 0;
	SystemErrorCode INTEGER := 0;
	LogMessage NVARCHAR2(2000) := 'Undefined error.';
	-- EXCEPTIONS --
	PROC_EXEC_FAILED EXCEPTION;
BEGIN
  IF 
		(inLogin IS NULL)
	THEN
		MyErrorCode := -20001;
		RAISE PROC_EXEC_FAILED;
	END IF;
  

	SELECT UserID, Password
	INTO outUserID, outPassword
	FROM TBL_USER
	WHERE (Login = inLogin);

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
END sp_user_login;