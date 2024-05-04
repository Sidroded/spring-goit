package com.sidorded.springgoit.service;

import com.sidorded.springgoit.entity.Note;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class NoteService {

    private Map<Long, Note> notes = new HashMap<>();

    @Autowired
    public NoteService() {
    }

    @PostConstruct
    private void initialize() {
        fillNotes();
    }

    public Map<Long, Note> listAll() {
        return notes;
    }

    public Note addNote(Note note) {
        notes.put(note.getId(), note);
        return note;
    }

    public void deleteById(long id) {
        if (notes.containsKey(id)) {
           notes.remove(id);
        } else {
            throw new NullPointerException("No notes with id " + id);
        }
    }

    public void update(Note note) {
        if (notes.containsKey(note.getId())) {
            notes.put(note.getId(), note);
        } else {
            throw new NullPointerException("No notes with id " + note.getId());
        }
    }

    public Note getById(long id) {
        if (notes.containsKey(id)) {
           return notes.get(id);
        } else {
            throw new NullPointerException("No notes with id " + id);
        }
    }

    private void fillNotes() {
        for (int i = 0; i < 10; i++) {
            addNote(new Note("title" + i, "content" + i));
        }
    }
}
