package com.java.practice.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class DeleteFiles {
public static void main(String[] args) throws IOException {
	File directory = new File("D:\\usr\\share\\axis-o-temp\\tempDocUpload_546333_5415_938");
	Arrays.stream(directory.listFiles((f, p) -> p.endsWith(".zip"))).forEach(File::delete);    
	
}

public static void dummy() {
	Path path = Paths.get("");
}
}
