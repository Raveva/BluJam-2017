package game.menu;

import core.Level;
import game.Background;
import game.levelElements.PortalObject;

/**
 * Created by sam on 23/04/17.
 */

public class NextLevelMenu extends Level {

    //private PlayerObject player = new PlayerObject();

    public NextLevelMenu() {

      //  addGameObject(new TitleObject(380, 100));
        addGameObject(new NextLevelButtonObject(450, 450));
        addGameObject(new ExitToMainButtonObject(450, 550));



    }

}