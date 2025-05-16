package com.uk.JournalApp.repository;

import com.uk.JournalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {

}
