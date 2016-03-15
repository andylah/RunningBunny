package com.andylah.runningbunny;

import com.badlogic.gdx.physics.box2d.Body;

public class Enemy extends GameActor{

	public Enemy(Body body) {
		super(body);
		
	}

	@Override
	public EnemyUserData getUserData() {
		
		return (EnemyUserData) userData;
	}
	
	public void act(float deltaTime){
		super.act(deltaTime);
		body.setLinearVelocity(getUserData().getLinierVelocity());
	}

}
