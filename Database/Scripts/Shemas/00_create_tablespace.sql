rem -- create data tablespaces --;
create tablespace NetShop_DATA
  datafile 'c:\oraclexe\app\oracle\oradata\XE\NetShop_DATA.dat' size 10M 
  autoextend on maxsize unlimited 
  extent management local autoallocate
  segment space management auto;


rem -- create index tablespaces --;
create tablespace NetShop_INDEX
  datafile 'c:\oraclexe\app\oracle\oradata\XE\NetShop_INDEX.dat' size 10M 
  autoextend on maxsize unlimited 
  extent management local autoallocate
  segment space management auto;


rem -- create temporary tablespaces --;
create temporary tablespace NetShop_temp 
  tempfile 'c:\oraclexe\app\oracle\oradata\XE\NetShop_temp.dat' size 10M  autoextend on maxsize unlimited;


exit;
/