package com.sidorded.springgoit.entity;

import com.sidorded.springgoit.service.NoteService;
import lombok.Data;

import java.util.Random;

@Data
public class Note {
    private long id;
    private String title;
    private String content;

    public Note() {
        this.id = generateRandomId();
    }

    public Note(String title, String content) {
        this.id = generateRandomId();
        this.title = title;
        this.content = content;
    }

    public Note(long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    private long generateRandomId() {
        NoteService noteService = new NoteService();

        Random random = new Random();
        long id = random.nextLong(1000000000) + 1;

        while (noteService.listAll().containsKey(id)) {
            id = random.nextLong(1000000000) + 1;
        }

        return id;
    }


}