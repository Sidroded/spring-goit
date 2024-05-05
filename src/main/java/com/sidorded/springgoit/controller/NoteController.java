package com.sidorded.springgoit.controller;

import com.sidorded.springgoit.entity.Note;
import com.sidorded.springgoit.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/note/list")
    public String getAllNotes(Model model) {
        List<Note> notes = noteService.listAll();
        model.addAttribute( "notes", notes);
        return "note-list";
    }

    @PostMapping("/note/delete")
    public String deleteNote(@RequestParam("id") Long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping("/note/edit")
    public String getNoteEditPage(@RequestParam("id") Long id, Model model) {
        Note note = noteService.getById(id);
        model.addAttribute("note", note);
        return "note-edit";
    }

    @PostMapping("/note/edit")
    public String saveEditNote(@RequestParam("id") Long id,  @RequestParam String title, @RequestParam String content) {
        Note note = new Note(id, title, content);
        noteService.update(note);
        return "redirect:/note/list";
    }
}
