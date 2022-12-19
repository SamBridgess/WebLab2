package com.exmpale.models;

import jakarta.inject.Named;
import jakarta.inject.Singleton;

import java.util.LinkedList;
import java.util.List;

@Singleton
@Named("am")
public class AttemptsManager {
    private final List<PointResult> results;

    public AttemptsManager() {
        results = new LinkedList<>();
    }

    public List<PointResult> getResults() {
        return results;
    }
    public void addResult(PointResult result) {
        results.add(result);
    }
    public void clear() {results.clear();}
}
