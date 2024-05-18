package com.example.lab_5.repositories;


import com.example.lab_5.entity.QuestEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface QuestsRepository  extends JpaRepository<QuestEntity, Integer> {
    @Query(value = "SELECT questTitle as quest_title, questText as quest_text, personId as person_id, reward, penalty, timeOfStarted as time_of_started, timeForQuestInMinutes as time_for_quest_in_minutes, placeId as place_id, modelId as model_id, levelDifficulty as level_difficulty, questStatus as quest_status, questId as quest_id FROM quests", nativeQuery = true)
    List<QuestEntity> findAllQuests();
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO quests (questTitle, questText, personId, reward, penalty, timeOfStarted, timeForQuestInMinutes, placeId, modelId, levelDifficulty, questStatus) " +
            "VALUES (:#{#quest.questTitle}, :#{#quest.questText}, :#{#quest.personId}, :#{#quest.reward}, :#{#quest.penalty}, :#{#quest.timeOfStarted}, :#{#quest.timeForQuestInMinutes}, " +
            ":#{#quest.placeId}, :#{#quest.modelId}, :#{#quest.levelDifficulty}, :#{#quest.questStatus})", nativeQuery = true)
    void addQuest(@RequestBody QuestEntity quest);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM quests WHERE questId = :questId", nativeQuery = true)
    void deleteQuestById(@Param("questId") Integer questId);
}

