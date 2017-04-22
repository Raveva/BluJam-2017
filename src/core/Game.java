package core;

import game.levels.Level2;
import game.menu.MenuLevel;
import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;

public class Game extends PApplet {

    private Level currentLevel;


    public void mousePressed() {
        InputHandler.addEvent(new MouseEvent(this, mouseX, mouseY, MouseEvent.Type.PRESS));
    }

    public void mouseReleased() {
        InputHandler.addEvent(new MouseEvent(this, mouseX, mouseY, MouseEvent.Type.RELEASE));
    }

    public void keyPressed() {
        Debug.print(keyCode);
        InputHandler.keyDown.put(keyCode, true);
    }

    public void keyReleased() {
        Debug.print(keyCode);
        InputHandler.keyDown.put(keyCode, false);
    }

    public void changeLevel(Level level) {
        currentLevel = level;
    }

    public void settings() {
        size(1280, 832);
    }




    public void setup() {
        //background image

        AssetHandler.addAsset("titlepage.png", this); //1280x832

        AssetHandler.addAsset("bg (1).png", this); //1280x832

        //PGraphics testGraphic = createGraphics(32, 32);
        //testGraphic.beginDraw();
        //testGraphic.fill(100);
        //testGraphic.rect(0, 0, 32, 32);
        //testGraphic.endDraw();

       // Asset testAsset = new Asset("test", testGraphic);
        //AssetHandler.assets.put(testAsset.name, testAsset);

        PImage test = loadImage("blue.png");
        Asset testAsset = new Asset("test", test);
        AssetHandler.assets.put(testAsset.name, testAsset);

        AssetHandler.addAsset("blue.png", this); //70x33

         PGraphics t =  createGraphics(40, 10);
        t.beginDraw();
        t.fill(255, 0, 0);
        t.rect(0,0,40, 10);
        t.endDraw();
        Asset ta = new Asset("platform.png", t);
        AssetHandler.assets.put(ta.name, ta);

       //Object stuff
        AssetHandler.addAsset("platform.png", this); //146x32
        AssetHandler.addAsset("wall.png", this); //81x832
        AssetHandler.addAsset("wall (1).png", this); //61x640
        AssetHandler.addAsset("tile1.png", this); //64x64
        AssetHandler.addAsset("tile2.png", this); //64x64
        AssetHandler.addAsset("tile3.png", this); //64x64
        AssetHandler.addAsset("spikes (1).png", this); //146x23
        AssetHandler.addAsset("spikes (2).png", this); //146x23
        AssetHandler.addAsset("boxtile.png", this); //64x64


        //menu
        AssetHandler.addAsset("title.png", this); //626x300
        AssetHandler.addAsset("playbutton.png", this); //378x81
        AssetHandler.addAsset("exitbutton.png", this); //378x81


        //audio
        //AudioHandler.loadAudioFile("biotone.wav", this);
        //AudioHandler.playAudioFile("biotone.wav");

        currentLevel = new Level2();

    }

    float x = 0;
    float delta = 1;
    PImage img;

    boolean paused = false;
    long pastNano = System.nanoTime();
    public void draw() {

        long elapsedNano = System.nanoTime() - pastNano;
        background(255);
        if (!paused) {
            currentLevel.update(elapsedNano / (float)1000000);
            pastNano = System.nanoTime();
            render(currentLevel);
        }

        InputHandler.clearEvents();
    }

    public void render(Level level) {
        for (GameObject obj : level.getGameObjects()) {
            image(obj.getAsset().image, obj.getPosition().x, obj.getPosition().y);
        }
    }

    public void run() {
        // could probably put in draw tbh..
        //while true
            // while (playing level)
                // simulate all the stuff in the level (update(dt) i guess).
                // render the level render(level)
            // render the ui

    }

    public static void main(String[] args) {
        PApplet.main("core.Game");
    }
}
