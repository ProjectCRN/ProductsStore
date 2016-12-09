CREATE OR REPLACE PROCEDURE ns_admin.sp_entity_listValues( 

inEntityIDCSV IN NVARCHAR2, 
inAttributeIDCSV IN NVARCHAR2, 

outEntity OUT SYS_REFCURSOR 
) 

IS 
inAttribute NVARCHAR2(4000) := inAttributeIDCSV; 
inAttributeCopy NVARCHAR2(4000) := inAttribute; 
inEntity NVARCHAR2(4000) := inEntityIDCSV; 
positionOfComma INTEGER :=0; 
SQLString VARCHAR2(5000):='SELECT E.ENTITYID ,E.ENTITYNAME ,E.ISACTIVE ,E.ENTITYTYPEID, ET.ENTITYTYPENAME ,E.USERID, T.* 
FROM((select V.ENTITYID, '; 
elemAtribute NVARCHAR2(50) := ''; 

MyErrorCode INTEGER := 0; 
SystemErrorCode INTEGER := 0; 
LogMessage NVARCHAR2(2000) := 'Undefined error.'; 
-- EXCEPTIONS -- 
PROC_EXEC_FAILED EXCEPTION; 

BEGIN 

inAttribute:= NVL(inAttribute,''); 

IF (LENGTH(inAttribute) IS NULL) THEN 
SQLString:= 'SELECT E.ENTITYID ,E.ENTITYNAME ,E.ISACTIVE ,E.ENTITYTYPEID,T.ENTITYTYPENAME ,E.USERID 
FROM TBL_ENTITY E 
INNER JOIN TBL_ENTITYTYPE T ON E.ENTITYTYPEID=T.ENTITYTYPEID 
WHERE (E.ENTITYID IN (' || inEntity || '))
ORDER BY E.ENTITYNAME'; 
OPEN outEntity FOR SQLString; 

END IF; 

IF (LENGTH(inAttribute)IS NOT NULL) THEN 

inAttribute := inAttribute || ','; 
positionOfComma:= INSTR(inAttribute,','); 
WHILE positionOfComma!=0 LOOP 
elemAtribute:=LPAD(inAttribute,positionOfComma-1); 
inAttribute :=SUBSTR(inAttribute,positionOfComma+1); 

SQLString:= SQLString || ' max(CASE WHEN V.ATRIBUTEID=' || elemAtribute ||' THEN V.ATRIBUTEID ELSE NULL END) AS "ATRIBUTEID' || elemAtribute || '", '; 
SQLString:= SQLString || ' max(CASE WHEN A.ATRIBUTEID=' || elemAtribute ||' THEN A.ATRIBUTENAME ELSE NULL END) AS "ATRIBUTENAME' || elemAtribute || '", '; 
SQLString:= SQLString || ' max(CASE WHEN V.ATRIBUTEID=' || elemAtribute ||' THEN V.VALUEID ELSE NULL END) AS "VALUEID' || elemAtribute || '", '; 
SQLString:= SQLString || ' max(CASE WHEN V.ATRIBUTEID=' || elemAtribute ||' THEN V.VALUE ELSE NULL END) AS "VALUE' || elemAtribute || '",'; 

positionOfComma := INSTR(inAttribute,','); 
END LOOP; 
SQLString := LPAD(SQLString,LENGTH(SQLString)-1); 

SQLString:= SQLString || ' FROM TBL_VALUE V 
INNER JOIN TBL_ATRIBUTE A ON A.ATRIBUTEID=V.ATRIBUTEID 
WHERE ((V.ATRIBUTEID IN (' || inAttributeCopy || ')) AND (V.ENTITYID IN (' || inEntity || '))) 
GROUP BY (V.ENTITYID) 
) T 
INNER JOIN TBL_ENTITY E ON E.ENTITYID=T.ENTITYID) 
INNER JOIN TBL_ENTITYTYPE ET ON ET.ENTITYTYPEID = E.ENTITYTYPEID
ORDER BY E.ENTITYNAME'; 

OPEN outEntity FOR SQLString; 

END IF; 


COMMIT; 

-- FAILED --
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

END sp_entity_listValues;