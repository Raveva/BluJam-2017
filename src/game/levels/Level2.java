package game.levels;

import core.Debug;
import core.Level;
import game.Background;
import game.PlayerObject;
import game.levelElements.*;

/**
 * Created by zva on 22/04/17.
 */
public class Level2 extends Level {

    private PlayerObject player = new PlayerObject();

    public Level2() {
        Debug.print("message");

        int floorX = 0;
        int floorY = 750;
        int tileWidth = 64;


        addGameObject(new Background(0, 0));
        addGameObject(new PlayerObject(20,680));


        //wall
        addGameObject(new WallObject(-80, 0));
        addGameObject(new WallObject(1280, 0));

        //floor
        while (floorX < 400) {

            addGameObject(new TileObject1(floorX, floorY));
            floorX += tileWidth;
            addGameObject(new TileObject2(floorX, floorY));
            floorX += tileWidth;
            addGameObject(new TileObject3(floorX, floorY));
            floorX += tileWidth;
        }

        //box
        //abstraction - grouping? potential to expand in future

        int tileX = 400;
        int tileY = floorY;
        int boxStart = 400;



        //box - layer 1 ( bottom )
        while (tileX < 1280) {
            addGameObject(new BoxObject(tileX, tileY));
            tileX += tileWidth;

            addGameObject(new BoxObject(tileX, tileY));
            tileX += tileWidth;

            addGameObject(new BoxObject(tileX, tileY));
            tileX += tileWidth;
        }

        tileX = boxStart;
        tileY -= tileWidth;

        // layer 1 tile on box
        addGameObject(new TileObject1(tileX, tileY));

        //box - layer 2
        tileX += tileWidth;


        while (tileX < 1280) {
            addGameObject(new BoxObject(tileX, tileY));
            tileX += tileWidth;

            addGameObject(new BoxObject(tileX, tileY));
            tileX += tileWidth;

            addGameObject(new BoxObject(tileX, tileY));
            tileX += tileWidth;
        }
        // layer 2 tile on box
        addGameObject(new TileObject1(tileX, (tileY - tileWidth)));


        //tiles until 848
        tileX = boxStart + tileWidth;
        tileY = floorY - (tileWidth*2);

        while (tileX < 1280) {
            addGameObject(new TileObject1(tileX, tileY));
            tileX += tileWidth;

            addGameObject(new TileObject2(tileX, tileY));
            tileX += tileWidth;

            addGameObject(new TileObject3(tileX, tileY));
            tileX += tileWidth;
        }

        //portal
        addGameObject(new PortalObject(1100, 475, new Level6()));


}
}
