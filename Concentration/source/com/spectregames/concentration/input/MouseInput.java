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
package com.spectregames.concentration.input;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

import com.spectregames.concentration.Game;
import com.spectregames.concentration.Handler;
import com.spectregames.concentration.enums.GameState;
import com.spectregames.concentration.gfx.GameCard;
import com.spectregames.concentration.libs.Audio;
import com.spectregames.concentration.libs.GameConstants;
import com.spectregames.concentration.utils.AudioPlayer;
import com.spectregames.concentration.utils.ResourceLoader;
import com.spectregames.concentration.utils.UniqueRandoms;

/**
 *	Project: Concentration
 * 	Package: com.spectregames.concentration.input
 *	Class: MouseInput
 *
 * @author Phantom Coder
 * @license Apache Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
 * 
 *	
 */

@SuppressWarnings("unused")
public class MouseInput extends MouseAdapter {
    
    public static int MOUSE_X, MOUSE_Y;
    public static Rectangle MOUSE = new Rectangle(1,1,1,1);
    ArrayList<Integer> al = new ArrayList<Integer>();
    UniqueRandoms randp;
    UniqueRandoms randpd;
    int[] cards;
    
    Handler handler;
    ResourceLoader res;
    
    public MouseInput(Handler handler, ResourceLoader res){
    	this.handler = handler;
    	this.res =  res;
    }
  
 
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    
    @Override
    public void mouseMoved(MouseEvent e) {
        
    	MOUSE_X = e.getX();
        MOUSE_Y = e.getY();
        MOUSE = new Rectangle(MOUSE_X, MOUSE_Y, 1, 1);

        switch (Game.state) {
		case CREDITS:
			break;
		case GAME:
			break;
		case INSTRUCTIONS:
			break;
		case MENU:
            if ((MOUSE.intersects(Game.getInstance().getMenu().play)           //Only do this if the mouse is hovering over a button and the sound has not already played
                    || MOUSE.intersects(Game.getInstance().getMenu().options)
                    || MOUSE.intersects(Game.getInstance().getMenu().instructions)
                    || MOUSE.intersects(Game.getInstance().getMenu().scores)
                    || MOUSE.intersects(Game.getInstance().getMenu().quit))
                    && !GameConstants.hasPlayedTickSound) {
                
                AudioPlayer.playSound(Audio.SFX_HOVER);
                GameConstants.hasPlayedTickSound = true;  //The sound has played, so lets set it to true
                
            }else if(!(MOUSE.intersects(Game.getInstance().getMenu().play)    //If the mouse is not hovering over a button, then reset the boolean to false
                    || MOUSE.intersects(Game.getInstance().getMenu().options)
                    || MOUSE.intersects(Game.getInstance().getMenu().instructions)
                    || MOUSE.intersects(Game.getInstance().getMenu().scores)
                    || MOUSE.intersects(Game.getInstance().getMenu().quit))
                    && GameConstants.hasPlayedTickSound){
                
            	GameConstants.hasPlayedTickSound  = false;
            }
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
 
  
    @Override
    public void mousePressed(MouseEvent e){
    	
    	GameConstants.isPressed = true;
	    
    	int mouse = e.getButton();
	    Rectangle rect = new Rectangle(e.getX(), e.getY(), 1, 1); 
    	
	    if (mouse == MouseEvent.BUTTON1) {   		
    		switch (Game.state){
			case CREDITS:
				break;
			case GAME:
				break;
			case INSTRUCTIONS:
				break;
			case MENU:
				if (rect.intersects(Game.getInstance().getMenu().play)) { 
                    AudioPlayer.playSound(Audio.SFX_CLICK);
                    
                } else if (rect.intersects(Game.getInstance().getMenu().options)) {
                    AudioPlayer.playSound(Audio.SFX_CLICK);
                    
                } else if (rect.intersects(Game.getInstance().getMenu().instructions)) {
                    AudioPlayer.playSound(Audio.SFX_CLICK);    
                
                } else if (rect.intersects(Game.getInstance().getMenu().scores)) {
                    AudioPlayer.playSound(Audio.SFX_CLICK);
                
                } else if (rect.intersects(Game.getInstance().getMenu().quit)) {
                    AudioPlayer.playSound(Audio.SFX_CLICK);    
                }
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

    
    public void mouseReleased(MouseEvent e){
        int mouse = e.getButton();  //used to check what button was clicked
        Rectangle rect = new Rectangle(e.getX(), e.getY(), 1, 1);  //creates a 1x1 rectangle around the cursor to be used to check where it was clicked

        if (mouse == MouseEvent.BUTTON1) {  //only do this stuff if the left mouse button was clicked

            switch (Game.state) {  //depending on what state the game is in, check for the following cases
                case GAME:
                    break;
                case MENU:
                	
                	// If we released our mouse button while in the bounds main menu's play button, 
                	// change the games GameState to GAME and set isPressed to false.
                    if (rect.intersects(Game.getInstance().getMenu().play)){
                        Game.state = GameState.GAME;
                        GameConstants.isPressed = false;
                     
                        int offsetX = 130;
                        int offsetY = 100;
                        
        				switch(Game.difficulity){
        				case EASY:
        					
        					//generate cards
        					randp = new UniqueRandoms(6);
        					randpd = new UniqueRandoms(6);
                            cards = new int[12];
                            
                               	for (int i = 0; i < 6; i++) {
                            		cards[i] = randp.nextInt();
                            		al.add(new Integer(cards[i]));
                            		System.out.print(cards[i] + ", ");
                            		//Collections.shuffle(al);
                               		handler.addcard(new GameCard((offsetX) + i*100, (GameConstants.CENTER_Y - offsetY), cards[i], res));
                            	}
                               	for (int i = 0; i < 6; i++) {
                            		cards[i] = randpd.nextInt();
                            		al.add(new Integer(cards[i]));
                            		System.out.print(cards[i] + ", ");
                            		//Collections.shuffle(al);
                            		handler.addcard(new GameCard((offsetX) + i*100, (GameConstants.CENTER_Y), cards[i], res));
                            		
                            	}
                            //end of generate cards
                            System.out.print("\n");
                            System.out.println("Contents of al: " + al);
                    		
                            Game.state = GameState.EASY_GAME;
        					break;
        				
        				case EXTREME:

        					//generate cards
        					randp = new UniqueRandoms(24);
        					randpd = new UniqueRandoms(24);
                            cards = new int[48];
                            
                               	for (int i = 0; i < 24; i++) {
                            		cards[i] = randp.nextInt();
                            		al.add(new Integer(cards[i]));
                            		System.out.print(cards[i] + ", ");
                            		//handler.addcard(new GameCard((offsetX) + i*90, (GameConstants.CENTER_Y - offsetY), cards[i], res));
                            	}
                               	for (int i = 0; i < 24; i++) {
                            		cards[i] = randpd.nextInt();
                            		al.add(new Integer(cards[i]));
                            		System.out.print(cards[i] + ", ");
                            		//handler.addcard(new GameCard((offsetX) + i*90, (GameConstants.CENTER_Y), cards[i], res));
                            	}
                            //end of generate cards
                            System.out.print("\n");
                            System.out.println("Contents of al: " + al);
                            
        					Game.state = GameState.EXTREME_GAME;
        					break;
        				
        				case HARD:
        				
        					//generate cards
        					randp = new UniqueRandoms(18);
        					randpd = new UniqueRandoms(18);
                            cards = new int[36];
                            
                               	for (int i = 0; i < 18; i++) {
                            		cards[i] = randp.nextInt();
                            		al.add(new Integer(cards[i]));
                            		System.out.print(cards[i] + ", ");
                            		//handler.addcard(new GameCard((offsetX) + i*90, (GameConstants.CENTER_Y - offsetY), cards[i], res));
                            	}
                               	for (int i = 0; i < 18; i++) {
                            		cards[i] = randpd.nextInt();
                            		al.add(new Integer(cards[i]));
                            		System.out.print(cards[i] + ", ");
                            		//handler.addcard(new GameCard((offsetX) + i*90, (GameConstants.CENTER_Y), cards[i], res));
                            	}
                            //end of generate cards
                            System.out.print("\n");
                            System.out.println("Contents of al: " + al);
                            
        					Game.state = GameState.HARD_GAME;
        					break;
        				case NORMAL:
        					        					
        					//generate cards
        					randp = new UniqueRandoms(12);
        					randpd = new UniqueRandoms(12);
                            cards = new int[24];
                            
                               	for (int i = 0; i < 12; i++) {
                            		cards[i] = randp.nextInt();
                            		al.add(new Integer(cards[i]));
                            		System.out.print(cards[i] + ", ");
                            		//handler.addcard(new GameCard((offsetX) + i*90, (GameConstants.CENTER_Y - offsetY), cards[i], res));
                            	}
                               	for (int i = 0; i < 12; i++) {
                            		cards[i] = randpd.nextInt();
                            		al.add(new Integer(cards[i]));
                            		System.out.print(cards[i] + ", ");
                            		//handler.addcard(new GameCard((offsetX) + i*90, (GameConstants.CENTER_Y), cards[i], res));
                            	}
                            //end of generate cards
                            System.out.print("\n");
                            System.out.println("Contents of al: " + al);
        					
        					Game.state = GameState.NORMAL_GAME;
        					break;
        				default:
 
        				}
        				break;
        				
                        
 
                       
                       
                    }else GameConstants.isPressed = false;
                    
                    // If we released our mouse button while in the bounds main menu's options button, 
                	// change the games GameState to OPTIONS and set isPressed to false.
                    if (rect.intersects(Game.getInstance().getMenu().options)){ 
                    	Game.state = GameState.OPTIONS;
                    	GameConstants.isPressed = false;
                    }else GameConstants.isPressed = false;
                    
                    // If we released our mouse button while in the bounds main menu's instructions button, 
                	// change the games GameState to INSTRUCTIONS and set isPressed to false.
                    if (rect.intersects(Game.getInstance().getMenu().instructions)){
                        Game.state = GameState.INSTRUCTIONS;
                        GameConstants.isPressed = false;
                    }else GameConstants.isPressed = false;
                    
                    // If we released our mouse button while in the bounds main menu's high scores button, 
                	// change the games GameState to SCORES and set isPressed to false.
                    if (rect.intersects(Game.getInstance().getMenu().scores)){
                        Game.state = GameState.SCORES;
                    	GameConstants.isPressed = false;
            		}else GameConstants.isPressed = false;
                    
                    // If we released our mouse button while in the bounds main menu's quit button, 
                	// change the games GameState to QUITTING and set isPressed to false.
                    if (rect.intersects(Game.getInstance().getMenu().quit)){
                        Game.state = GameState.QUITTING;
                    	GameConstants.isPressed = false;
                    	System.out.println("Program Ending");
                    	System.exit(1);
            		}else GameConstants.isPressed = false;
                    
                    break;
                    
                case OPTIONS:
                    break;
                    
                case PAUSE:
                    break;
                    
                default:
                    break;
            }
        }
    }
}
