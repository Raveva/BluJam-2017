package core.components;

import core.Debug;
import core.Game;
import core.GameObject;
import game.levelElements.PortalObject;
import processing.core.PVector;

import java.util.Collection;
import java.util.Stack;

/**
 * Created by zva on 21/04/17.
 */
public class PhysicsComponent<T extends GameObject & Physicable & Collidable> {

    public static float gravityStrength = 1;

    private boolean gravity = true;
    private boolean drag = true;

    T obj;
    float mass;
    float dragCoefficent = 0.3f;

    public PVector velocity = new PVector(0, 0);
    PVector acceleration = new PVector(0, 0);
    PVector netForce = new PVector(0, 0);

    private Stack<PVector> forces = new Stack<>();

    public PhysicsComponent(T obj) {
        this.obj = obj;
        this.mass = 1;
    }

    public PhysicsComponent(T obj, float mass) {
        this.obj = obj;
        this.mass = mass;
    }

    public void setGravity(boolean gravity) {
        this.gravity = gravity;
    }

    public void setDrag(boolean drag) {
        this.drag = drag;
    }

    private PVector getNetForce() {
        PVector netForce;
        if (!forces.isEmpty()) {
            netForce = forces.pop();
            while (!forces.isEmpty()) {
                netForce.add(forces.pop());
            }
        } else {
            netForce = new PVector(0, 0);
        }

        if (gravity) {
            netForce.add(new PVector(0, gravityStrength));
        }

        if (drag) {
            netForce.add(new PVector(velocity.x, velocity.y).mult(-dragCoefficent));
        }

        return netForce;
    }

    public void addForce(PVector force) {
        forces.add(force);
    }

    private void resolveCollision() {
        ColliderComponent collider = obj.getCollider();
        if (collider.hasCollided()) {

            PVector normal = collider.getNormal();
            netForce.add(normal.x * netForce.x, normal.y * netForce.y);
            if (Math.abs(normal.y) > 0.5f) {
                if (velocity.y > 0) {
                    velocity.set(velocity.x, 0);
                }
            }
            if (Math.abs(normal.x) > 0.5f) {
                velocity.set(0, velocity.y);
            }

            //while (collider.collidesWith(collider.getCollidedWith())) {
            Debug.print("Bump");
            obj.getPosition().add(normal);
            //}
        }
    }

    public void setVelocity(PVector p) {
        velocity = p;
    }

    public void update(float dt) {

        /*
        netForce = getNetForce();
        resolveCollision();

        acceleration = netForce.div(mass);
        velocity.add(acceleration);
        PVector deltaPosition = new PVector(velocity.x, velocity.y).mult(dt/100);
        */

        obj.getPosition().add(velocity);
        Collidable c;
        if ((c = obj.getCollider().level.collides(obj)) != null) {

            if (c instanceof PortalObject) {
                Debug.print("Coll?");
                Game.changeLevel(((PortalObject) c).next);
            }


            obj.getPosition().sub(velocity.x * 2, velocity.y * 2);
        }

    }
}
