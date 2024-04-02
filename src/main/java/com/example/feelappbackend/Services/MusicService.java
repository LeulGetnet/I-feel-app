package com.example.feelappbackend.Services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.feelappbackend.Repository.audioRepository;
import com.example.feelappbackend.Repository.musicRepository;
import com.example.feelappbackend.doa.Intensity;
import com.example.feelappbackend.doa.Mood;
import com.example.feelappbackend.doa.audioBody;
import com.example.feelappbackend.doa.elength;
import com.example.feelappbackend.doa.musicBody;
import com.example.feelappbackend.models.AudioModel;
import com.example.feelappbackend.models.MusicModel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@Service
public class MusicService {
   
    @Autowired
    private audioRepository audioRepository;
    @Autowired
    private musicRepository musicRepository;
    @Value("${file.upload-dir}")
    private String uploadDir;

    public MusicModel createMusic(musicBody music){

        try {
            MusicModel newmusic = musicRepository.findByIntensityAndMoodAndLength(music.getIntensity(), music.getMood(), music.getLength());
            if (newmusic == null){

                MusicModel musicModel = new MusicModel();
                musicModel.setIntensity(Intensity.fromString(music.getIntensity()));
                musicModel.setLength(elength.fromString(music.getLength()));
                musicModel.setMood(Mood.fromString(music.getMood()));
                musicRepository.save(musicModel);

            }
            return newmusic;
            
        } catch (Exception e) {
           throw new IllegalArgumentException("llegal argument");
        }    
    }

    public AudioModel addMusic(@RequestBody MultipartFile file, @RequestBody musicBody music) throws IllegalArgumentException, IOException{
        

        try {
            // Create the directory if it doesn't exist
            Files.createDirectories(Paths.get(uploadDir));

            // Save the file to the upload directory
          
            MusicModel newmusic = createMusic(music);


            Path filePath = Paths.get(uploadDir + file.getOriginalFilename());
            Files.write(filePath, file.getBytes());
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            String uniqueFileName = System.currentTimeMillis() + "_" + fileName;
            long size = file.getSize();
            String type = file.getContentType();



            AudioModel audioModel = new AudioModel();
            audioModel.setFileName(fileName);
            audioModel.setFileType(type);
            audioModel.setSize(size);
            audioModel.setMusicmodel(newmusic);
            audioModel.setUniqueFileName(uniqueFileName);
            audioModel.setIsPremium(false);

            
            return audioRepository.save(audioModel);

            // Store file metadata along with the file path
           
        } catch (IOException e) {
            throw new IOException("exception: " + e);
        }
        
        catch(IllegalArgumentException e){
            throw new IllegalArgumentException("error");
        }
    }
    
}
