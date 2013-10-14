/**
 *  Copyright 2013 Phantom Coder (Richard Tester)
 */
package com.spectregames.concentration.utils;

import java.io.IOException;

import com.spectregames.concentration.libs.Reference;

/**
 *  Project: Concentration
 *  
 *  Class: ResourceLoader
 *  
 *  @author Phantom Coder
 *	
 */
public class ResourceLoader {
	
	private static BufferedImageLoader imageLoader = new BufferedImageLoader();
	
	// Loads all of the games image assets.
	public static void loadImages(){
		
		// Image for the SplashScreen.
		try{
			Images.splash_screen = imageLoader.loadImage(Reference.GUI_SPRITES + "splash.png");
		} catch(IOException e){ e.printStackTrace(); }
		
		// Images for the Main Menu.
		try{
			Images.main_menu_background = imageLoader.loadImage(Reference.GUI_SPRITES + "main_menu.png");
		} catch(IOException e){ e.printStackTrace(); }
		
		try{
			Images.main_menu_play_hover = imageLoader.loadImage(Reference.GUI_SPRITES + "play_hover_state.png");
		} catch(IOException e){ e.printStackTrace(); }
		
		try{
			Images.main_menu_play_normal = imageLoader.loadImage(Reference.GUI_SPRITES + "play_normal_state.png");
		} catch(IOException e){ e.printStackTrace(); }
		
		try{
			Images.main_menu_options_hover = imageLoader.loadImage(Reference.GUI_SPRITES + "options_hover_state.png");
		} catch(IOException e){ e.printStackTrace(); }
		
		try{
			Images.main_menu_options_normal = imageLoader.loadImage(Reference.GUI_SPRITES + "options_normal_state.png");
		} catch(IOException e){ e.printStackTrace(); }
		
		try{
			Images.main_menu_instructions_hover = imageLoader.loadImage(Reference.GUI_SPRITES + "instructions_hover_state.png");
		} catch(IOException e){ e.printStackTrace(); }
		
		try{
			Images.main_menu_instructions_normal = imageLoader.loadImage(Reference.GUI_SPRITES + "instructions_normal_state.png");
		} catch(IOException e){ e.printStackTrace(); }
		
		try{
			Images.main_menu_high_scores_hover = imageLoader.loadImage(Reference.GUI_SPRITES + "high_scores_hover_state.png");
		} catch(IOException e){ e.printStackTrace(); }
		
		try{
			Images.main_menu_high_scores_normal = imageLoader.loadImage(Reference.GUI_SPRITES + "high_scores_normal_state.png");
		} catch(IOException e){ e.printStackTrace(); }
		
		try{
			Images.main_menu_quit_hover = imageLoader.loadImage(Reference.GUI_SPRITES + "quit_hover_state.png");
		} catch(IOException e){ e.printStackTrace(); }
		
		try{
			Images.main_menu_quit_normal = imageLoader.loadImage(Reference.GUI_SPRITES + "quit_normal_state.png");
		} catch(IOException e){ e.printStackTrace(); }
	}
	
	// Loads all of the games audio assets.
	public static void loadAudio(){
		
	}

}
