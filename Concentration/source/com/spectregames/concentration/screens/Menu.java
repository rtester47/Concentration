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
 package com.spectregames.concentration.screens;

import java.awt.Graphics;

import com.spectregames.concentration.Game;
import com.spectregames.concentration.libs.GameConstants;
import com.spectregames.concentration.libs.Images;
import com.spectregames.concentration.utils.Button;

/**
 *	Project: Concentration
 * 	Package: com.spectregames.concentration.screens
 *	Class: Menu
 *
 * @author Phantom Coder
 * @license Apache Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
 * 
 *	
 */
public class Menu{
	public Button play, options, instructions, scores, quit;

	
	public Menu(){
		
		int fillerY = 183;
		play = new Button(GameConstants.CENTER_X - 155, fillerY, 310, 50);
		options = new Button(GameConstants.CENTER_X - 155, fillerY += 64, 310, 50);
		instructions = new Button(GameConstants.CENTER_X - 155, fillerY += 64, 310, 50);
		scores = new Button(GameConstants.CENTER_X - 155, fillerY += 62, 310, 50);
		quit = new Button(GameConstants.CENTER_X - 155, fillerY += 64, 310, 50);
	}
	
	
	public void render(Graphics g){
		
		switch (Game.state){
		case CREDITS:
			break;
		case GAME:
			break;
		case INSTRUCTIONS:
			break;
		case MENU:
			g.drawImage(Images.main_menu_background, 0, 0, GameConstants.WIDTH, GameConstants.HEIGHT, null);
			g.drawImage(Images.main_menu_title, 0, 0, GameConstants.WIDTH, GameConstants.HEIGHT, null);
		
	       play.drawButton(g, 3, 6, 3, 12, 3, 4, Images.main_menu_play_normal, Images.main_menu_play_hover, Images.main_menu_play_pressed);
	       options.drawButton(g, 3, 6, 11, 16, 3, 6, Images.main_menu_options_normal, Images.main_menu_options_hover, Images.main_menu_options_pressed);
	       instructions.drawButton(g, 3, 10, 3, 18, 3, 10, Images.main_menu_instructions_normal, Images.main_menu_instructions_hover, Images.main_menu_instructions_pressed);
	       scores.drawButton(g, 3, 10, 11, 18, 3, 10, Images.main_menu_high_scores_normal, Images.main_menu_high_scores_hover, Images.main_menu_high_scores_pressed);
	       quit.drawButton(g, 3, 14, 3, 21, 3, 14, Images.main_menu_quit_normal, Images.main_menu_quit_hover, Images.main_menu_quit_pressed);
		       
			break;
		case OPTIONS:
			break;
		case PAUSE:
			break;
		case QUITTING:
			break;
		case SCORES:
			break;
		case SPLASH:
			break;
		default:
			break;
		
		}

	}
}
