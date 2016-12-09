CREATE OR REPLACE PROCEDURE ns_admin.sp_entity_list(

  inEntityTypeId IN INTEGER,
--  inPriceId IN INTEGER,
  inAttributeCSV IN NVARCHAR2,
  inValueCSV IN NVARCHAR2,
  inOperatorCSV IN NVARCHAR2,
  inPageNumber IN INTEGER,
  inPageSize IN INTEGER,
  inRole IN NVARCHAR2,

  outEntity OUT SYS_REFCURSOR
	)
  
IS
  inAttribute NVARCHAR2(4000) := inAttributeCSV;
  inValue NVARCHAR2(4000) := inValueCSV;
  inOperator NVARCHAR2(4000) := inOperatorCSV;
  pageNumber INTEGER :=inPageNumber;
  pageSize INTEGER :=inPageSize;
  counter INTEGER :=0;
  intRole INTEGER :=1;
  positionOfComma INTEGER :=0;  
  
  elemAtribute NVARCHAR2(50) := '';
  elemValue NVARCHAR2(128) := '';
  elemOperator NVARCHAR2(6) := '';
  
  MyErrorCode INTEGER := 0;
	SystemErrorCode INTEGER := 0;
	LogMessage NVARCHAR2(2000) := 'Undefined error.';
	-- EXCEPTIONS --
	PROC_EXEC_FAILED EXCEPTION;

BEGIN 
  DELETE FROM SearchTable;
  inAttribute:= NVL(inAttribute,'');
  
  IF (inRole='A') THEN intRole:=0;
  ELSE intRole:=1;
  END IF;

IF (LENGTH(inAttribute) IS NULL) THEN 
      OPEN outEntity FOR
      SELECT * FROM
      (
          SELECT a.*, rownum rnum
          FROM
          (
              SELECT E.ENTITYID
              FROM TBL_ENTITY E
              WHERE ((E.ENTITYTYPEID=inEntityTypeId) AND (E.ISACTIVE=1 OR E.ISACTIVE=intRole)) 
            ) a
          WHERE rownum < ((pageNumber * pageSize) + 1 )
      )
      WHERE rnum >= (((pageNumber-1) * pageSize) + 1);
      
END IF;

  IF (LENGTH(inAttribute)IS NOT NULL) THEN

    inAttribute := inAttribute || ',';
    inValue := NVL(inValue,'') || ',';
    inOperator := NVL(inOperator,'') || ',';
    positionOfComma:= INSTR(inAttribute,',');
   WHILE positionOfComma!=0 LOOP
      counter:=counter+1;
      
      elemAtribute:=LPAD(inAttribute,positionOfComma-1);
      inAttribute :=SUBSTR(inAttribute,positionOfComma+1);
      
      positionOfComma:= INSTR(inValue,',');
      elemValue:=LPAD(inValue,positionOfComma-1);
      inValue :=SUBSTR(inValue,positionOfComma+1);
      
      positionOfComma:= INSTR(inOperator,',');
      elemOperator:=LPAD(inOperator,positionOfComma-1);
      inOperator :=SUBSTR(inOperator,positionOfComma+1);
      
      INSERT INTO SearchTable (Pos,ATTRIBUTEID,ATTRIBUTEVALUE,OPERATORVALUE) 
      VALUES (counter,elemAtribute,elemValue,elemOperator);
    
      positionOfComma := INSTR(inAttribute,',');
   END LOOP;



  IF (counter > 0) THEN   
    OPEN outEntity FOR
    SELECT * FROM
      (
          SELECT a.*, rownum rnum
          FROM
          (
             SELECT CX.ENTITYID
             FROM 
             ( 
             SELECT CA.EntityId 
             FROM SearchTable T  
             INNER JOIN TBL_VALUE CA  ON T.ATTRIBUTEID = CA.ATRIBUTEID 
             WHERE 1 = CASE T.OperatorValue 
             WHEN N'=' THEN CASE WHEN CAST(CA.Value AS NVARCHAR2(128)) = CAST(T.AttributeValue AS NVARCHAR2(128)) THEN 1 ELSE 0 END 
             WHEN N'<=' THEN CASE WHEN TO_NUMBER(CA.Value) <= TO_NUMBER(T.AttributeValue) THEN 1 ELSE 0 END 
             WHEN N'<' THEN CASE WHEN TO_NUMBER(CA.Value ) < TO_NUMBER(T.AttributeValue ) THEN 1 ELSE 0 END 
             WHEN N'>' THEN CASE WHEN TO_NUMBER(CA.Value) > TO_NUMBER(T.AttributeValue) THEN 1 ELSE 0 END 
             WHEN N'>=' THEN CASE WHEN TO_NUMBER(CA.Value) >= TO_NUMBER(T.AttributeValue) THEN 1 ELSE 0 END 
             WHEN N'like' THEN CASE WHEN CAST(CA.Value AS NVARCHAR2(128)) LIKE CAST(T.AttributeValue AS NVARCHAR2(128)) THEN 1 ELSE 0 END 
             WHEN N'ISNULL' THEN CASE WHEN CA.Value IS NULL THEN 1 ELSE 0 END 
             ELSE 0 END                         
             GROUP BY EntityId 
             HAVING COUNT(1) = counter
             ) X  
             INNER JOIN TBL_ENTITY CX ON CX.EntityId = X.EntityId
             WHERE ((CX.ENTITYTYPEID=inEntityTypeId) AND (CX.ISACTIVE=0 OR CX.ISACTIVE=intRole))
         ) a
        WHERE rownum < ((pageNumber * pageSize) + 1 )
    )
    WHERE rnum >= (((pageNumber-1) * pageSize) + 1);
  
  END IF;
 
END IF;     

      
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

END sp_entity_list;

