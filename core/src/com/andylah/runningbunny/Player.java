package com.andylah.runningbunny;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;

public class Player extends GameActor {

	public static final String TAG = GameStage.class.getName();
	private boolean jumping, dodging, hit;

	public Player(Body body) {
		super(body);

	}

	@Override
	public PlayerUserData getUserData() {

		return (PlayerUserData) userData;
	}

	public void jump() {
		if (!jumping || !dodging || !hit) {
			body.applyLinearImpulse(getUserData().getJumpingLinierImpulse(), body.getWorldCenter(), true);
			jumping = true;
		}
	}

	public void dodge() {
		if (!jumping || !hit) {
			body.setTransform(getUserData().getDodgePosition(), getUserData().getDodgeAngle());
			dodging = true;
		}
	}

	public void landed() {
		jumping = false;
		//Gdx.app.log(TAG, ": jumping = false");
	}

	public void stopDodging() {
		dodging = false;

		// jika bunny ke hit jangan kembali ke posisi berdiri
		if (!hit) {
			body.setTransform(getUserData().getStandPosition(), 0f);
		}
	}

	public boolean isDodging() {
		return dodging;
	}

	public void hit() {
		body.applyAngularImpulse(getUserData().getHitAngularImpulse(), true);
		hit = true;
	}

	public boolean isHit() {
		return hit;
	}
}
