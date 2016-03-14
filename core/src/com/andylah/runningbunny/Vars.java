package com.andylah.runningbunny;

public class Vars {
	// APP setup
	public static final int APP_WIDTH = 800;
	public static final int APP_HEIGHT = 480;

	// final variable untuk ground
	public static final float GROUND_WIDTH = 50f;
	public static final float GROUND_HEIGHT = 2f;
	public static final float GROUND_X = 0;
	public static final float GROUND_Y = 0;
	public static final float GROUND_DENSITY = 0;

	// final variable untuk world
	public static final float TIME_STEP = 1 / 60f;

	// final varibale untuk camera viewport
	public static final int VIEWPORT_WIDTH = 20;
	public static final int VIEWPORT_HEIGHT = 13;

	// final variable untuk bunny
	public static final float BUNNY_WIDTH = 1f;
	public static final float BUNNY_HEIGHT = 2f;
	public static final float BUNNY_X = 2;
	public static final float BUNNY_Y = GROUND_Y + GROUND_HEIGHT;
	public static final float BUNNY_DENSITY = 0.5f;
	public static final float BUNNY_DODGE_X = 2f;
	public static final float BUNNY_DODGE_Y = 1.5f;
	
	
	public static final float JUMP_X = 0;
	public static final float JUMP_Y = 13f;
	public static final float BUNNY_GRAVITY_SCALE = 3f;
	
	

}
