package com.andylah.runningbunny;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class GameUtils {

	// variable create ground
	static BodyDef groundbDef;
	static Body groundBody;
	static PolygonShape groundShape;

	// variable crate player
	static BodyDef bunnybDef;
	static Body bunnyBody;
	static PolygonShape bunnyShape;

	// create ground
	public static Body createGround(World world) {
		groundbDef = new BodyDef();
		
		groundbDef.position.set(new Vector2(Vars.GROUND_X, Vars.GROUND_Y));
		groundBody = world.createBody(groundbDef);
		groundShape = new PolygonShape();
		groundShape.setAsBox(Vars.GROUND_WIDTH / 2, Vars.GROUND_HEIGHT / 2);
		groundBody.createFixture(groundShape, Vars.GROUND_DENSITY);
		
		groundBody.setUserData(new GroundUserData());
		groundShape.dispose();

		return groundBody;
	}

	// create player
	public static Body createBunny(World world) {
		bunnybDef = new BodyDef();
		bunnybDef.type = BodyType.DynamicBody;
		bunnybDef.position.set(new Vector2(Vars.BUNNY_X, Vars.BUNNY_Y));
		bunnyShape = new PolygonShape();
		bunnyShape.setAsBox(Vars.BUNNY_WIDTH / 2, Vars.BUNNY_HEIGHT /2);
		
		bunnyBody = world.createBody(bunnybDef);
		bunnyBody.setGravityScale(Vars.BUNNY_GRAVITY_SCALE);
		bunnyBody.createFixture(bunnyShape, Vars.BUNNY_DENSITY);

		bunnyBody.resetMassData();
		bunnyBody.setUserData(new PlayerUserData());
		bunnyShape.dispose();

		return bunnyBody;
	}
	
	//membedakan body bunny dan body ground
	public static boolean bodyIsBunny(Body body){
		
		UserData userData = (UserData) body.getUserData();
		return userData != null && userData.getUserDataType() == UserDataType.BUNNY;
	}
	
	//membedakan body bunny dan body ground
	public static boolean bodyIsGround(Body body){
		
		UserData userData = (UserData) body.getUserData();
		return userData != null && userData.getUserDataType() == UserDataType.GROUND;
	}

}
