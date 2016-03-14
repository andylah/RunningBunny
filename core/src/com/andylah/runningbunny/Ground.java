package com.andylah.runningbunny;

import com.badlogic.gdx.physics.box2d.Body;

public class Ground extends GameActor{
	
	public Ground(Body body) {
		super(body);
		
	}

	@Override
	public GroundUserData getUserData() {
		
		return (GroundUserData) userData;
	}

}
