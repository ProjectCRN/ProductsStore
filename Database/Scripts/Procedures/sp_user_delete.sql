create or replace PROCEDURE          sp_user_delete(
	-- User id
	inUserID IN TBL_USER.USERID%TYPE := ''
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
  
  DELETE FROM TBL_USER WHERE (UserID = inUserID);
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
  
END sp_user_delete;