package br.com.khadije.upcomingmovieswebapp.utils;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ListDiffer<T> {

    private List<T> addedList = new ArrayList<>();
    private List<T> unchangedList = new ArrayList<>();
    private List<T> removedList = new ArrayList<>();

    public ListDiffer(List<T> beforeList, List<T> afterList) {
        addedList.addAll(afterList); 
        beforeList.forEach(e -> {
            boolean result = addedList.remove(e) ? unchangedList.add(e) : removedList.add(e);
        });
    }
    

}