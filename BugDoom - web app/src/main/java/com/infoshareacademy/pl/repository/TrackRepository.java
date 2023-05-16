
package com.infoshareacademy.pl.repository;

import com.infoshareacademy.pl.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {

    @Query(value = "SELECT t FROM Track t WHERE t.competitionName LIKE %:name%")
    List<Track> findTracksByName(@Param("name") String name);

    @Query(value = "SELECT t FROM Track t WHERE t.difficulty = :difficulty")
    List<Track> filterTracksByDifficulty(@Param("difficulty") String difficulty);

    @Query(value = "SELECT t FROM Track t WHERE t.event.eventId = :eventId")
    List<Track> findTracksByEventId(@Param("eventId") long eventId);
}
