package game.levels;

import core.Level;
import game.Background;
import game.PlayerObject;
import game.levelElements.*;

/**
 * Created by zva on 22/04/17.
 */
public class Level8 extends Level {

    private PlayerObject player = new PlayerObject();

    public Level8() {
        int floorX = 0;
        addGameObject(new Background(0, 0));

        addGameObject(new PortalObject(1160, 630, new Level9()));
        addGameObject(new PlayerObject(20, 680));

        //wall
        addGameObject(new WallObject(-80, 0));
        addGameObject(new WallObject(1280, 0));


        //floor

        while (floorX < 1280) {

            addGameObject(new TileObject1(floorX, 750));
            floorX += 64;
            addGameObject(new TileObject2(floorX, 750));
            floorX += 64;
            addGameObject(new TileObject3(floorX, 750));
            floorX += 64;


        }


    }



    /**

     //addGameObject(new PlatformObject(5, 200));
     //addGameObject(new DownSpikesObject(5, 232));
     //addGameObject(new UpSpikesObject(50, 300));
     //addGameObject(new BoxObject(400, 300));
     }*/
}
