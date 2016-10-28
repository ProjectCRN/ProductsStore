CREATE OR REPLACE PROCEDURE ns_admin.sp_update_user(

	-- User id
	inUserID IN TBL_USER.USERID%TYPE := '',
  newLogin IN TBL_USER.LOGIN%TYPE,
  newPassword IN TBL_USER.PASSWORD%TYPE,
  newUserName IN TBL_USER.USERNAME%TYPE,
  newContactPhone IN TBL_USER.CONTACTPHONE%TYPE,
  newContactAdress IN TBL_USER.CONTACTADRESS%TYPE
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
		(inUserID IS NULL)
	THEN
		MyErrorCode := -20001;
		RAISE PROC_EXEC_FAILED;
  END IF;
  
  UPDATE TBL_USER SET
  Login = CASE
  WHEN newLogin IS NOT NULL THEN newLogin 
  ELSE login
  END,
  TBL_USER.Password = CASE
  WHEN newPassword IS NOT NULL THEN newPassword
  ELSE TBL_USER.password
  END,
  Username = CASE
  WHEN newUserName IS NOT NULL THEN newUserName
  ELSE username
  END,
  Contactphone = CASE
  WHEN newContactPhone IS NOT NULL THEN newContactPhone
  ELSE contactphone
  END,
  Contactadress = CASE
  WHEN newContactAdress IS NOT NULL THEN newContactAdress
  ELSE Contactadress
  END
  WHERE (UserID = inUserID);
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
END sp_update_user;