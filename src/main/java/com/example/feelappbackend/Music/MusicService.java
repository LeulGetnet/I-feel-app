package com.example.feelappbackend.Music;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class MusicService {

    private audioRepository audioRepository;
    private musicRepository musicRepository;

    public String addMusic(@RequestBody AudioModel audio) throws Exception{
        try {

            MusicMOdel newmusic = new MusicMOdel();
            AudioModel newaudio = new AudioModel();

            String fileName = audio.getFileName();
            String fileType = audio.getFileType();
            Long sinze = audio.getSize();

            boolean isPremium = audio.getIsPremium();
            newmusic = audio.getMusicmodel();

            newmusic = musicRepository.save(newmusic);
            newaudio.setFileName(fileName);
            return "";
            
        } catch (Exception e) {
            // TODO: handle exception
            return "";
        }



        
    }
    
}
