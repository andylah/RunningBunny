package com.andylah.runningbunny;

import java.util.Random;

//class method untuk mengeluarkan random enemy dari enum yang sudah di buat --> class enum enemyType 

public class RandomEnumValue {
	
	public static EnemyType getRandomEnemyType(){
		RandomEnum<EnemyType> randomEnum = new RandomEnum<EnemyType>(EnemyType.class);
		return randomEnum.random();
	}
	
	private static class RandomEnum<E extends Enum> {
		private static final Random rand = new Random();
		private final E[] values;
		
		public RandomEnum(Class<E> token){
			values = token.getEnumConstants();
		}
		
		public E random(){
			return values[rand.nextInt(values.length)];
		}
	}
}
