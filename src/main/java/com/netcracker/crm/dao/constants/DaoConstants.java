package com.netcracker.crm.dao.constants;


public class DaoConstants {
    public static final String ERROR_DAO = "Error was thrown in DAO ";

    public static final String COLUMN_USER_ID = "USERID";
    public static final String COLUMN_USER_LOGIN = "LOGIN";
    public static final String COLUMN_USER_PASSWORD = "PASSWORD";
    public static final String COLUMN_USER_USERNAME = "USERNAME";
    public static final String COLUMN_USER_PHONE = "CONTACTPHONE";
    public static final String COLUMN_USER_ADDRESS = "CONTACTADRESS";
    public static final String COLUMN_USER_ROLEID = "ROLEID";
    public static final String COLUMN_USER_EMAIL = "EMAIL";

    public static final String COLUMN_ENTITY_ID = "ENTITYID";
    public static final String COLUMN_ENTITY_NAME = "ENTITYNAME";
    public static final String COLUMN_ENTITY_ISACTIVE = "ISACTIVE";
    public static final String COLUMN_ENTITY_TYPE_ID = "ENTITYTYPEID";
    public static final String COLUMN_ENTITY_USER_ID = "USERID";

    public static final String COLUMN_ENTITY_TYPE_NAME = "ENTITYTYPENAME";

    public static final String COLUMN_VALUE_ID = "VALUEID";
    public static final String COLUMN_VALUE = "VALUE";
    public static final String COLUMN_VALUE_ENTITY_ID = "ENTITYID";
    public static final String COLUMN_VALUE_ATRIBUTE_ID = "ATRIBUTEID";

    public static final String COLUMN_ATRIBUTE_ID = "ATRIBUTEID";
    public static final String COLUMN_ATRIBUTE_NAME = "ATRIBUTENAME";
    public static final String COLUMN_ATRIBUTE_TYPEID = "ATRIBUTETYPEID";
    public static final String COLUMN_ATRIBUTE_TYPENAME = "ATRIBUTETYPENAME";
    public static final String COLUMN_ATRIBUTE_ISACTIVE = "ISACTIVE";
    public static final String COLUMN_ATRIBUTE_ENTITY_TYPE_ID = "ENTITYTYPEID";
    public static final String COLUMN_ATRIBUTE_ISREQUIRED = "ISREQUIRED";
    public static final String COLUMN_ATRIBUTE_REGULAREXPRESSION = "REGULAREXPRESSION";

    public static final String PARAM_IN_ENTITY_ENTITYTYPEID = "inEntityTypeId";
    public static final String PARAM_IN_ENTITY_ENTITYID = "inEntityIDCSV";
    public static final String PARAM_IN_ENTITY_ATRIBUTES = "inAttributeCSV";
    public static final String PARAM_IN_ENTITY_ATRIBUTESID = "inAttributeIDCSV";
    public static final String PARAM_IN_ENTITY_VALUES = "inValueCSV";
    public static final String PARAM_IN_ENTITY_OPERATORS = "inOperatorCSV";

    public static final String PARAM_IN_PAGE_NUMBER = "inPageNumber";
    public static final String PARAM_IN_PAGE_SIZE = "inPageSize";
    public static final String PARAM_IN_ROLE = "inRole";
    public static final String PARAM_IN_ORDERSIDE = "inSide";

    public static final String PARAM_OUT_ENTITY_LIST = "outEntity";
    public static final String PARAM_OUT_COUNT = "outCount";


    public static final String PROCEDURE_ENTITY_GET_LIST = "sp_entity_list";
    public static final String PROCEDURE_ENTITY_GET_LIST_NO_PAGINATION = "sp_entity_NoPaging";
    public static final String PROCEDURE_ENTITY_GET_LIST_VALUES = "sp_entity_listValues";
    public static final String PROCEDURE_ROWS_COUNTER = "sp_count_rows";


    public static final String TABLE_ENTITYTYPE = "TBL_EntityType";
    public static final String TABLE_ENTITY = "TBL_Entity";
    public static final String TABLE_VALUE = "TBL_Value";
    public static final String TABLE_ATRIBUTE = "TBL_Atribute";

    private DaoConstants() {
    }
}
