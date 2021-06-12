package com.projects.university.mapper;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DozerBeanMapper {

    @Autowired
    private Mapper mapper;

    @Bean
    public Mapper mapper() {
        return new org.dozer.DozerBeanMapper();
    }
}
