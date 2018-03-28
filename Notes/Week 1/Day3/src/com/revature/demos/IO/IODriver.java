package com.revature.demos.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class IODriver {
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getZipFileName() {
        return zipFileName;
    }

    public void setZipFileName(String zipFileName) {
        this.zipFileName = zipFileName;
    }

    private String path;;
    private String regex;
    private String zipFileName;
    Pattern pattern;
    List<File> zipFiles = new ArrayList<File>();

    public static void main(String[] args){
        IODriver app = new IODriver();


        switch(Math.min(args.length, 3)){
            case 0:
                System.out.println("USAGE: IODriver path [regex] [zipfile]");
                return;
            case 3:
                app.setZipFileName(args[2]);
            case 2:
                app.setRegex(args[1]);
            case 1:
                app.setPath(args[0]);
        }

    }

    public void walkDirectory(String path){
        File dir = new File(path);
        File[] files = dir.listFiles();
        for(File file : files){
            if(file.isDirectory()){
                walkDirectory(file.getAbsolutePath());
            } else {
                //processFile(file);
            }
        }
    }

    public void walkDirectory_java8(String path) throws IOException {

        Files.walk(Paths.get(path)).forEach(f -> System.out.println(f.toFile().getAbsolutePath()));
    }



    public boolean searchFile_java8(File file) throws IOException{
        return Files.lines(file.toPath()).anyMatch(t -> searchText(t));
    }

    public boolean searchText(String text){
        return (this.getRegex() == null) ? true : this.pattern.matcher(text).matches();
    }

    public void zipFiles_java7() throws IOException{
        try(ZipOutputStream out = new ZipOutputStream(new FileOutputStream(getZipFileName()))){
            File baseDir = new File(getPath());

            for (File file : zipFiles){
                String fileName = getRelativeFilename(file, baseDir);

                ZipEntry zipEntry = new ZipEntry(fileName);
                zipEntry.setTime(file.lastModified());
                out.putNextEntry();
            }
        }
    }

    public String getRelativeFilename(File file, File baseDir){
        String fileName = file.getAbsolutePath().substring(baseDir.getAbsolutePath().length());
        fileName = fileName.replace('\\', '/');

        while(fileName.startsWith("/")){
            fileName = fileName.substring(1);
        }
        return fileName;
    }

}
