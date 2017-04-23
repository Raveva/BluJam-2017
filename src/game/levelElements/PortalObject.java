package game.levelElements;

import core.*;
import core.components.Collidable;
import core.components.ColliderComponent;
import game.PlayerObject;
import game.levels.Level1;

/**
 * Created by zva on 23/04/17.
 */
public class PortalObject extends GameObject implements Collidable {

    private ColliderComponent collider = new ColliderComponent(this, 64, 64);
    public ColliderComponent getCollider() {return collider;}

    private Asset[] assets = new Asset[8];
    private int currentAssetIndex = 0;
    private float frameTime = 60;
    private float timeAccumulator = 0;

    public Level next;

    public PortalObject(float x, float y, Level next) {
        this.next = next;
        position.x = x;
        position.y = y;

        for (int i = 0; i < 8; i++) {
            assets[i] = AssetHandler.getAsset("portal-"+(i+1)+".png");
        }
    }

    @Override
    public Asset getAsset() {
        return assets[currentAssetIndex];
    }

    @Override
    public void update(float dt) {
        timeAccumulator += dt;
        if (timeAccumulator > frameTime) {
            currentAssetIndex = (currentAssetIndex+1)%8;
            timeAccumulator -= frameTime;
        }

        if (collider.hasCollided()) {
            Collidable obj = collider.getCollidedWith();
            if (obj instanceof PlayerObject) {
                Game.changeLevel(next);
            }
        }
    }
}
