package com.example.demo.services;

import com.example.demo.models.Track;
import com.example.demo.repository.TrackRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TracksService {

    private final TrackRepository trackRepository;

    public TracksService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public List<Track> getAllTracks(int orderBy, String direction) {
        return trackRepository.findAll(Sort.by(Sort.Direction.fromString(direction), ColumnNameMapper.getValue(orderBy)));
    }

    public Map<String, Integer> groupCountDifficultiesByType() {
        HashMap<String, Integer> difficulties = new HashMap<>();
        for(Track t : trackRepository.findAll()) {
            difficulties.merge(t.getDifficulty().getDifficulty(), 1, Integer::sum);
        }
        return difficulties;
    }
}
