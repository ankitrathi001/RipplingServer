package org.rippling.apisimpl;

import org.rippling.apis.Dao;
import org.rippling.dao.model.Item;
import org.rippling.dao.model.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemDao implements Dao<Item> {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public Optional<Item> getById(long id) {
        return itemRepository.findById(id);
    }

    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void update(Item item, String[] params) {
        itemRepository.save(item);
    }

    @Override
    public void deleteById(long id) {
        itemRepository.deleteById(id);
    }
}
