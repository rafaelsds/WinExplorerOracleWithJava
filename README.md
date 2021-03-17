# Manipulate windows explorer functions through oracle database
Interaction with windows explorer through the oracle database. It is possible to create folders, move and rename files from shared directories.


1 - Adjust the DOMAIN, USER and PASSWORD variables (Project java, class Function.java);
<br/>
2 - Compile project;
<br/>
<br/>
3 - Import the compiled class "Funcion.class" and the jcifs.jar library into the oracle database (oracle user needs grant dba);
<br/>
4 - Create the objects (util.pck) by running file script.sql;
<br/>
5 - Grant permission to the current schema by running the command "exec dbms_java.grant_permission( 'YourUserOracle', 'SYS:java.net.NetPermission', 'specifyStreamHandler', '' )".
<br/>
<br/>
Command example:
<br/>
exec util_pck.explorer_create_folder('\\\srv-fs\dados\teste\');
<br/>
exec util_pck.explorer_rename_file('\\\srv-fs\dados\teste\teste.txt', 'testenew.txt');
<br/>
exec util_pck.explorer_move_file('\\\srv-fs\dados\teste\teste.txt', '\\\srv-fs\dados\teste\newdir\');
<br/>
exec util_pck.explorer_copy_file('\\\srv-fs\dados\teste\teste.txt', '\\\srv-fs\dados\teste\newdir\');
