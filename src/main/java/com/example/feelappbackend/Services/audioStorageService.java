package com.example.feelappbackend.Services;

import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.util.StringUtils;

@Service
public class audioStorageService {

    private final Path  fileStorage;
    public audioStorageService(@Value("${file.upload-dir}") String uploadDir) throws IOException{

        this.fileStorage = Paths.get(uploadDir).toAbsolutePath().normalize();

        try{
            Files.createDirectories(this.fileStorage);
  
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
     
      
    }

    public String storeFile(MultipartFile file) throws IOException{

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String uniqueFileName = System.currentTimeMillis() + "_" + fileName;

            // Copy the file to the target location
            Path targetLocation = fileStorage.resolve(uniqueFileName);
            Files.copy(file.getInputStream(), targetLocation);

            return uniqueFileName; // Return the filename for future use if needed
       


   
    
}
}