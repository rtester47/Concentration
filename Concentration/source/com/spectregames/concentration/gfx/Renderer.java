/**
 *  Copyright 2013 Phantom Coder (Richard Tester)
 */
package com.spectregames.concentration.gfx;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.spectregames.concentration.Game;
import com.spectregames.concentration.libs.Reference;

/**
 *  Project: Concentration
 *  
 *  Class: Renderer
 *  
 *  @author Phantom Coder
 *	
 */
public class Renderer {
	
	public void renderBackground(Graphics g){
		switch(Game.state){
			case CREDITS:
				break;
			case GAME:
				break;
			case INSTRUCTIONS:
				break;
			case MENU:
				Game.getInstance().menu.render(g);
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
				if (!Reference.isDevMode){
					Game.getInstance().splash.render(g);    
					break;
				}
				break;
			default:
				Font tempFont = new Font("Arial", Font.BOLD, 45);
				g.setFont(tempFont);
				g.setColor(Color.RED);
				g.drawString("UNKNOWN GAMESTATE", Reference.CENTER_X -275, Reference.CENTER_Y);
				break;
			}
	}
	
	public void renderForeground(Graphics g){
		
	}

}
