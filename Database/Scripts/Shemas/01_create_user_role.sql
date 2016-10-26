rem -- create admin user (owner all objects) --;
create user ns_admin identified by qwerty
  default tablespace NetShop_DATA 
  temporary tablespace NetShop_temp
  quota unlimited on NetShop_DATA
  quota unlimited on NetShop_INDEX;

rem -- grant sysdba permissions to ns_admin user --;
grant dba to ns_admin;  
  

exit;
/