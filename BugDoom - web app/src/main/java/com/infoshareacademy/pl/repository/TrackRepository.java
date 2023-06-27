
package com.infoshareacademy.pl.repository;

import com.infoshareacademy.pl.model.Track;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {

    @Query(value = "SELECT t FROM Track t WHERE t.competitionName LIKE %:name%")
    Page<Track> findTracksByName(Pageable pageable, @Param("name") String name);

    @Query(value = "SELECT t FROM Track t WHERE t.difficulty = :difficulty")
    Page<Track> filterTracksByDifficulty(Pageable pageable, @Param("difficulty") String difficulty);

    @Query(value = "SELECT t FROM Track t WHERE t.event.eventId = :eventId")
    Page<Track> findTracksByEventId(Pageable pageable, @Param("eventId") long eventId);
}
