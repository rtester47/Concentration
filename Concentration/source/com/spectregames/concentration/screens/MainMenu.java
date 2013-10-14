/**
 *  Copyright 2013 Phantom Coder (Richard Tester)
 */
 package com.spectregames.concentration.screens;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.spectregames.concentration.input.MouseInput;
import com.spectregames.concentration.libs.Reference;
import com.spectregames.concentration.utils.Images;

 /**
  *  <strong>Project:</strong> Concentration
  *  <strong>Package:</strong> com.spectregames.concentration.screens
  *  <strong>Class:</strong> Menu
  *  
  *  @author Phantom Coder
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
    	
	    if(MouseInput.MOUSE.intersects(play)) // Changes the play image for the main menu when mouse hovers over it.
	    	g.drawImage(Images.main_menu_play_hover, play.x - 3, play.y - 14, null); 
	    if(MouseInput.MOUSE.intersects(options)) // Changes the options image for the main menu when mouse hovers over it.
	    	g.drawImage(Images.main_menu_options_hover, options.x - 11, options.y - 16, null);
	    if(MouseInput.MOUSE.intersects(instructions)) // Changes the instructions image for the main menu when mouse hovers over it.
	    	g.drawImage(Images.main_menu_instructions_hover, instructions.x - 3, instructions.y - 18, null);
	    if(MouseInput.MOUSE.intersects(scores)) // Changes the high scores image for the main menu when mouse hovers over it.
			g.drawImage(Images.main_menu_high_scores_hover, scores.x - 11, scores.y - 18, null);
	    if(MouseInput.MOUSE.intersects(quit)) // Changes the quit image for the main menu when mouse hovers over it.
			g.drawImage(Images.main_menu_quit_hover, quit.x - 2, quit.y - 20, null);
	}
	
	public void render(Graphics g){
		
		g.drawImage(Images.main_menu_background, 0, 0, Reference.WIDTH, Reference.HEIGHT, null);
		drawButton(g, play, "", 0);
		drawButton(g, options, "", 0);
		drawButton(g, instructions, "", 0);
		drawButton(g, scores, "", 0);
		drawButton(g, quit, "", 0);
		
		
		
		
	}
}
