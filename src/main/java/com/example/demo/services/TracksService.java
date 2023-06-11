package com.example.demo.services;

import com.example.demo.OrderBy;
import com.example.demo.OrderOption;
import com.example.demo.ShopItem;
import com.example.demo.ShopItemCharacteristic;
import com.example.demo.filters.Checkbox;
import com.example.demo.filters.FilterOption;
import com.example.demo.filters.FilterView;
import com.example.demo.filters.FilterWindow;
import com.example.demo.models.Car;
import com.example.demo.models.Track;
import com.example.demo.repository.TrackRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TracksService {

    private final TrackRepository trackRepository;
    private final String[] orderByOptions = {
            "Id",
            "Price",
            "Name",
            "Difficulty",
            "Length"
    };

    public TracksService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public List<ShopItem> getAllTracks(int orderBy, String direction) {
        List<Track> tracks = trackRepository.findAll(Sort.by(Sort.Direction.fromString(direction), ColumnNameMapper.getValue(orderBy)));
        List<ShopItem> items = new ArrayList<>();
        for (Track track : tracks) {
            long id = track.getId();
            String thumbnail = "/images/tracks/" + track.getThumbnail().getImage();
            String name = track.getName();
            List<ShopItemCharacteristic> itemCharacteristics = new ArrayList<>();
            itemCharacteristics.add(new ShopItemCharacteristic("Difficulty", track.getDifficulty().getDifficulty()));
            itemCharacteristics.add(new ShopItemCharacteristic("Length", String.valueOf(track.getLength()), "(m)"));
            double price = track.getPrice();
            boolean isWishlisted = false;
            boolean isCarted = false;

            items.add(new ShopItem(id, thumbnail, name, itemCharacteristics, price, isWishlisted, isCarted));
        }
        return items;
    }

    public Map<String, Integer> groupCountDifficultiesByType() {
        HashMap<String, Integer> difficulties = new HashMap<>();
        for(Track t : trackRepository.findAll()) {
            difficulties.merge(t.getDifficulty().getDifficulty(), 1, Integer::sum);
        }
        return difficulties;
    }

    public FilterWindow getFilterWindow() {
        List<FilterView> filterViewList = new ArrayList<>();
        filterViewList.add(getDifficultyFilterView());
        return new FilterWindow("Filters", filterViewList);
    }

    public FilterView getDifficultyFilterView() {
        List<FilterOption> filterOptions = new ArrayList<>();
        Map<String, Integer> difficulties = groupCountDifficultiesByType();
        for (Map.Entry<String, Integer> entry : difficulties.entrySet()) {
            filterOptions.add(new Checkbox(entry.getKey(), false, entry.getValue()));
        }
        return new FilterView("Difficulties", filterOptions);
    }

    public OrderBy getOrderBy(int orderBy, String direction) {
        List<OrderOption> orderOptions = new ArrayList<>();
        orderOptions.add(OrderOption.ID);
        orderOptions.add(OrderOption.PRICE);
        orderOptions.add(OrderOption.NAME);
        orderOptions.add(OrderOption.DIFF);
        orderOptions.add(OrderOption.LEN);
        return new OrderBy(orderBy, orderOptions, direction);
    }
}
