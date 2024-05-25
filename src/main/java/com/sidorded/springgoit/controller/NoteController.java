package com.sidorded.springgoit.controller;

import com.sidorded.springgoit.entity.Note;
import com.sidorded.springgoit.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.listAll();
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable Long id) {
        return noteService.getById(id);
    }

    @PutMapping("/{id}")
    public void updateNote(@PathVariable Long id, @RequestBody Note note) {
        note.setId(id);
        noteService.update(note);
    }

    @PostMapping
    public Note createNote(@RequestBody Note note) {
        return noteService.addNote(note);
    }
}
