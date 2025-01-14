package org.rippling;

import org.rippling.dao.model.Item;
import org.rippling.dao.model.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Autowired
    ItemRepository itemRepository;


    @Override
    public void run(String... args) throws Exception {
        itemRepository.save(new Item(null, "Item 1", "4806462049"));
        itemRepository.save(new Item(null, "Item 2", "5108508386"));
    }
}