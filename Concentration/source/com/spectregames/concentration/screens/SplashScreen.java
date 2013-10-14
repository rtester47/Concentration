/**
 *  Copyright 2013 Phantom Coder (Richard Tester)
 */
 package com.spectregames.concentration.screens;

import java.awt.Graphics;

import com.spectregames.concentration.libs.Reference;
import com.spectregames.concentration.utils.Images;


 /**
  *  Project: Concentration
  *  
  *  Class: SplashScreen
  *  
  *  @author Phantom Coder
  *	
  */
public class SplashScreen{
	
	public void render(Graphics g){
		g.drawImage(Images.splash_screen, 0, 0, Reference.WIDTH, Reference.HEIGHT, null);
	}
}
