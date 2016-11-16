CREATE GLOBAL TEMPORARY TABLE SearchTable
(
    Pos INT, 
    AttributeId NVARCHAR2(50), 
    AttributeValue NVARCHAR2(128), 
    OperatorValue NVARCHAR2(6) 
)
ON COMMIT PRESERVE ROWS
;