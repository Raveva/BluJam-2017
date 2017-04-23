package game.levels;

import core.Level;
import game.Background;
import game.PlayerObject;
import game.levelElements.*;

/**
 * Created by sam on 23/04/17.
 */
public class Level7 extends Level {

    private PlayerObject player = new PlayerObject();

    public Level7() {
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


        addGameObject(new PlatformObject(360, 450));
        addGameObject(new PlatformObject(500, 195));
        addGameObject(new PlatformObject(700, 195));
        addGameObject(new PlatformObject(300, 195));
        addGameObject(new PlatformObject(100, 195));
        addGameObject(new PlatformObject(760, 195));
        addGameObject(new PlatformObject(955, 290));

        //spikes

        addGameObject(new UpSpikesObject(906, 728));
        addGameObject(new UpSpikesObject(1052, 728));
        addGameObject(new UpSpikesObject(1198, 728));

        //box
        addGameObject(new BoxObject(842, 750));
        addGameObject(new BoxObject(842, 686));
        addGameObject(new BoxObject(842, 622));
        addGameObject(new BoxObject(842, 558));
        addGameObject(new BoxObject(842, 494));
        addGameObject(new TileObject1(842, 430));

        addGameObject(new BoxObject(778, 750));
        addGameObject(new BoxObject(778, 686));
        addGameObject(new BoxObject(778, 622));
        addGameObject(new BoxObject(778, 558));
        addGameObject(new TileObject3(778, 494));

        addGameObject(new BoxObject(714, 750));
        addGameObject(new BoxObject(714, 686));
        addGameObject(new BoxObject(714, 622));
        addGameObject(new BoxObject(714, 558));
        addGameObject(new TileObject2(714, 494));

        addGameObject(new BoxObject(650, 750));
        addGameObject(new BoxObject(650, 686));
        addGameObject(new TileObject3(650, 622));

        addGameObject(new BoxObject(586, 750));
        addGameObject(new BoxObject(586, 686));
        addGameObject(new TileObject2(586, 622));

        addGameObject(new BoxObject(522, 750));
        addGameObject(new BoxObject(522, 686));
        addGameObject(new TileObject1(522, 622));

        addGameObject(new BoxObject(458, 750));
        addGameObject(new TileObject1(458, 686));

        addGameObject(new BoxObject(394, 750));
        addGameObject(new TileObject3(394, 686));

        addGameObject(new BoxObject(330, 750));
        addGameObject(new TileObject2(330, 686));

        addGameObject(new BoxObject(266, 750));
        addGameObject(new TileObject1(266, 686));


        //portal
        addGameObject(new PortalObjectFlip(90, 70));

    }


    /**

     //addGameObject(new PlatformObject(5, 200));
     //addGameObject(new SpikesObject(5, 232));
     //addGameObject(new SpikesObject2(50, 300));
     //addGameObject(new BoxObject(400, 300));
     }*/
}
