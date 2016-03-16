package com.andylah.runningbunny;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;

public class Player extends GameActor {

	public static final String TAG = GameStage.class.getName();
	private boolean jumping, dodging, hit;
	private TextureAtlas textureAtlas;
	private Animation runningAnimation;
	private TextureRegion jumpingTexture;
	private TextureRegion slideTexture;
	private TextureRegion hitTexture;
	private float stateTime;

	public Player(Body body) {
		super(body);

		// load images ke player body
		textureAtlas = new TextureAtlas(Gdx.files.internal(Vars.CHARACTER_ATLAS));
		TextureRegion[] runningFrames = new TextureRegion[Vars.RUNNING_CHARACTER_SET.length];
		for (int i = 0; i < Vars.RUNNING_CHARACTER_SET.length; i++) {
			String path = Vars.RUNNING_CHARACTER_SET[i];
			runningFrames[i] = textureAtlas.findRegion(path);
		}
		runningAnimation = new Animation(0.1f, runningFrames);

		// load jumping texture
		jumpingTexture = textureAtlas.findRegion(Vars.JUMPING_CHARACTER);

		// load dodging texture
		slideTexture = textureAtlas.findRegion(Vars.DODGING_CHARACTER);

		// load hit texture
		hitTexture = textureAtlas.findRegion(Vars.HIT_CHARACTER);

		stateTime = 0f;
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);

		if (dodging) {
			batch.draw(slideTexture, screenRectangle.x, screenRectangle.y + screenRectangle.getHeight() / 4,
					screenRectangle.width + 5, screenRectangle.height * 3 / 4);
		} else if (hit) {
			batch.draw(hitTexture, screenRectangle.x, screenRectangle.y, screenRectangle.width * 0.5f,
					screenRectangle.height * 0.5f, screenRectangle.width, screenRectangle.height, 1f, 1f,
					(float) Math.toDegrees(body.getAngle()));
		} else if (jumping) {
			batch.draw(jumpingTexture, screenRectangle.x, screenRectangle.y, screenRectangle.width,
					screenRectangle.height);
		} else {

			stateTime += Gdx.graphics.getDeltaTime();
			batch.draw(runningAnimation.getKeyFrame(stateTime, true), screenRectangle.x, screenRectangle.y,
					screenRectangle.width, screenRectangle.height);
		}

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
		// Gdx.app.log(TAG, ": jumping = false");
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
