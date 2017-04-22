package core;

/**
 * Created by zva on 23/04/17.
 */
public class MouseEvent {
    public enum Type {
        PRESS, RELEASE
    }
    public final Game game;
    public final Type type;
    public final float x;
    public final float y;

    public MouseEvent(Game game, float x, float y, Type type) {
        this.game = game;
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("x: ");sb.append(x);
        sb.append(" y: ");sb.append(y);
        sb.append(" type: ");sb.append(type.toString());
        return sb.toString();
    }
}
