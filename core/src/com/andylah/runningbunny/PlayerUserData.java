package com.andylah.runningbunny;

import com.badlogic.gdx.math.Vector2;

public class PlayerUserData extends UserData{

	private Vector2 standPosition;
	private Vector2 dodgePosition;
	private Vector2 jumpingLinierImpulse;
	
	public PlayerUserData() {
		super();
		jumpingLinierImpulse = new Vector2(Vars.JUMP_X,Vars.JUMP_Y);
		dodgePosition = new Vector2(Vars.BUNNY_DODGE_X, Vars.BUNNY_DODGE_Y);
		standPosition = new Vector2(Vars.BUNNY_X, Vars.BUNNY_Y);
		userDataType = userDataType.BUNNY;
	}

	public Vector2 getJumpingLinierImpulse() {
		return jumpingLinierImpulse;
	}

	public void setJumpingLinierImpulse(Vector2 jumpingLinierImpulse) {
		this.jumpingLinierImpulse = jumpingLinierImpulse;
	}

	public float getDodgeAngle() {
		//in radian
		return (float) (-90f * (Math.PI / 180f));
	}

	public Vector2 getStandPosition() {
		return standPosition;
	}

	public Vector2 getDodgePosition() {
		return dodgePosition;
	}
	

}
