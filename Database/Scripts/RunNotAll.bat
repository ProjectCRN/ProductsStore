sqlplus -SILENT "ns_admin/qwerty@xe" @AllForBat\00_dropAll.sql
sqlplus -SILENT "ns_admin/qwerty@xe" @AllForBat\02_create_sequance.sql
sqlplus -SILENT "ns_admin/qwerty@xe" @AllForBat\03_create_tables.sql


sqlplus -SILENT "ns_admin/qwerty@xe" @AllForBat\01_Role.sql
sqlplus -SILENT "ns_admin/qwerty@xe" @AllForBat\02_User.sql
sqlplus -SILENT "ns_admin/qwerty@xe" @AllForBat\03_AtributeType.sql
sqlplus -SILENT "ns_admin/qwerty@xe" @AllForBat\04_EntityType.sql
sqlplus -SILENT "ns_admin/qwerty@xe" @AllForBat\05_Atribute.sql
sqlplus -SILENT "ns_admin/qwerty@xe" @AllForBat\06_Entity.sql
sqlplus -SILENT "ns_admin/qwerty@xe" @AllForBat\07_Value.sql

sqlplus -SILENT "ns_admin/qwerty@xe" @AllForBat\sp_entity_list.sql
sqlplus -SILENT "ns_admin/qwerty@xe" @AllForBat\sp_count_rows.sql
sqlplus -SILENT "ns_admin/qwerty@xe" @AllForBat\sp_entity_listValues.sql
sqlplus -SILENT "ns_admin/qwerty@xe" @AllForBat\sp_entity_NoPaging.sql