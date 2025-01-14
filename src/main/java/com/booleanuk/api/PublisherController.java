package com.booleanuk.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/publishers")
public class PublisherController {
    private ArrayList<Publisher> publishers;

    public PublisherController() {
        this.publishers = new ArrayList<>();

        this.publishers.add(new Publisher("JRR Tolkien", "Stockholm"));
        this.publishers.add(new Publisher("Jane Austen", "San Diego"));
    }

    @GetMapping
    public ArrayList<Publisher> getPublishers() {
        return publishers;
    }

    @GetMapping("/{id}")
    public Publisher getOne(@PathVariable int id) {
        if (id < this.publishers.size()) {
            return this.publishers.get(id);
        }
        return null;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher create(@RequestBody Publisher publisher) {
        if (!publishers.contains(publisher)) {
            if (publisher.getName() != null && publisher.getCity() != null) {
                this.publishers.add(publisher);
                return publisher;
            } else {
                return null;
            }
        }
        return null;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher update(@PathVariable int id, @RequestBody Publisher author) {
        if (id < this.publishers.size()) {
            this.publishers.get(id).setName(author.getName());
            this.publishers.get(id).setCity(author.getCity());
            return this.publishers.get(id);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Publisher delete(@PathVariable int id) {
        if (id < this.publishers.size()) {
            return this.publishers.remove(id);
        }
        return null;
    }
}
