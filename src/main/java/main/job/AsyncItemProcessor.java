package main.job;

import org.springframework.batch.item.ItemProcessor;

public class AsyncItemProcessor implements ItemProcessor<Character, Character> {

    public AsyncItemProcessor() {

    }

    @Override
    public Character process(Character character) throws Exception {
        Thread current = Thread.currentThread();
        System.out.println(character + " - printed by: " + current.getName());
        return character;
    }
}
