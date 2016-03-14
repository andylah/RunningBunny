package com.andylah.runningbunny;

public abstract class UserData {
	protected Type userDataType;
	protected float width;
	protected float height;

	public UserData() {
		
	}
	
	public UserData(float width, float height){
		this.width = width;
		this.height = height;
	}

	public Type getUserDataType() {
		return userDataType;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

}
