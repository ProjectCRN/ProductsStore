sqlplus -SILENT "ns_admin/qwerty@xe" @Shemas\02_create_sequance.sql
sqlplus -SILENT "ns_admin/qwerty@xe" @Shemas\03_create_tables.sql
sqlplus -SILENT "ns_admin/qwerty@xe" @Shemas\04_create_global_table.sql

sqlplus -SILENT "ns_admin/qwerty@xe" @tr\tr_delete_user.sql


sqlplus -SILENT "ns_admin/qwerty@xe" @Init_data\01_Role.sql
sqlplus -SILENT "ns_admin/qwerty@xe" @Init_data\02_User.sql
sqlplus -SILENT "ns_admin/qwerty@xe" @Init_data\03_AtributeType.sql
sqlplus -SILENT "ns_admin/qwerty@xe" @Init_data\04_EntityType.sql
sqlplus -SILENT "ns_admin/qwerty@xe" @Init_data\05_Atribute.sql
sqlplus -SILENT "ns_admin/qwerty@xe" @Init_data\06_Entity.sql
sqlplus -SILENT "ns_admin/qwerty@xe" @Init_data\07_Value.sql

sqlplus -SILENT "ns_admin/qwerty@xe" @Procedures\sp_entity_list.sql