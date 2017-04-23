package game.levels;

import core.Level;
import game.Background;
import game.PlayerObject;
import game.levelElements.*;

/**
 * Created by zva on 22/04/17.
 */
public class Level6 extends Level {

    private PlayerObject player = new PlayerObject();

    public Level6() {
        int floorX = 0;
        int floorY = 750;
        addGameObject(new Background(0, 0));
        addGameObject(new PlayerObject(20, 680));

        //wall
        addGameObject(new WallObject(-80, 0));
        addGameObject(new WallObject(1280, 0));

        //floor
        while (floorX < 1280) {

            addGameObject(new TileObject1(floorX, floorY));
            floorX += 64;
            addGameObject(new TileObject2(floorX, floorY));
            floorX += 64;
            addGameObject(new TileObject3(floorX, floorY));
            floorX += 64;
        }


        //walls

        addGameObject(new WallObject2(330, -100)); //left top


        addGameObject(new WallObject2(783, 195)); //bottom middle

        addGameObject(new WallObject2(975, -445)); //right top


        //platforms going up - numbered from bottom to top
        int platformX = 0;
        int platformY = 0;
        int spikeY = platformY + 32;


        //1
        platformX = 300;
        platformY = 650;
        spikeY = platformY + 32;

        addGameObject(new PlatformObject(platformX, platformY));
        addGameObject(new DownSpikesObject(platformX, spikeY)); //spikes

        //2
        platformX = 575; //left
        platformY = 575;
        spikeY = platformY + 32;
        addGameObject(new PlatformObject(platformX, platformY));

        platformX = 637; //right
        platformY = 575;
        spikeY = platformY + 32;
        addGameObject(new PlatformObject(platformX, platformY));

        //3
        platformX = 391;
        platformY = 425;
        spikeY = platformY + 32;
        addGameObject(new PlatformObject(platformX, platformY));

        //4
        platformX = 637;
        platformY = 300;
        spikeY = platformY + 32;
        addGameObject(new PlatformObject(platformX, platformY));
        addGameObject(new DownSpikesObject(platformX, spikeY)); //spikes

        //5
        platformX = 391;
        platformY = 150;
        spikeY = platformY + 32;
        addGameObject(new PlatformObject(platformX, platformY));
        addGameObject(new DownSpikesObject(platformX, spikeY)); //spikes

        //platforms going down numbered from top to bottom

        addGameObject(new PlatformObject(844, 350)); //1

        //1
        platformX = 844;
        platformY = 350;
        spikeY = platformY - 23;

        addGameObject(new PlatformObject(platformX, platformY));
        addGameObject(new UpSpikesObject(platformX, spikeY)); //spikes on top


        //2
        platformX = 1050;
        platformY = 540;
        spikeY = platformY - 23;

        addGameObject(new PlatformObject(platformX, platformY));
        addGameObject(new UpSpikesObject(platformX, spikeY)); //spikes on top

        //spikes (no platform) 3
        platformX = 844;
        spikeY = floorY - 23;


        addGameObject(new UpSpikesObject(platformX, spikeY)); //spikes on top

        //spikes at top of screen
        int spikeX = 391;
        spikeY = 0;

        while (spikeX < 975) {
            addGameObject(new DownSpikesObject(spikeX, spikeY)); //spikes

        spikeX += 146;
    }

        //portal

        addGameObject(new PortalObject(1150, 615, null));
    }




}

