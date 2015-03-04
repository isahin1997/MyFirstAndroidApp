package com.example.converteerapp;

import java.util.Observable;

public class Model extends Observable{
	
	private int huidigeGetal;
	
	public Model(int i){
		huidigeGetal = i;
	}
	
	public void veranderGetal(int g){
		
		huidigeGetal = huidigeGetal + g;
		
		setChanged();
		notifyObservers();
	}
	
	public void zetGetal(int g){
		huidigeGetal = g;
		setChanged();
		notifyObservers();
	}
	
	public int getGetal(){
		return huidigeGetal;
	}

}
