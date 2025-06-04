package com.uk.JournalApp.cache;

import com.uk.JournalApp.entity.ConfigJournalAppEntity;
import com.uk.JournalApp.repository.ConfigJournalAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {

    
    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;

    public Map<String, String> appCache;

    @PostConstruct
    public void init() {
        try {
            appCache = new HashMap<>();
            List<ConfigJournalAppEntity> all = configJournalAppRepository.findAll();
            for (ConfigJournalAppEntity configJournalAppEntity : all) {
                appCache.put(configJournalAppEntity.getKey(), configJournalAppEntity.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace(); // This will show the real error in logs
        }
    }

}
