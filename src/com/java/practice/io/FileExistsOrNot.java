package com.java.practice.io;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileExistsOrNot {
public static void main(String[] args) {
	Path path = Paths.get("C:\\Users\\sanath.bt\\Desktop\\DummyFolders");
	if(Files.exists(path, LinkOption.NOFOLLOW_LINKS)){
		System.out.println("file exists");
	} else{
		System.out.println("file not exists");
	}
	
}
}
