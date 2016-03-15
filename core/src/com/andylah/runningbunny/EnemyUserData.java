package com.andylah.runningbunny;

import com.badlogic.gdx.math.Vector2;

public class EnemyUserData extends UserData {

	private Vector2 linierVelocity;

	public EnemyUserData(float width, float height) {
		super(width, height);
		linierVelocity = new Vector2(Vars.ENEMY_LINIER_X, Vars.ENEMY_LINIER_Y);
		userDataType = userDataType.ENEMY;
	}

	public Vector2 getLinierVelocity() {
		return linierVelocity;
	}

	public void setLinierVelocity(Vector2 linierVelocity) {
		this.linierVelocity = linierVelocity;
	}

}
