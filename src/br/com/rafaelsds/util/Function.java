package br.com.rafaelsds.util;

import java.net.MalformedURLException;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;

public class Function {
    
    static final String DOMAIN = "organization.local";
    static final String USER = "User";
    static final String PASSWORD = "PassWordUser";
    
    static final NtlmPasswordAuthentication AUTH = new NtlmPasswordAuthentication(DOMAIN, USER, PASSWORD);
    
    public static void createFolder(String folderName) throws java.lang.Exception{
        
        try{
            String urlDirectory = "smb:" + folderName.replace("\\", "/");
            SmbFile dirFile = new SmbFile(urlDirectory, AUTH);       

            if (!dirFile.exists()) {
                dirFile.mkdirs();
            }
            
        }catch(Exception e){
            throw new Exception("Error: "+e.getMessage());
        }
    }
    
    
    public static void renameFile(String fileOrigin, String fileDest) throws java.lang.Exception{
        
        SmbFile file = null;
        fileOrigin = "smb:" + fileOrigin.replace("\\", "/");
        
        try {
            file = new SmbFile (fileOrigin, AUTH);
        } catch(MalformedURLException e) {
            throw new Exception("Error: "+e.getMessage());
        }  
        
        try{
            file.renameTo(new SmbFile(file.getPath().replace(file.getName(), fileDest), AUTH));
        }catch(SmbException e){    
            throw new Exception("Error: "+e.getMessage());
        }
    }
    
    
    public static void moveFile(String fileOrigin, String fileDest) throws java.lang.Exception{
        SmbFile file = null;
        
        fileOrigin = "smb:" + fileOrigin.replace("\\", "/");
        fileDest = "smb:" + fileDest.replace("\\", "/");

        if(!fileDest.substring(fileDest.length()-1).equals("/")){// SE NAO PASSAR BARRA FINAL, AJUSTAR
            fileDest+="/";
        }

        try {
            file = new SmbFile (fileOrigin, AUTH);
            fileDest+= file.getName();
        } catch(MalformedURLException e) {
            throw new Exception("Error: "+e.getMessage());
        }  
            
        try{
            file.renameTo(new SmbFile(fileDest, AUTH));
        }catch(SmbException e){    
            throw new Exception("Error: "+e.getMessage());
        }
        
    }
    
    
    public static void copyFile(String fileOrigin, String fileDest)throws java.lang.Exception{
        SmbFile file = null;
        fileOrigin = "smb:" + fileOrigin.replace("\\", "/");
        fileDest = "smb:" + fileDest.replace("\\", "/");
        
        if(!fileDest.substring(fileDest.length()-1).equals("/")){
            fileDest+="/";
        }
        
        try {
            file = new SmbFile (fileOrigin, AUTH);
            fileDest+= file.getName();
        } catch(MalformedURLException e) {
            throw new Exception("Error: "+e.getMessage());
        } 
        
        try{
            file.copyTo(new SmbFile(fileDest, AUTH));
        }catch(SmbException e){    
            throw new Exception("Error: "+e.getMessage());
        }
        
    }
    
}
