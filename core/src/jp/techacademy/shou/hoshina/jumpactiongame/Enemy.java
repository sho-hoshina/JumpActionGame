package jp.techacademy.shou.hoshina.jumpactiongame;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by kuro on 2017/09/23.
 */

public class Enemy extends GameObject{
    // 横幅、高さ
    public static final float UFO_WIDTH = 1.0f;
    public static final float UFO_HEIGHT = 0.65f;

    // タイプ（通常と動くタイプ）
    public static final int STEP_TYPE_STATIC = 0;
    public static final int STEP_TYPE_MOVING = 1;

    // 速度
    public static final float STEP_VELOCITY = 1.0f;

    int mType;

    public Enemy(int type, Texture texture, int srcX, int srcY, int srcWidth, int srcHeight) {
        super(texture, srcX, srcY, srcWidth, srcHeight);
        setSize(UFO_WIDTH, UFO_HEIGHT);

        mType = type;
        if (mType == STEP_TYPE_MOVING) {
            velocity.x = STEP_VELOCITY;
        }
    }

    // 座標を更新する
    public void update(float deltaTime) {
        if (mType == STEP_TYPE_MOVING) {
            setX(getX() + velocity.x * deltaTime);

            if (getX() < UFO_WIDTH / 2) {
                velocity.x = -velocity.x;
                setX(UFO_WIDTH / 2);
            }
            if (getX() > GameScreen.WORLD_WIDTH - UFO_WIDTH / 2) {
                velocity.x = -velocity.x;
                setX(GameScreen.WORLD_WIDTH - UFO_WIDTH / 2);
            }
        }
    }

}
