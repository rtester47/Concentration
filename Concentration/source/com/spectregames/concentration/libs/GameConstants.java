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
package com.spectregames.concentration.libs;

/**
 *	Project: Concentration
 * 	Package: com.spectregames.concentration.libs
 *	Class: GameConstants
 *
 * @author Phantom Coder
 * @license Apache Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
 * 
 *	
 */
public class GameConstants {
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 640;
	public static final int CENTER_X = WIDTH / 2;
	public static final int CENTER_Y = HEIGHT / 2;
	
	// Sets up the default values when the game is first ran.
	public static final String DEFAULT_THEME = "Spectre Games";
	public static final String DEFAULT_DIFFICULTY = "NORMAL";
	public static final int DEFAULT_SFX_VOLUME = 100;
	public static final int DEFAULT_BGM_VOLUME = 100;
	
	// Sets the title of the game.
	public static final String TITLE = "Concentration";
		
	
	public static boolean isDevMode = true;
	public static boolean isDebugMode = false;
	
	// Boolean for the image change in the menus.
	public static boolean isPressed = false;
	
	// Booleans for the sound effects.
	public static boolean hasPlayedTickSound = false;
	public static boolean hasPlayedClickSound = false;
	
	// Booleans for the hover / clicked sound effects.
	public static boolean isInBoundsOfPlayButton = false;
	public static boolean isInBoundsOfOptionsButton = false;
	public static boolean isInBoundsOfInstructionsButton = false;
	public static boolean isInBoundsOfScoresButton = false;
	public static boolean isInBoundsOfQuitButton = false;

	
	// The root / base directory for all of the games assets.
	public static final String BASE_ASSETS_DIR = "./assets/";
	 
	// Directory structure for all images used in the game.
	public static final String BASE_SPRITE_DIR = BASE_ASSETS_DIR + "sprites/";
	public static final String GUI_SPRITES = BASE_SPRITE_DIR + "gui/";
	public static final String MAINMENU = GUI_SPRITES + "main_menu/";
	public static final String SPLASH =  GUI_SPRITES + "splash_screen/";
	public static final String THEMES = BASE_SPRITE_DIR + "themes/";
	public static final String CURSORS = BASE_SPRITE_DIR + "cursors/";
	public static final String ICONS = BASE_SPRITE_DIR + "icons/";
	public static final String FONTS = BASE_SPRITE_DIR + "fonts/";
	
	//Directory structure for all audio files used in the game.
	public static final String BASE_AUDIO_DIR = BASE_ASSETS_DIR + "audio/";
	public static final String BGM = BASE_AUDIO_DIR + "bgm/";
	public static final String SFX = BASE_AUDIO_DIR + "sfx/";

}
