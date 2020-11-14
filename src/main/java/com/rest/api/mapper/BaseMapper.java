package com.rest.api.mapper;

public interface BaseMapper<I, O> {
    O map(I input);
}
