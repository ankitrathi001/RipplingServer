package org.rippling.web;

import org.rippling.apisimpl.ItemDao;
import org.rippling.dao.model.Item;
import org.rippling.web.errors.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemDao itemDao;

    @GetMapping("/items")
    List<Item> all() {
        return itemDao.getAll();
    }

    @GetMapping("/items/{id}")
    Item getById(@PathVariable Long id) {

        return itemDao.getById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }

    @PostMapping("/items")
    Item createNew(@Valid @RequestBody Item newItem) {
        return itemDao.save(newItem);
    }

    @DeleteMapping("/items/{id}")
    void delete(@PathVariable Long id) {
        itemDao.deleteById(id);
    }

    @PutMapping("/items/{id}")
    Item updateOrCreate(@RequestBody Item newItem, @PathVariable Long id) {

        return itemDao.getById(id)
                .map(item -> {
                    item.setName(newItem.getName());
                    return itemDao.save(item);
                })
                .orElseGet(() -> {
                    newItem.setId(id);
                    return itemDao.save(newItem);
                });
    }
}