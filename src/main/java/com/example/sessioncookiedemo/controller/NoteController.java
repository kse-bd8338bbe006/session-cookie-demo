package com.example.sessioncookiedemo.controller;

import com.example.sessioncookiedemo.entity.Note;
import com.example.sessioncookiedemo.repository.NoteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Optional;

@Controller
public class NoteController {

    private final NoteRepository noteRepository;

    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @GetMapping("/notes")
    public String listNotes(Model model, Principal principal) {
        model.addAttribute("notes", noteRepository.findByOwnerOrderByCreatedAtDesc(principal.getName()));
        model.addAttribute("username", principal.getName());
        return "notes";
    }

    @PostMapping("/notes")
    public String createNote(@RequestParam String title,
                             @RequestParam String content,
                             Principal principal) {
        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);
        note.setOwner(principal.getName());
        noteRepository.save(note);
        return "redirect:/notes";
    }

    @PostMapping("/notes/delete")
    public String deleteNote(@RequestParam Long id, Principal principal) {
        Optional<Note> note = noteRepository.findById(id);
        if (note.isPresent() && note.get().getOwner().equals(principal.getName())) {
            noteRepository.deleteById(id);
        }
        return "redirect:/notes";
    }
}
