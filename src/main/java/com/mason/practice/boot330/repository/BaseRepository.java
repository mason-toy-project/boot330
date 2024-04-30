package com.mason.practice.boot330.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BaseRepository {
    public String getName() {
        return "Some name";
    }
}
