/*<TOAD_FILE_CHUNK>*/
CREATE OR REPLACE TRIGGER NS_ADMIN.TR_DELETE_USER
BEFORE DELETE
ON NS_ADMIN.TBL_USER
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
/******************************************************************************
   check for system user
******************************************************************************/
BEGIN

	IF 
		(:OLD.UserID < 0) 
	THEN 
		RAISE_APPLICATION_ERROR(-20003,'The table cannot be updated.');  
	END IF; 

	EXCEPTION
		WHEN OTHERS THEN
		-- Consider logging the error and then re-raise
		RAISE;
END ;

/

/*<TOAD_FILE_CHUNK>*/
EXIT;
/

