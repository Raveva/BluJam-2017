package game.levels;

import core.Level;
import game.Background;
import game.PlayerObject;
import game.levelElements.*;

/**
 * Created by Sam on 22/04/17.
 */
public class Level5 extends Level {

    private PlayerObject player = new PlayerObject();

    public Level5() {
        int floorX = 0;
        addGameObject(new Background(0, 0));
        addGameObject(new PlayerObject(20,680));

        //wall
        addGameObject(new WallObject(-80, 0));
        addGameObject(new WallObject(1280, 0));

        //wall
        addGameObject(new WallObject2(300, -80));
        addGameObject(new WallObject2(300, 670));
        addGameObject(new WallObject2(700, 350));
        addGameObject(new WallObject2(700, -400));
        addGameObject(new WallObject2(1100, -250));

        //floor
        while (floorX < 1280) {

            addGameObject(new TileObject1(floorX, 750));
            floorX += 64;
            addGameObject(new TileObject2(floorX, 750));
            floorX += 64;
            addGameObject(new TileObject3(floorX, 750));
            floorX += 64;
        }

        //platform
        addGameObject(new PlatformObject(555, 600));
        addGameObject(new PlatformObject(360, 700));
        addGameObject(new PlatformObject(360, 450));
        addGameObject(new PlatformObject(955, 100));
        addGameObject(new PlatformObject(760, 400));
        addGameObject(new PlatformObject(760, 195));
        addGameObject(new PlatformObject(955, 290));

        //spikes
        addGameObject(new UpSpikesObject(760, 728));
        addGameObject(new UpSpikesObject(906, 728));
        addGameObject(new UpSpikesObject(1052, 728));
        addGameObject(new UpSpikesObject(1198, 728));


        //portal
        addGameObject(new PortalObject(1030, 0));





    }


    /**

     //addGameObject(new PlatformObject(5, 200));
     //addGameObject(new SpikesObject(5, 232));
     //addGameObject(new SpikesObject2(50, 300));
     //addGameObject(new BoxObject(400, 300));
     }*/
}
