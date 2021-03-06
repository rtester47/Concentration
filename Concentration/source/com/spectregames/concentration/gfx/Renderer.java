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
package com.spectregames.concentration.gfx;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.spectregames.concentration.Game;
import com.spectregames.concentration.libs.GameConstants;

/**
 *	Project: Concentration
 * 	Package: com.spectregames.concentration.gfx
 *	Class: Renderer
 *
 * @author Phantom Coder
 * @license Apache Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
 * 
 *	
 */
public class Renderer {
	

	
	public void renderBackground(Graphics g){
		Font tempFont = new Font("Arial", Font.BOLD, 44);
		switch(Game.state){
			case CREDITS:
				break;
			case EASY_GAME:
				g.setFont(tempFont);
				g.setColor(Color.RED);
				g.drawString("EASY GAME", GameConstants.CENTER_X -275, GameConstants.CENTER_Y - 300);
				break;
			case EXTREME_GAME:
				g.setFont(tempFont);
				g.setColor(Color.RED);
				g.drawString("EXTREME GAME", GameConstants.CENTER_X -275, GameConstants.CENTER_Y - 300);
				break;	
			case GAME:
			case HARD_GAME:
				g.setFont(tempFont);
				g.setColor(Color.RED);
				g.drawString("HARD GAME", GameConstants.CENTER_X -275, GameConstants.CENTER_Y - 300);
				break;
			case INSTRUCTIONS:
				break;
			case MENU:
				Game.getInstance().getMenu().render(g);
				break;
			case NORMAL_GAME:
				g.setFont(tempFont);
				g.setColor(Color.RED);
				g.drawString("NORMAL GAME", GameConstants.CENTER_X -275, GameConstants.CENTER_Y - 300);
				break;
			case OPTIONS:
				break;
			case PAUSE:
				break;
			case QUITTING:
				// Ask if they really want to quit? if yes show scrolling credits, then exit the game. 
				// If no the return to the main menu.
				System.exit(1);
				break;
			case SCORES:
				break;
			case SPLASH:
				if (!GameConstants.isDevMode){
					Game.getInstance().splash.render(g);    
					break;
				}
				break;
			default:
				g.setFont(tempFont);
				g.setColor(Color.RED);
				g.drawString("UNKNOWN GAMESTATE", GameConstants.CENTER_X -275, GameConstants.CENTER_Y);
				break;
			}
	}
	
	public void renderForeground(Graphics g){
		
	}

}
