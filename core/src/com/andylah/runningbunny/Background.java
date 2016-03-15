package com.andylah.runningbunny;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Background extends Actor {

	private final TextureRegion textureRegion;
	private Rectangle rectangleBackground1;
	private Rectangle rectangleBackground2;
	private float speed = 100;

	public Background() {

		textureRegion = new TextureRegion(new Texture(Gdx.files.internal(Vars.BACKGROUND_PATH)));
		rectangleBackground1 = new Rectangle(0 - Vars.APP_WIDTH / 2, 0, Vars.APP_WIDTH, Vars.APP_HEIGHT);
		rectangleBackground2 = new Rectangle(Vars.APP_WIDTH / 2, 0, Vars.APP_WIDTH, Vars.APP_HEIGHT);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);

		batch.draw(textureRegion, rectangleBackground1.x, rectangleBackground1.y, Vars.APP_WIDTH, Vars.APP_HEIGHT);
		batch.draw(textureRegion, rectangleBackground2.x, rectangleBackground2.y, Vars.APP_WIDTH, Vars.APP_HEIGHT);

	}

	@Override
	public void act(float delta) {

		if (sisiKiriTercapai(delta)) {
			resetBackground();
		} else {
			updateXBackground(-delta);
		}
	}

	private void updateXBackground(float f) {
		rectangleBackground1.x += speed * f;
		rectangleBackground2.x += speed * f;
	}

	private void resetBackground() {
		rectangleBackground1 = rectangleBackground2;
		rectangleBackground2 = new Rectangle(Vars.APP_WIDTH, 0, Vars.APP_WIDTH, Vars.APP_HEIGHT);

	}

	private boolean sisiKiriTercapai(float delta) {
		// jika sisi x dari background 1 sudah menyentuh <= 0 maka sisi kiri
		// tercapai
		return (rectangleBackground2.x - (delta * speed)) <= 0;
	}

}
