package com.netcracker.crm.dao.constants;

/**
 * Created by egor on 10.11.2016.
 */
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

    public static final String COLUMN_ENTITY_ID="ENTITYID";
    public static final String COLUMN_ENTITY_NAME="ENTITYNAME";
    public static final String COLUMN_ENTITY_ISACTIVE="ISACTIVE";
    public static final String COLUMN_ENTITY_TYPE_ID="ENTITYTYPEID";
    public static final String COLUMN_ENTITY_USER_ID="USERID";

    public static final String COLUMN_ENTITY_TYPE_NAME="ENTITYTYPENAME";

    public static final String COLUMN_VALUE_ID="VALUEID";
    public static final String COLUMN_VALUE="VALUE";
    public static final String COLUMN_VALUE_ENTITY_ID="ENTITYID";
    public static final String COLUMN_VALUE_ATRIBUTE_ID="ATRIBUTEID";

    public static final String COLUMN_ATRIBUTE_ID="ATRIBUTEID";
    public static final String COLUMN_ATRIBUTE_NAME="ATRIBUTENAME";
    public static final String COLUMN_ATRIBUTE_TYPEID="ATRIBUTETYPEID";
    public static final String COLUMN_ATRIBUTE_TYPENAME="ATRIBUTETYPENAME";
    public static final String COLUMN_ATRIBUTE_ISACTIVE="ISACTIVE";
    public static final String COLUMN_ATRIBUTE_ENTITY_TYPE_ID="ENTITYTYPEID";
    public static final String COLUMN_ATRIBUTE_ISREQUIRED="ISREQUIRED";

    public static final String PARAM_IN_ENTITY_ENTITYTYPEID = "inEntityTypeId";
    public static final String PARAM_IN_ENTITY_ATRIBUTES = "inAttributeCSV";
    public static final String PARAM_IN_ENTITY_VALUES = "inValueCSV";
    public static final String PARAM_IN_ENTITY_OPERATORS = "inOperatorCSV";

    public static final String PARAM_IN_USER_ID = "INUSERID";
    public static final String PARAM_IN_USER_LOGIN = "INUSERLOGIN";
    public static final String PARAM_IN_LOGIN = "INLOGIN";

    public static final String PARAM_IN_USER_PASSWORD = "INUSERPASSWORD";
    public static final String PARAM_IN_USER_USERNAME = "INUSERNAME";
    public static final String PARAM_IN_USER_PHONE = "INUSERPHONE";
    public static final String PARAM_IN_USER_ADDRESS = "INUSERADRESS";
    public static final String PARAM_IN_USER_ROLEID = "INUSERROLEID";

    public static final String PARAM_OUT_ENTITY_LIST = "outEntity";

    public static final String PARAM_OUT_USER_ID = "OUTUSERID";
    public static final String PARAM_OUT_USER = "OUTUSER";
    public static final String PARAM_OUT_USER_LIST = "OUTUSERLIST";
    public static final String PARAM_OUT_USER_PASSWORD = "OUTUSERPASSWORD";

    public static final String PROCEDURE_ENTITY_GET_LIST = "sp_entity_list";
    public static final String PROCEDURE_USER_GET = "sp_user_get";
    public static final String PROCEDURE_USER_DELETE = "sp_user_delete";
    public static final String PROCEDURE_USER_UPDATE = "sp_user_update";
    public static final String PROCEDURE_USER_INSERT = "sp_user_insert";
    public static final String PROCEDURE_USER_LOGIN = "sp_user_login";
    public static final String PROCEDURE_USER_GET_LIST = "sp_user_get_list";



    private DaoConstants(){}
}
