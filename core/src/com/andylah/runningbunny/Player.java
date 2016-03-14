package com.andylah.runningbunny;

import com.badlogic.gdx.physics.box2d.Body;

public class Player extends GameActor {

	private boolean jumping, dodging;

	public Player(Body body) {
		super(body);
		
	}

	@Override
	public PlayerUserData getUserData() {
		
		return (PlayerUserData) userData;
	}
	
	public void jump(){
		if (!(jumping || dodging)){
			body.applyLinearImpulse(getUserData().getJumpingLinierImpulse(), body.getWorldCenter(), true);
			jumping = true;
		}
	}
	
	public void dodge(){
		if (!jumping){
			body.setTransform(getUserData().getDodgePosition(), getUserData().getDodgeAngle());
			dodging = true;
		}
	}
	
	public void landed(){
		jumping = false;
	}
	
	public void stopDodging(){
		dodging = false;
		body.setTransform(getUserData().getStandPosition(), 0f);
	}
	public boolean isDodging(){
		return dodging;
	}
}
