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
import com.spectregames.concentration.libs.Reference;
import com.spectregames.concentration.output.ClickSound;
import com.spectregames.concentration.output.TickSound;
import com.spectregames.concentration.utils.Images;

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
		play = new Rectangle(Reference.CENTER_X - 155, fillerY, 310, 50);
		options = new Rectangle(Reference.CENTER_X - 155, fillerY += 64, 310, 50);
		instructions = new Rectangle(Reference.CENTER_X - 155, fillerY += 64, 310, 50);
		scores = new Rectangle(Reference.CENTER_X - 155, fillerY += 62, 310, 50);
		quit = new Rectangle(Reference.CENTER_X - 155, fillerY += 64, 310, 50);
	}
	
	public void drawButton(Graphics g, Rectangle rect, String txt, int offsetX){
		
    	g.drawImage(Images.main_menu_play_normal, play.x - 3, play.y - 9, null);
    	g.drawImage(Images.main_menu_options_normal, options.x - 3, options.y - 7, null);
    	g.drawImage(Images.main_menu_instructions_normal, instructions.x - 3, instructions.y - 10, null);
    	g.drawImage(Images.main_menu_high_scores_normal, scores.x - 3, scores.y - 9, null);
    	g.drawImage(Images.main_menu_quit_normal, quit.x - 2, quit.y - 12, null);
    	
    	// Changes the play image for the main menu when mouse hovers over or has been pressed.
	    if(MouseInput.MOUSE.intersects(play) && Reference.isPressed){ 
	    	g.drawImage(Images.main_menu_play_pressed, play.x - 3, play.y - 9, null);
		    	if(Reference.hasPlayedClickSound){
		    	try {
					new ClickSound();
					ClickSound.click();
				} catch (LineUnavailableException | InterruptedException e) {
					e.printStackTrace();
				};
				Reference.hasPlayedClickSound= false;
	    	}
	    }else if(MouseInput.MOUSE.intersects(play)){
	    	g.drawImage(Images.main_menu_play_hover, play.x - 3, play.y - 14, null);
	    	/* if(!Reference.hasPlayedTickSound)
	    	 try {
				new TickSound();
				TickSound.tick();
			} catch (LineUnavailableException | InterruptedException e) {
				e.printStackTrace();
			};
			Reference.hasPlayedTickSound= true; */
	    }
	    
	    // Changes the options image for the main menu when mouse hovers over or has been pressed.
	    if(MouseInput.MOUSE.intersects(options) && Reference.isPressed){ 
	    	g.drawImage(Images.main_menu_options_pressed, options.x - 3, options.y - 7, null);
	    	if(Reference.hasPlayedClickSound){
	    	try {
				new ClickSound();
				ClickSound.click();
			} catch (LineUnavailableException | InterruptedException e) {
				e.printStackTrace();
			};
			Reference.hasPlayedClickSound= false;
    	}
	    }else if(MouseInput.MOUSE.intersects(options)){	
	    	g.drawImage(Images.main_menu_options_hover, options.x - 11, options.y - 16, null);
	    	if(!Reference.hasPlayedTickSound)
	    	try {
				new TickSound();
				TickSound.tick();
			} catch (LineUnavailableException | InterruptedException e) {
				e.printStackTrace();
			};
			Reference.hasPlayedTickSound= true;
	    }
	    
	    // Changes the instructions image for the main menu when mouse hovers over or has been pressed.
	    if(MouseInput.MOUSE.intersects(instructions)&& Reference.isPressed){
	    	g.drawImage(Images.main_menu_instructions_pressed, instructions.x - 3, instructions.y - 10, null);
	    	if(Reference.hasPlayedClickSound){
	    	try {
				new ClickSound();
				ClickSound.click();
			} catch (LineUnavailableException | InterruptedException e) {
				e.printStackTrace();
			};
			Reference.hasPlayedClickSound= false;
    	}
	    }else if(MouseInput.MOUSE.intersects(instructions)){
	    	g.drawImage(Images.main_menu_instructions_hover, instructions.x - 3, instructions.y - 18, null);
	    	if(!Reference.hasPlayedTickSound)
	    	try {
				new TickSound();
				TickSound.tick();
			} catch (LineUnavailableException | InterruptedException e) {
				e.printStackTrace();
			};
			Reference.hasPlayedTickSound= true;
	    }
	    
	    // Changes the high scores image for the main menu when mouse hovers over or has been pressed.
	    if(MouseInput.MOUSE.intersects(scores) && Reference.isPressed){
	    	g.drawImage(Images.main_menu_high_scores_pressed, scores.x - 3, scores.y - 9, null);
	    	if(Reference.hasPlayedClickSound){
	    	try {
				new ClickSound();
				ClickSound.click();
			} catch (LineUnavailableException | InterruptedException e) {
				e.printStackTrace();
			};
			Reference.hasPlayedClickSound= false;
    	}
	    }else if(MouseInput.MOUSE.intersects(scores)){
			g.drawImage(Images.main_menu_high_scores_hover, scores.x - 11, scores.y - 18, null);
	    	if(!Reference.hasPlayedTickSound)
	    	try {
				new TickSound();
				TickSound.tick();
			} catch (LineUnavailableException | InterruptedException e) {
				e.printStackTrace();
			};
			Reference.hasPlayedTickSound= true;
	    }
	    
	    // Changes the quit image for the main menu when mouse hovers over or has been pressed.
	    if(MouseInput.MOUSE.intersects(quit) && Reference.isPressed){
	    	g.drawImage(Images.main_menu_quit_pressed, quit.x - 2, quit.y - 12, null);
	    	if(Reference.hasPlayedClickSound){
	    	try {
				new ClickSound();
				ClickSound.click();
			} catch (LineUnavailableException | InterruptedException e) {
				e.printStackTrace();
			};
			Reference.hasPlayedClickSound= false;
    	}
	    }else if(MouseInput.MOUSE.intersects(quit)){
			g.drawImage(Images.main_menu_quit_hover, quit.x - 2, quit.y - 20, null);
	    	if(!Reference.hasPlayedTickSound)
	    	try {
				new TickSound();
				TickSound.tick();
			} catch (LineUnavailableException | InterruptedException e) {
				e.printStackTrace();
			};
			Reference.hasPlayedTickSound= true;
	    }
	}
	
	public void render(Graphics g){
		g.drawImage(Images.main_menu_background, 0, 0, Reference.WIDTH, Reference.HEIGHT, null);
		g.drawImage(Images.main_menu_title, 0, 0, Reference.WIDTH, Reference.HEIGHT, null);
		drawButton(g, play, "", 0);
		drawButton(g, options, "", 0);
		drawButton(g, instructions, "", 0);
		drawButton(g, scores, "", 0);
		drawButton(g, quit, "", 0);
	}
}
