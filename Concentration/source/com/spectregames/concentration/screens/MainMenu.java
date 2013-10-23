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
import java.awt.Rectangle;

import javax.sound.sampled.LineUnavailableException;

import com.spectregames.concentration.input.MouseInput;
import com.spectregames.concentration.libs.GameConstants;
import com.spectregames.concentration.libs.Images;
import com.spectregames.concentration.output.ClickSound;
import com.spectregames.concentration.output.TickSound;

/**
 *	Project: Concentration
 * 	Package: com.spectregames.concentration.screens
 *	Class: MainMenu
 *
 * @author Phantom Coder
 * @license Apache Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
 * 
 *	
 */
public class MainMenu{
	public static Rectangle play;
	public static Rectangle options;
	public static Rectangle instructions;
	public static Rectangle scores;
	public static Rectangle quit;

	
	public MainMenu(){
		
		int fillerY = 183;
		play = new Rectangle(GameConstants.CENTER_X - 155, fillerY, 310, 50);
		options = new Rectangle(GameConstants.CENTER_X - 155, fillerY += 64, 310, 50);
		instructions = new Rectangle(GameConstants.CENTER_X - 155, fillerY += 64, 310, 50);
		scores = new Rectangle(GameConstants.CENTER_X - 155, fillerY += 62, 310, 50);
		quit = new Rectangle(GameConstants.CENTER_X - 155, fillerY += 64, 310, 50);
	}
	
	public void drawButton(Graphics g, Rectangle rect, String txt, int offsetX){
		
    	g.drawImage(Images.main_menu_play_normal, play.x - 3, play.y - 9, null);
    	g.drawImage(Images.main_menu_options_normal, options.x - 3, options.y - 7, null);
    	g.drawImage(Images.main_menu_instructions_normal, instructions.x - 3, instructions.y - 10, null);
    	g.drawImage(Images.main_menu_high_scores_normal, scores.x - 3, scores.y - 9, null);
    	g.drawImage(Images.main_menu_quit_normal, quit.x - 2, quit.y - 12, null);
    	
    	// Changes the play image for the main menu when mouse hovers over or has been pressed.
	    if(MouseInput.MOUSE.intersects(play) && GameConstants.isPressed){
	    	GameConstants.isInBoundsOfPlayButton= true;
	    	g.drawImage(Images.main_menu_play_pressed, play.x - 3, play.y - 9, null);
	    	System.out.println("INSIDE OF PLAY BUTTONS BOUNDS" + GameConstants.isInBoundsOfPlayButton);
		    	if(GameConstants.hasPlayedClickSound){
		    	try {
					new ClickSound();
					ClickSound.click();
				} catch (LineUnavailableException | InterruptedException e) {
					e.printStackTrace();
				};
				GameConstants.hasPlayedClickSound= false;
	    	}
	    }else if(MouseInput.MOUSE.intersects(play)){
	    	GameConstants.isInBoundsOfPlayButton= true;
	    	System.out.println("INSIDE OF PLAY BUTTONS BOUNDS" + GameConstants.isInBoundsOfPlayButton);
	    	g.drawImage(Images.main_menu_play_hover, play.x - 3, play.y - 14, null);
	    }else{
	    	GameConstants.isInBoundsOfPlayButton= false;
	        System.out.println("INSIDE OF PLAY BUTTONS BOUNDS" + GameConstants.isInBoundsOfPlayButton);
	    }
	    
	    // Changes the options image for the main menu when mouse hovers over or has been pressed.
	    if(MouseInput.MOUSE.intersects(options) && GameConstants.isPressed){ 
	    	GameConstants.isInBoundsOfOptionsButton= true;
	    	System.out.println("INSIDE OF OPTIONS BUTTONS BOUNDS" + GameConstants.isInBoundsOfOptionsButton);
	    	g.drawImage(Images.main_menu_options_pressed, options.x - 3, options.y - 7, null);
	    	
	    	if(GameConstants.hasPlayedClickSound){
	    	try {
				new ClickSound();
				ClickSound.click();
			} catch (LineUnavailableException | InterruptedException e) {
				e.printStackTrace();
			};
			GameConstants.hasPlayedClickSound= false;
    	}
	    }else if(MouseInput.MOUSE.intersects(options)){
	    	GameConstants.isInBoundsOfOptionsButton= true;
	    	System.out.println("INSIDE OF OPTIONS BUTTONS BOUNDS" + GameConstants.isInBoundsOfOptionsButton);
	    	g.drawImage(Images.main_menu_options_hover, options.x - 11, options.y - 16, null);
	    }else{
	    	GameConstants.isInBoundsOfOptionsButton= false;
	        System.out.println("INSIDE OF OPTIONS BUTTONS BOUNDS" + GameConstants.isInBoundsOfOptionsButton);
	    }

	    
	    // Changes the instructions image for the main menu when mouse hovers over or has been pressed.
	    if(MouseInput.MOUSE.intersects(instructions)&& GameConstants.isPressed){
	    	GameConstants.isInBoundsOfInstructionsButton= true;
	    	System.out.println("INSIDE OF INSTRUCTIONS BUTTONS BOUNDS" + GameConstants.isInBoundsOfInstructionsButton);
	    	g.drawImage(Images.main_menu_instructions_pressed, instructions.x - 3, instructions.y - 10, null);
	    	if(GameConstants.hasPlayedClickSound){
	    	try {
				new ClickSound();
				ClickSound.click();
			} catch (LineUnavailableException | InterruptedException e) {
				e.printStackTrace();
			};
			GameConstants.hasPlayedClickSound= false;
    	}
	    }else if(MouseInput.MOUSE.intersects(instructions)){
	    	GameConstants.isInBoundsOfInstructionsButton= true;
	    	System.out.println("INSIDE OF INSTRUCTIONS BUTTONS BOUNDS" + GameConstants.isInBoundsOfInstructionsButton);
	    	g.drawImage(Images.main_menu_instructions_hover, instructions.x - 3, instructions.y - 18, null);
	    }else{
	    	GameConstants.isInBoundsOfInstructionsButton= false;
	        System.out.println("INSIDE OF INSTRUCTIONS BUTTONS BOUNDS" + GameConstants.isInBoundsOfInstructionsButton);
	    }
	    
	    // Changes the high scores image for the main menu when mouse hovers over or has been pressed.
	    if(MouseInput.MOUSE.intersects(scores) && GameConstants.isPressed){
	    	GameConstants.isInBoundsOfScoresButton= true;
	    	System.out.println("INSIDE OF HIGH SCORES BUTTONS BOUNDS" + GameConstants.isInBoundsOfScoresButton);
	    	g.drawImage(Images.main_menu_high_scores_pressed, scores.x - 3, scores.y - 9, null);
	    	if(GameConstants.hasPlayedClickSound){
	    	try {
				new ClickSound();
				ClickSound.click();
			} catch (LineUnavailableException | InterruptedException e) {
				e.printStackTrace();
			};
			GameConstants.hasPlayedClickSound= false;
    	}
	    }else if(MouseInput.MOUSE.intersects(scores)){
	    	GameConstants.isInBoundsOfScoresButton= true;
	    	System.out.println("INSIDE OF HIGH SCORES BUTTONS BOUNDS" + GameConstants.isInBoundsOfScoresButton);
			g.drawImage(Images.main_menu_high_scores_hover, scores.x - 11, scores.y - 18, null);
	    }else{
	    	GameConstants.isInBoundsOfScoresButton= false;
	        System.out.println("INSIDE OF HIGH SCORES BUTTONS BOUNDS" + GameConstants.isInBoundsOfScoresButton);
	    }
	    
	    
	    // Changes the quit image for the main menu when mouse hovers over or has been pressed.
	    if(MouseInput.MOUSE.intersects(quit) && GameConstants.isPressed){
	    	GameConstants.isInBoundsOfQuitButton= true;
	    	System.out.println("INSIDE OF QUIT BUTTONS BOUNDS" + GameConstants.isInBoundsOfQuitButton);
	    	g.drawImage(Images.main_menu_quit_pressed, quit.x - 2, quit.y - 12, null);
	    	if(GameConstants.hasPlayedClickSound){
	    	try {
				new ClickSound();
				ClickSound.click();
			} catch (LineUnavailableException | InterruptedException e) {
				e.printStackTrace();
			};
			GameConstants.hasPlayedClickSound= false;
    	}
	    }else if(MouseInput.MOUSE.intersects(quit)){
	    	GameConstants.isInBoundsOfQuitButton= true;
	    	System.out.println("INSIDE OF QUIT BUTTONS BOUNDS" + GameConstants.isInBoundsOfQuitButton);
			g.drawImage(Images.main_menu_quit_hover, quit.x - 2, quit.y - 20, null);
	    }else{
	    	GameConstants.isInBoundsOfQuitButton= false;
	        System.out.println("INSIDE OF QUIT BUTTONS BOUNDS" + GameConstants.isInBoundsOfQuitButton);
	    }
	    
	   	if (MouseInput.MOUSE.intersects(MainMenu.play) || MouseInput.MOUSE.intersects(MainMenu.options) || MouseInput.MOUSE.intersects(MainMenu.instructions) 
    			|| MouseInput.MOUSE.intersects(MainMenu.scores) || MouseInput.MOUSE.intersects(MainMenu.quit)){
	   		System.out.println("HAS PLAYED TICK" + GameConstants.hasPlayedTickSound);
		   	 if(!GameConstants.hasPlayedTickSound) { 	
		   		new TickSound();
					try {
						TickSound.tick();
					} catch (LineUnavailableException | InterruptedException e1) {
						
						e1.printStackTrace();
					}
					GameConstants.hasPlayedTickSound= true;
					System.out.println("HAS PLAYED TICK" + GameConstants.hasPlayedTickSound);
		   	 }
	   	}
	}
 
	
	
	public void render(Graphics g){
		g.drawImage(Images.main_menu_background, 0, 0, GameConstants.WIDTH, GameConstants.HEIGHT, null);
		g.drawImage(Images.main_menu_title, 0, 0, GameConstants.WIDTH, GameConstants.HEIGHT, null);
		drawButton(g, play, "", 0);
		drawButton(g, options, "", 0);
		drawButton(g, instructions, "", 0);
		drawButton(g, scores, "", 0);
		drawButton(g, quit, "", 0);
	}
}
