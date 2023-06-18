package com.example.demo.services;

import com.example.demo.Transformer;
import com.example.demo.layout.filters.Checkbox;
import com.example.demo.layout.filters.FilterOption;
import com.example.demo.layout.filters.FilterView;
import com.example.demo.layout.filters.FilterWindow;
import com.example.demo.layout.items.ShopItem;
import com.example.demo.layout.order.OrderBy;
import com.example.demo.layout.order.OrderOption;
import com.example.demo.models.Track;
import com.example.demo.repository.TrackRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TracksService {

    private final TrackRepository trackRepository;

    public TracksService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public List<ShopItem> getAllTracks(int orderBy, String direction) {
        List<Track> tracks = trackRepository.findAll(Sort.by(Sort.Direction.fromString(direction), ColumnNameMapper.getValue(orderBy)));
        return new ArrayList<>(Transformer.trackToShopItem(tracks));
    }

    public Map<String, Integer> groupCountDifficultiesByType() {
        HashMap<String, Integer> difficulties = new HashMap<>();
        for (Track track : trackRepository.findAll()) {
            difficulties.merge(track.getDifficulty().getDifficulty(), 1, Integer::sum);
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

    public void updateWishlistedStatusById(Long id) {
        Boolean wishlistedStatus = trackRepository.getWishlistStatus(id);
        trackRepository.updateWishlistedStatusById(id, !wishlistedStatus);
    }

    public List<Track> getAllWishlisted() {
        return trackRepository.getAllWithWishlistStatus(true);
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
