package Project.FilesAccess;

import Thread.productConsumer.ProductConsumer;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class main {

    private String currentLocation=new String("/home/ujjawal");
    private String userName="ujjawal";


    private void changeDirectory(){

    }
    void main() throws InterruptedException {
        while(true){
            System.out.print(" -> ");
            String temp=IO.readln().trim();
            String[] token=temp.split("\\s+");


            // token debugger
            System.out.println();
            System.out.println("converted into token ");
            for(String s1:token){
                System.out.print(" "+s1+" ");

            }
            System.out.println();
            System.out.println();



            try{
                this.ProecessCommand(token,currentLocation);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println();
        }
    }
    public void ProecessCommand(String[] TokenedCommand,String currentLocation) throws InterruptedException {
        String temp=TokenedCommand[0];
        File cL=new File(currentLocation);
        FileManipulation fm;
        FileExplorer fe;
        switch (temp){
            case "ls":{
                FileExplorer pr=new print();
                if(TokenedCommand.length>1){
                    boolean t=true;
                    if(TokenedCommand[1].startsWith("-")){
                        if(TokenedCommand[1].charAt(1)=='R'){
                            pr=new PrintingRecursive();
                        }
                        t=false;
                    }
                    if(t||((!t)&&TokenedCommand.length>=3)){
                        if(TokenedCommand[(t)?1:2].startsWith("/")){
                            ///  with full file path
                           cL= new File(TokenedCommand[(t)?1:2]);
                        }
                        else{
                            /// wihout full path just  call from the current opend file's folder
                            cL=new File(cL.getAbsoluteFile()+"/"+TokenedCommand[1]);
                        }
                    }
                    try{
                        pr.getFromOS(cL);
                    }catch(NullPointerException e){
                        System.out.println("Null pointer Exception "+e);
                    }

                }
                else{
                    pr.getFromOS(cL);
                }
                break;
            }
            case "cd": {
                String mainLocation = "/home/"+this.userName;
                // change directory
                // cd ..
                // cd FolderName so just move to ther
                // cd / start with this ho raha ho toh udhar chale jana ok

                if (TokenedCommand.length == 1) {
                    if (currentLocation.equals(mainLocation)) {
                        // leave it blank task

                    } else {
                        this.currentLocation = mainLocation;
                    }
                } else if (TokenedCommand.length == 2) {
                    String t1 = TokenedCommand[1];
                    if (t1.equals("..")) {
                        if (currentLocation.lastIndexOf("/") == 0) {
                            return;
                        };
                        String p1=(currentLocation.substring(0, currentLocation.lastIndexOf('/')));
                        //
                        System.out.println(p1);
                        this.currentLocation=p1;
                    } else if (t1.equals(".")) {

                    } else if (t1.startsWith("/")) {
                        // directly went there if it is directory ok
                        File a=new File(t1);
                        if(a.exists()&&a.isDirectory()){
                            this.currentLocation=t1;
                        }
                    } else {
                        // simple some file we have to check if icdt is directory so swtich to there ok
                        File a=new File(this.currentLocation+"/"+t1);
                        if(a.exists()&&a.isDirectory()){
                            this.currentLocation=this.currentLocation+"/"+t1;
                        }else {
                            //throw new IllegalArgumentException("file maybe not exist or it is not directory ");
                            System.out.println("file maybe not exist or it is not directory");
                        }
                    }

                }
                break;
            }
            case "mkdir":{
                if(TokenedCommand.length==1){
                    return;
                }
                String newFileCrationTask=this.currentLocation+"/"+TokenedCommand[1];
                mkdir a=new mkdir();
                a.getFromOS(new File(newFileCrationTask));
                break;
            }
            case "touch":{
                if(TokenedCommand.length==1){
                    return ;
                }
                String newFileCrationTask=this.currentLocation+"/"+TokenedCommand[1];
                createFile cf=new createFile();
                cf.getFromOS(new File(newFileCrationTask));
                break;
            }
            case "cp":{
                if(TokenedCommand.length==3){
                    fm=new copy();
                    fm.Process(TokenedCommand[1],TokenedCommand[2]);
                }
                else{
                    return;
                }
                break;
            }
            case "cat":{

                break;
            }
            case "mv":{

                break;
            }
            case "rm":{


                break;
            }
            case "pwd":{
                System.out.println(currentLocation);
                break;
            }
            default:
                System.out.println("nothing");
                break;
        }
    }
}
