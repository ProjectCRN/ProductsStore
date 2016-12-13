У кого вылетает java.sql.SQLException: ORA-00604 
в параметрах jvm прописать
-Duser.country=EN, -Duser.language=en

tomcat:
В setenv.bat прописать set JAVA_OPTS=-Duser.country=EN -Duser.language=en
