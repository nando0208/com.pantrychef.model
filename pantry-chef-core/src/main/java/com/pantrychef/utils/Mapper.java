package com.pantrychef.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.UUID;

public class Mapper {

    private static Mapper mapper;
    private static ObjectMapper oMapper;

    private Mapper() {
        super();
    }

    public static Mapper getInstance() {
        if (mapper == null) {
            mapper = new Mapper();
            oMapper = new ObjectMapper();
        }
        return mapper;
    }

    public List<UUID> readUUIDList(String json) {
        try {
            return oMapper.readValue(json, new TypeReference<List<UUID>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public String write(Object o) {
        try {
            StringWriter sw = new StringWriter();
            oMapper.writer().writeValue(sw, o);
            return sw.toString();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
