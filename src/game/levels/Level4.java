package game.levels;

import core.Level;
import game.Background;
import game.PlayerObject;
import game.levelElements.*;

/**
 * Created by sam on 23/04/17.
 */
public class Level4 extends Level {

    private PlayerObject player = new PlayerObject();

    public Level4() {
        int floorX = 0;
        addGameObject(new Background(0, 0));
        addGameObject(new PlayerObject(20,680));

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


        addGameObject(new PlatformObject(1050, 600));
        addGameObject(new PlatformObject(800, 600));
        addGameObject(new PlatformObject(550, 600));
        addGameObject(new PlatformObject(300, 600));
        addGameObject(new PlatformObject(200, 630));

        //spikes

        addGameObject(new UpSpikesObject(300, 728));
        addGameObject(new UpSpikesObject(198, 728));
        addGameObject(new UpSpikesObject(550, 728));
        addGameObject(new UpSpikesObject(800, 728));
        addGameObject(new UpSpikesObject(1050, 728));


        //portal
        addGameObject(new PortalObjectFlip(1125, 480));

    }


    /**

     //addGameObject(new PlatformObject(5, 200));
     //addGameObject(new SpikesObject(5, 232));
     //addGameObject(new SpikesObject2(50, 300));
     //addGameObject(new BoxObject(400, 300));
     }*/
}
