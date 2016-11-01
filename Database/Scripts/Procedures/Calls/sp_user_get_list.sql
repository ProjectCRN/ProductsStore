VARIABLE pcv REFCURSOR
EXECUTE ns_admin.sp_user_get_list('A',:pcv);
PRINT pcv;