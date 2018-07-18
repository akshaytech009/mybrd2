package com.nucleus.connection;


public class FactoryClass 
{
	public ConnectionInterface factoryMethod(String type){
		if(type.equalsIgnoreCase("oracle")){
			return new ConnectionClass();
		}
		return null;
	}

}
