package com.example.feelappbackend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.feelappbackend.Repository.audioRepository;
import com.example.feelappbackend.Repository.musicRepository;
import com.example.feelappbackend.doa.Intensity;
import com.example.feelappbackend.doa.Mood;
import com.example.feelappbackend.doa.audioBody;
import com.example.feelappbackend.doa.elength;
import com.example.feelappbackend.models.AudioModel;
import com.example.feelappbackend.models.MusicModel;

@Service
public class MusicService {
    @Autowired
    private audioRepository audioRepository;
    @Autowired
    private musicRepository musicRepository;
    @Value("${file.upload-dir}")
    private String uploadDir;

    public MusicModel createMusic(audioBody audio){

        try {

            MusicModel newmusic = musicRepository.findByIntensityAndMoodAndLength(audio.getMusicmodel().getIntensity(), audio.getMusicmodel().getMood(), audio.getMusicmodel().getLength());
            
            if(newmusic == null){
                elength length = elength.fromString(audio.getMusicmodel().getLength());
                Mood mood = Mood.fromString(audio.getMusicmodel().getMood());
                Intensity intensity = Intensity.fromString(audio.getMusicmodel().getIntensity());
    
                newmusic.setIntensity(intensity);
                newmusic.setLength(length);
                newmusic.setMood(mood);
                newmusic = musicRepository.save(newmusic);

            }
            return newmusic;
            
        } catch (Exception e) {
           throw new IllegalArgumentException("llegal argument");
        }    
    }

    public AudioModel addMusic(@RequestBody audioBody audio) throws IllegalArgumentException{
        

           
        AudioModel newaudio = new AudioModel();

        newaudio.setFileName(audio.getFileName());
        newaudio.setFileType(audio.getFileType());
        newaudio.setSize(audio.getSize());
        newaudio.setIsPremium(audio.getIsPremium());

        try{
            audioStorageService audioStorageService = new audioStorageService(uploadDir);
            MusicModel newmusic = createMusic(audio);
            newaudio.setMusicmodel(newmusic);
            newaudio.setUniqueFileName(audioStorageService.storeFile(audio.getFile()));
            newaudio = audioRepository.save(newaudio);
            return newaudio;
            }
          
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("illegal argument");
            }
        
    }
    
}
