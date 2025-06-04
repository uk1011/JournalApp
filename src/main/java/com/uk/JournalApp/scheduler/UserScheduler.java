package com.uk.JournalApp.scheduler;

import com.uk.JournalApp.cache.AppCache;
import com.uk.JournalApp.entity.JournalEntry;
import com.uk.JournalApp.entity.User;
import com.uk.JournalApp.enums.Sentiment;
import com.uk.JournalApp.repository.UserRepositoryImpl;
import com.uk.JournalApp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class UserScheduler {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
    private AppCache appCache;

//    @Scheduled(cron = "0 50 11 ? * FRI")
//    @Scheduled(cron = "0 * * ? * *")
    public void fetchUserAndSendSaMails(){
        List<User> users = userRepository.getUserForSA();
        for(User user: users){
            List<JournalEntry> journalEntries = user.getJournalEntries();
            List<Sentiment> sentiments = journalEntries.stream().filter(x -> x.getDate().isAfter(LocalDateTime.now().minus(7, ChronoUnit.DAYS))).map(x -> x.getSentiment()).collect(Collectors.toList());
            Map<Sentiment, Integer> sentimentCounts = new HashMap<>();
            for(Sentiment sentiment : sentiments){
                if(sentiment != null){
                sentimentCounts.put(sentiment,sentimentCounts.getOrDefault(sentiment,0)+1);
                }
            }
            Sentiment mostFrequentSentiment = null;
            int maxCount = 0;
            for(Map.Entry<Sentiment, Integer> entry : sentimentCounts.entrySet()){
                if(entry.getValue() > maxCount){
                    maxCount = entry.getValue();
                    mostFrequentSentiment = entry.getKey();
                }
            }
            if(mostFrequentSentiment != null){
                emailService.sendEmail(user.getEmail(),"Sentiment for Last 7 days ", mostFrequentSentiment.toString());
            }
        }
    }

    @Scheduled(cron = "0 */10 * * * *")
    public void clearAppCache(){
        appCache.init();
    }

}
