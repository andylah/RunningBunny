package com.andylah.runningbunny;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameStage extends Stage implements ContactListener {

	public static final String TAG = GameStage.class.getName();

	private World world;

	private OrthographicCamera gameCam;
	private Box2DDebugRenderer b2dr;

	private float accumulator = 0;

	private Player bunny;
	private Ground ground;

	private Vector3 touchPoint;
	private Rectangle rightScreen;
	private Rectangle leftScreen;

	public GameStage() {
		super();
		setupCamera();
		b2dr = new Box2DDebugRenderer();

		// setup world
		world = new World(new Vector2(0, -10), true);

		// setup controller
		setupTouchArea();

		// setup world komponen
		createGround();
		createPlayer();

		// setup contact listener
		world.setContactListener(this);

	}

	private void setupTouchArea() {
		touchPoint = new Vector3();
		rightScreen = new Rectangle(getCamera().viewportWidth / 2, 0, getCamera().viewportWidth / 2,
				getCamera().viewportHeight);
		leftScreen = new Rectangle(0, 0, getCamera().viewportWidth / 2, getCamera().viewportHeight);
		Gdx.input.setInputProcessor(this);

	}

	private void createPlayer() {
		bunny = new Player(GameUtils.createBunny(world));
		addActor(bunny);

	}

	private void createGround() {
		ground = new Ground(GameUtils.createGround(world));
		addActor(ground);

	}

	private void setupCamera() {
		gameCam = new OrthographicCamera(Vars.VIEWPORT_WIDTH, Vars.VIEWPORT_HEIGHT);
		gameCam.position.set(gameCam.viewportWidth / 2, gameCam.viewportHeight / 2, 0);
		gameCam.update();

	}

	@Override
	public void draw() {
		super.draw();
		b2dr.render(world, gameCam.combined);
	}

	@Override
	public void act(float delta) {
		super.act(delta);

		// fixed timestamp
		accumulator += delta;

		while (accumulator >= delta) {
			world.step(Vars.TIME_STEP, 6, 2);
			accumulator -= Vars.TIME_STEP;
		}
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {

		// need to get the actual coordinates
		translateWorldToScreenCoordinates(screenX, screenY);

		if (rightScreenTouched(touchPoint.x, touchPoint.y)) {
			bunny.jump();
			Gdx.app.log(TAG, ": jumping = true");

		} else if (leftScreenTouched(touchPoint.x, touchPoint.y)) {
			bunny.dodge();
			Gdx.app.log(TAG, ": dodge = true");
		}

		return super.touchDown(screenX, screenY, pointer, button);

	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if (bunny.isDodging()) {
			bunny.stopDodging();
			Gdx.app.log(TAG, ": dodge = false");
		}

		return super.touchUp(screenX, screenY, pointer, button);
	}

	private boolean rightScreenTouched(float x, float y) {
		return rightScreen.contains(x, y);
	}

	private boolean leftScreenTouched(float x, float y) {
		return leftScreen.contains(x, y);
	}

	private void translateWorldToScreenCoordinates(int screenX, int screenY) {
		getCamera().unproject(touchPoint.set(screenX, screenY, 0));

	}

	@Override
	public void beginContact(Contact contact) {

		Body a = contact.getFixtureA().getBody();
		Body b = contact.getFixtureB().getBody();

		if ((GameUtils.bodyIsBunny(a) && GameUtils.bodyIsGround(b))
				|| (GameUtils.bodyIsGround(a) && GameUtils.bodyIsBunny(b))) {
			bunny.landed();
			Gdx.app.log(TAG, ": jumping = false");
		}

	}

	@Override
	public void endContact(Contact contact) {

	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {

	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {

	}

}
