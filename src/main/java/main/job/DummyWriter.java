package main.job;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class DummyWriter implements ItemWriter<Character> {


    @Override
    public void write(List<? extends Character> list) {
    }
}
