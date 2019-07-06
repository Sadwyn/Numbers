package com.poh.game;

import com.poh.playObjects.BombSquare;
import com.poh.playObjects.NumberSquare;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

public class SinglePlayerGame extends Game {
    public SinglePlayerGame(){
        this.possiblePlayObjects = new Class[100];

        for (int i = 0; i < 80; i++) {
            this.possiblePlayObjects[i] = NumberSquare.class;
        }

        for (int i = 80; i < 100; i++) {
            this.possiblePlayObjects[i] = BombSquare.class;
        }
    }

    @Override
    public void play() {
        Timer timer = new Timer();
        Timer objectTimer = new Timer();

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    String randomSquare = possiblePlayObjects[ThreadLocalRandom.current().nextInt(0, 100)].getName();
                    System.out.println("Position: " + ThreadLocalRandom.current().nextInt(0, Game.HORIZONTAL_SIZE * Game.VERTICAL_SIZE));
                    System.out.println("Possible object: " + randomSquare);

                    if (randomSquare.equals(NumberSquare.class.getName())){
                        System.out.println(NumberSquare.builder().value(ThreadLocalRandom.current().nextInt(NumberSquare.MIN_VAL, NumberSquare.MAX_VAL)).build().toString());
                    }
                }
            }, 0 , TimeUnit.SECONDS.toMillis(frequency));


        objectTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("FINISH!!");
                timer.cancel();
                objectTimer.cancel();
            }
        }, TimeUnit.SECONDS.toMillis(duration));

    }
}
