package main.job;

import org.springframework.batch.item.ItemReader;


public class AsyncItemReader implements ItemReader<Character> {
    private char[] base;

    private int currentIndex = 0;

    public AsyncItemReader(String base){
        this.base = base.toCharArray();
        currentIndex = 0;
    }

    @Override
    public synchronized Character read()  {
        if(base.length > currentIndex){
            return base[currentIndex++];
        }else return null;
    }
}
