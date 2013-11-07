/* 
*	Date: Oct 13, 2013
*	Company: Spectre Games
*	Web Address: http://www.spectregames.com
* 
*	Copyright 2013 Phantom Coder(Richard Tester)
* 	Based on code from the following YouTube Channels:
*			BossLetsPlays(Matthew Rogers)
*			RealTutsGML(Zack Berenger)
*
*  	Licensed under the Apache License, Version 2.0 (the "License");
*  	you may not use this file except in compliance with the License.
*  	You may obtain a copy of the License at
*
*	http://www.apache.org/licenses/LICENSE-2.0
*
*  	Unless required by applicable law or agreed to in writing, software
*  	distributed under the License is distributed on an "AS IS" BASIS,
*  	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*  	See the License for the specific language governing permissions and
*  	limitations under the License.
*/
package com.spectregames.concentration.utils;

import java.awt.image.BufferedImage;
import java.io.IOException;

import com.spectregames.concentration.libs.Audio;
import com.spectregames.concentration.libs.GameConstants;
import com.spectregames.concentration.libs.Images;

/**
 *	Project: Concentration
 * 	Package: com.spectregames.concentration.utils
 *	Class: ResourceLoader
 *
 * @author Phantom Coder
 * @license Apache Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
 * 
 *	
 */
public class ResourceLoader {
	
	private static BufferedImageLoader imageLoader = new BufferedImageLoader();
	private static BufferedImage sprite_sheet = null;
	public static SpriteSheet ss;
	
	public static BufferedImage[] card = new BufferedImage[25];
	
	// Loads all of the games image assets.
	public static void loadImages(){
		
		// Image for the normal cursor.
		try{
			// Images for the Splash Screens
			Images.splash_screen = imageLoader.loadImage(GameConstants.SPLASH + "splash.png");
			
			// Default Theme for Card Sprite sheet.
			sprite_sheet = imageLoader.loadImage(GameConstants.THEMES + "spectre_games.png");
			ss = new SpriteSheet(sprite_sheet);
			
			// Images for the Main Menu.
			Images.main_menu_title = imageLoader.loadImage(GameConstants.MAINMENU + "main_menu_title.png");
			Images.main_menu_background = imageLoader.loadImage(GameConstants.MAINMENU + "main_menu.png"); 
			Images.main_menu_play_hover = imageLoader.loadImage(GameConstants.MAINMENU + "play_hover_state.png");
			Images.main_menu_play_normal = imageLoader.loadImage(GameConstants.MAINMENU + "play_normal_state.png");
			Images.main_menu_play_pressed = imageLoader.loadImage(GameConstants.MAINMENU + "play_pressed_state.png");
			Images.main_menu_options_hover = imageLoader.loadImage(GameConstants.MAINMENU + "options_hover_state.png");
			Images.main_menu_options_normal = imageLoader.loadImage(GameConstants.MAINMENU + "options_normal_state.png");
			Images.main_menu_options_pressed = imageLoader.loadImage(GameConstants.MAINMENU + "options_pressed_state.png");
			Images.main_menu_instructions_hover = imageLoader.loadImage(GameConstants.MAINMENU + "instructions_hover_state.png");
			Images.main_menu_instructions_normal = imageLoader.loadImage(GameConstants.MAINMENU + "instructions_normal_state.png");
			Images.main_menu_instructions_pressed = imageLoader.loadImage(GameConstants.MAINMENU + "instructions_pressed_state.png");
			Images.main_menu_high_scores_hover = imageLoader.loadImage(GameConstants.MAINMENU + "high_scores_hover_state.png");
			Images.main_menu_high_scores_normal = imageLoader.loadImage(GameConstants.MAINMENU + "high_scores_normal_state.png");
			Images.main_menu_high_scores_pressed = imageLoader.loadImage(GameConstants.MAINMENU + "high_scores_pressed_state.png");
			Images.main_menu_quit_hover = imageLoader.loadImage(GameConstants.MAINMENU + "quit_hover_state.png");
			Images.main_menu_quit_normal = imageLoader.loadImage(GameConstants.MAINMENU + "quit_normal_state.png");
			Images.main_menu_quit_pressed = imageLoader.loadImage(GameConstants.MAINMENU + "quit_pressed_state.png");

			// Images for the Options Menu.
			
			
			
		} catch(IOException e){ e.printStackTrace(); }
		
		loadSprites();
		
		}

	
	public static void loadSprites(){
		/**
		 * 0 = back card
		 * 1 - 24 different card face
		 */
		
		for(int i = 0; i < card.length; i++){
			card[i] = ss.grabImage(i+1, 1, 80, 80);
		}
	}
	
	// Loads all of the games audio assets.
	public static void loadAudio(){
		
		
		//Sound Effects.
        //AudioPlayer.addSound(Audio.SFX_APPLAUSE, "applause.aif");
        AudioPlayer.addSound(Audio.SFX_CLICK, "button_click.aif");
        AudioPlayer.addSound(Audio.SFX_HOVER, "mouse_over.aif");
        //AudioPlayer.addSound(Audio.SFX_FLIP, "card_flip.aif");
        
       // Background Music.
       //AudioPlayer.addMusic(Audio.BGM_HOTS, "heart_of_the_sea.aif");
    }
}
