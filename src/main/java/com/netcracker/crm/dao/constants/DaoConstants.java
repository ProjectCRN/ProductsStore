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

    public static final String PARAM_IN_USER_ID = "INUSERID";
    public static final String PARAM_IN_USER_LOGIN = "INUSERLOGIN";
    public static final String PARAM_IN_LOGIN = "INLOGIN";

    public static final String PARAM_IN_USER_PASSWORD = "INUSERPASSWORD";
    public static final String PARAM_IN_USER_USERNAME = "INUSERNAME";
    public static final String PARAM_IN_USER_PHONE = "INUSERPHONE";
    public static final String PARAM_IN_USER_ADDRESS = "INUSERADRESS";
    public static final String PARAM_IN_USER_ROLEID = "INUSERROLEID";


    public static final String PARAM_OUT_USER_ID = "OUTUSERID";
    public static final String PARAM_OUT_USER = "OUTUSER";
    public static final String PARAM_OUT_USER_LIST = "OUTUSERLIST";
    public static final String PARAM_OUT_USER_PASSWORD = "OUTUSERPASSWORD";

    public static final String PROCEDURE_USER_GET = "sp_user_get";
    public static final String PROCEDURE_USER_DELETE = "sp_user_delete";
    public static final String PROCEDURE_USER_UPDATE = "sp_user_update";
    public static final String PROCEDURE_USER_INSERT = "sp_user_insert";
    public static final String PROCEDURE_USER_LOGIN = "sp_user_login";
    public static final String PROCEDURE_USER_GET_LIST = "sp_user_get_list";



    private DaoConstants(){}
}
