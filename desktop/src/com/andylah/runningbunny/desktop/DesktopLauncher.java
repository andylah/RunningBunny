package com.andylah.runningbunny.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.andylah.runningbunny.RunningBunny;
import com.andylah.runningbunny.Vars;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Vars.APP_WIDTH;
		config.height = Vars.APP_HEIGHT;
		new LwjglApplication(new RunningBunny(), config);
	}
}
