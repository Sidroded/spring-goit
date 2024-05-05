package com.sidorded.springgoit.service;

import com.sidorded.springgoit.entity.Note;
import com.sidorded.springgoit.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository notes;

    @Autowired
    public NoteService() {
    }

    public List<Note> listAll() {
        return notes.findAll();
    }

    public Note addNote(Note note) {
        notes.save(note);
        return note;
    }

    public void deleteById(long id) {
        try {
            notes.deleteById(id);
        } catch (Exception e){
            throw new NullPointerException("No notes with id " + id);
        }
    }

    public void update(Note note) {
        try {
            notes.save(note);
        } catch (Exception e) {
            throw new NullPointerException("No notes with id " + note.getId());
        }
    }

    public Note getById(long id) {
        try {
           return notes.getReferenceById(id);
        } catch (Exception e) {
            throw new NullPointerException("No notes with id " + id);
        }
    }
}
