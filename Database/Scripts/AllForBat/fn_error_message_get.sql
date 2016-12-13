
CREATE OR REPLACE FUNCTION ns_admin.fn_error_message_get(
		 inErrorCode IN INTEGER := NULL
		 ) RETURN NVARCHAR2
IS
  LogMessage NVARCHAR2(2000) := 'Undefined error.';
BEGIN

    select 
        case
          when (inErrorCode = -20001) then 'INCORRECT_INPUT_PARAMS'
          else 'UNDEFINED_ERROR'
        end
    INTO LogMessage
    from dual;
    
    return LogMessage;
  
---- FAILED
  EXCEPTION 
    WHEN OTHERS THEN
        BEGIN
          RAISE;  
        END;  
END fn_error_message_get;

/
exit