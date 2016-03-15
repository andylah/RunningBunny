package com.andylah.runningbunny;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class GameUtils {

	public static final String TAG = GameStage.class.getName();
	
	// variable create ground
	static BodyDef groundbDef;
	static Body groundBody;
	static PolygonShape groundShape;

	// variable crate player
	static BodyDef bunnybDef;
	static Body bunnyBody;
	static PolygonShape bunnyShape;

	// variable create enemy
	static BodyDef enemybDef;
	static Body enemyBody;
	static PolygonShape enemyShape;

	// create ground
	public static Body createGround(World world) {
		groundbDef = new BodyDef();

		groundbDef.position.set(new Vector2(Vars.GROUND_X, Vars.GROUND_Y));
		groundBody = world.createBody(groundbDef);
		groundShape = new PolygonShape();
		groundShape.setAsBox(Vars.GROUND_WIDTH / 2, Vars.GROUND_HEIGHT / 2);
		groundBody.createFixture(groundShape, Vars.GROUND_DENSITY);

		groundBody.setUserData(new GroundUserData(Vars.GROUND_WIDTH, Vars.GROUND_HEIGHT));
		groundShape.dispose();

		return groundBody;
	}

	// create player
	public static Body createBunny(World world) {
		bunnybDef = new BodyDef();
		bunnybDef.type = BodyType.DynamicBody;
		bunnybDef.position.set(new Vector2(Vars.BUNNY_X, Vars.BUNNY_Y));
		bunnyShape = new PolygonShape();
		bunnyShape.setAsBox(Vars.BUNNY_WIDTH / 2, Vars.BUNNY_HEIGHT / 2);

		bunnyBody = world.createBody(bunnybDef);
		bunnyBody.setGravityScale(Vars.BUNNY_GRAVITY_SCALE);
		bunnyBody.createFixture(bunnyShape, Vars.BUNNY_DENSITY);

		bunnyBody.resetMassData();
		bunnyBody.setUserData(new PlayerUserData(Vars.BUNNY_WIDTH, Vars.BUNNY_HEIGHT));
		bunnyShape.dispose();

		return bunnyBody;
	}

	// create enemy
	public static Body createEnemy(World world) {
		EnemyType enemyType = RandomEnumValue.getRandomEnemyType();
		enemybDef = new BodyDef();
		enemybDef.type = BodyType.KinematicBody;
		enemybDef.position.set(new Vector2(enemyType.getX(), enemyType.getY()));
		enemyShape = new PolygonShape();
		enemyShape.setAsBox(enemyType.getWidth() / 2, enemyType.getHeight() / 2);

		enemyBody = world.createBody(enemybDef);
		enemyBody.createFixture(enemyShape, enemyType.getDensity());

		enemyBody.resetMassData();
		EnemyUserData userData = new EnemyUserData(enemyType.getWidth(), enemyType.getHeight());
		enemyBody.setUserData(userData);
		enemyShape.dispose();

		return enemyBody;
	}

	// mendefinisikan body adalah bunny
	public static boolean bodyIsBunny(Body body) {

		UserData userData = (UserData) body.getUserData();
		return userData != null && userData.getUserDataType() == Type.BUNNY;
	}

	// mendefinisikan body adalah ground
	public static boolean bodyIsGround(Body body) {

		UserData userData = (UserData) body.getUserData();
		return userData != null && userData.getUserDataType() == Type.GROUND;
	}

	// mendefinisikan body adalah enemy
	public static boolean bodyIsEnemy(Body body) {

		UserData userData = (UserData) body.getUserData();
		return userData != null && userData.getUserDataType() == Type.ENEMY;
	}

	// mendefinisikan apakah body masih nampak dilayar
	public static boolean bodyOnScreen(Body body) {

		UserData userData = (UserData) body.getUserData();
		//Gdx.app.log(TAG, ": body : " + userData.getUserDataType() +"");
		switch (userData.getUserDataType()) {
		case BUNNY:
		case ENEMY:
			return body.getPosition().x + userData.getWidth() / 2 > 0;
		}
		return true;
	}

}
