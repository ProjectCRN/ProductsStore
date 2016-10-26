DECLARE
  c_dbuser SYS_REFCURSOR;
  temp_dbuser TBL_USER%ROWTYPE;
BEGIN

  --records are assign to cursor 'c_dbuser'
  sp_get_user(-1,c_dbuser);

  LOOP

        --fetch cursor 'c_dbuser' into dbuser table type 'temp_dbuser'
	FETCH c_dbuser INTO temp_dbuser;

        --exit if no more records
        EXIT WHEN c_dbuser%NOTFOUND;

        --print the matched username
        dbms_output.put_line(temp_dbuser.USERNAME);

  END LOOP;

  CLOSE c_dbuser;

END;
/
