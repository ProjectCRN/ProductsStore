CREATE OR REPLACE TYPE SearchTableObj AS OBJECT (
    Pos INT, 
    AttributeId NVARCHAR2(50), 
    AttributeValue NVARCHAR2(128), 
    OperatorValue NVARCHAR2(6) 
  ) ;

  
CREATE OR REPLACE TYPE SearchTable AS TABLE OF SearchTableObj;

exit;
/