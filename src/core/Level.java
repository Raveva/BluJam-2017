package core;

import core.components.Collidable;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by zva on 22/04/17.
 */
public class Level {
    private Collection<GameObject> gameObjects = new ArrayList<>();
    private List<Collidable> collidables = new ArrayList<>();

    Collection<GameObject> getGameObjects() {
        return gameObjects;
    }

    public Level() {

    }

    public void addGameObject(GameObject obj) {
        gameObjects.add(obj);
        if (obj instanceof Collidable) {
            collidables.add((Collidable)obj);
            ((Collidable) obj).getCollider().setLevel(this);
        }
    }

    void update(float dt) {
        findCollisions();
        for (GameObject obj : gameObjects) {
            obj.update(dt);
        }
        for (Collidable c : collidables) {
            c.getCollider().clear();
        }
    }

    private void findCollisions() {
        for (int i = 0; i < collidables.size(); i++) {

            Collidable obj = collidables.get(i);

            for (int j = i+1; j < collidables.size(); j++) {
                Collidable objToCheck = collidables.get(j);
                if (obj.getCollider().collidesWith(objToCheck)) {
                    obj.getCollider().setCollidedWith(objToCheck);

                    break;
                }
            }
        }
    }

    public Collidable collides(Collidable obj) {
        for (Collidable c : collidables) {
            if (c == obj) {continue;}
            else {
                if (obj.getCollider().collidesWith(c)) {
                    return c;
                }
            }
        }
        return null;
    }

    public Level(File levelFile) {

    }
}
