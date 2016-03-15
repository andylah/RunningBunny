package com.andylah.runningbunny;

public class Vars {
	// APP setup
	public static final int APP_WIDTH = 800;
	public static final int APP_HEIGHT = 480;
	public static final float WORLD_TO_SCREEN = 32;

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
	
	//final varibale untuk enemy
	public static final float ENEMY_X = 25f;
	public static final float SHORT_ENEMY_Y = 1.5f;
	public static final float LONG_ENEMY_Y = 2f;
	public static final float FLYING_ENEMY_Y = 3f;
	public static final float ENEMY_DENSITY = Vars.BUNNY_DENSITY;
	public static final float ENEMY_LINIER_X = -8f;
	public static final float ENEMY_LINIER_Y = 0f;
	
	//variable jika bunny tekena enemy
	public static final float BUNNY_GET_HIT = 10f;
	
	//variable path untuk gambar background
	public static final String BACKGROUND_PATH = "background.png"; 
	
	//variable untuk images
	public static final String CHARACTER_ATLAS = "character.atlas";
	public static final String[] RUNNING_CHARACTER_SET = new String[]{"1","2","3","4"};
	public static final String JUMPING_CHARACTER = "jump";
	public static final String DODGING_CHARACTER = "slide";
}
