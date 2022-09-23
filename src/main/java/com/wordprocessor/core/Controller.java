package com.wordprocessor.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class Controller {

    @Autowired
    private EntryDao entryDao;
    @Autowired
    private Sender sender;
    private EntryDTO entryDTO;

    @GetMapping("/{id}")
    @CrossOrigin()
    public Entry entry(@PathVariable UUID id) throws JsonProcessingException {
        entryDTO = entryDao.getEntryForId(id);
        return new Entry(entryDTO.getId(), jsonToObject(entryDTO.getCount()));
    }

    @PostMapping("/")
    @CrossOrigin()
    public String postEntry(@RequestBody Input input) {
        return sender.send(input.getText());
    }

    private Object jsonToObject(String json) throws JsonProcessingException {
        return new ObjectMapper().readValue(json, Object.class);
    }

}
