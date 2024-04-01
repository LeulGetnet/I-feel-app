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
    public audioStorageService(@Value("${file.upload-dir}") String uploadDir) {

        this.fileStorage = Paths.get(uploadDir).toAbsolutePath().normalize();
     
       
  
    }

    public String storeFile(MultipartFile file){

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String uniqueFileName = System.currentTimeMillis() + "_" + fileName;

        try {
            Files.createDirectories(this.fileStorage);
          
            // Copy the file to the target location
            Path targetLocation = fileStorage.resolve(uniqueFileName);
            Files.copy(file.getInputStream(), targetLocation);

            return uniqueFileName; // Return the filename for future use if needed
        } catch (IOException ex) {
            throw new RuntimeException("Failed to store file " + uniqueFileName, ex);
        }

    }

   
    
}
