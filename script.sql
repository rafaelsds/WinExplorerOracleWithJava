CREATE OR REPLACE package body util_pck as

    procedure explorer_create_folder(ds_folder_dest_p in varchar2)as 
        language java name 'br.com.rafaelsds.util.Function.createFolder(java.lang.String)';

       
    procedure explorer_rename_file(ds_file_origin_p in varchar2, ds_folder_dest_p in varchar2)as 
        language java name 'br.com.rafaelsds.util.Function.renameFile(java.lang.String, java.lang.String)';

 
    procedure explorer_move_file(ds_file_origin_p in varchar2, ds_folder_dest_p in varchar2)as 
        language java name 'br.com.rafaelsds.util.Function.moveFile(java.lang.String, java.lang.String)';

        
    procedure explorer_copy_file(ds_file_origin_p in varchar2, ds_folder_dest_p in varchar2)as 
        language java name 'br.com.rafaelsds.util.Function.copyFile(java.lang.String, java.lang.String)';


end util_pck;
/



CREATE OR REPLACE package util_pck as
    procedure explorer_create_folder (ds_folder_dest_p in varchar2);
    procedure explorer_rename_file (ds_file_origin_p in varchar2, ds_folder_dest_p in varchar2);
    procedure explorer_move_file (ds_file_origin_p in varchar2, ds_folder_dest_p in varchar2);
    procedure explorer_copy_file (ds_file_origin_p in varchar2, ds_folder_dest_p in varchar2);
end util_pck;
/

