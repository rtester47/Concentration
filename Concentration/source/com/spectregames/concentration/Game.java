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
package com.spectregames.concentration;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.spectregames.concentration.enums.GameDifficulity;
import com.spectregames.concentration.enums.GameState;
import com.spectregames.concentration.gfx.Renderer;
import com.spectregames.concentration.input.MouseInput;
import com.spectregames.concentration.libs.GameConstants;
import com.spectregames.concentration.screens.Menu;
import com.spectregames.concentration.screens.SplashScreen;
import com.spectregames.concentration.utils.ResourceLoader;

/**
 *	Project: Concentration
 * 	Package: com.spectregames.concentration
 *	Class: Game
 *
 * @author Phantom Coder
 * @license Apache Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
 * 
 *	
 */
public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = -1572409472404955765L;
	private static JFrame frame= new JFrame();
	private static Game game = new Game();
	public static GameState state = GameState.MENU;
	public static GameDifficulity difficulity = GameDifficulity.EXTREME;
	
	private boolean isRunning = false;
	private Thread game_thread;
	private Renderer gfx;
	public Menu menu;
	public SplashScreen splash;
		
	public static Game getInstance(){
		return game;
	}
	
	public Menu getMenu(){
        return menu;
    }
	
	public void init(){
		ResourceLoader.loadImages();
		ResourceLoader.loadAudio();
		splash = new SplashScreen();
		menu = new Menu();
		gfx = new Renderer();
		MouseInput mouse = new MouseInput();
	    this.addMouseListener(mouse);
	    this.addMouseMotionListener(mouse);
	    
	    

	}
	
	public void tick(){
		
	}
	
	public void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(new Color(6,0,40));
		g.fillRect(0, 0, GameConstants.WIDTH, GameConstants.HEIGHT);
		
		///////////////////////////////////////////////////
		gfx.renderBackground(g);
		gfx.renderForeground(g);
		
		g.dispose();
		bs.show();
		
	}
	
	@Override
	public void run() {
		init();
		long lastTime = System.nanoTime();
		final double numTicks = 60.0;
		double n = 1000000000 / numTicks;
		double delta = 0;
		int frames = 0;
		int ticks = 0;
		long timer = System.currentTimeMillis();
		
		while (isRunning){
			long currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / n;
			lastTime = currentTime;
			
			if (delta >= 1){
				tick();
				ticks++;
				delta--;
			}
			
			render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000){
				timer+=1000;
				
				//if (GameConstants.isDebugMode){
					//System.out.println("UDS: " + ticks + ", FPS: " + frames);
					frame.setTitle(GameConstants.TITLE + "          " + ticks + " UDS, FPS: " + frames);
				//}
				
			ticks=0;
			frames=0;
			}
		}
		stop();
	}
	
	public static void main(String[] args) {
		
		// Sets the game window size.
		game.setPreferredSize(new Dimension(GameConstants.WIDTH, GameConstants.HEIGHT));
		game.setMinimumSize(new Dimension(GameConstants.WIDTH, GameConstants.HEIGHT));
		game.setMaximumSize(new Dimension(GameConstants.WIDTH, GameConstants.HEIGHT));
		

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		//Changes the default java program icon to a custom one.
		Image icon = toolkit.getImage(GameConstants.ICONS + "icon.png");

		// Changes the default mouse cursor.
		Image cursor = toolkit.getImage(GameConstants.CURSORS + "hand_cursor.gif");
		
		frame.add(game);
        frame.setTitle(GameConstants.TITLE); //sets the title
        frame.setIconImage(icon); //sets the icon we specified above
        frame.setCursor(toolkit.createCustomCursor(cursor, new Point(frame.getX(), frame.getY()), "cursor")); //sets the cursor we specified above.
		frame.setSize(GameConstants.WIDTH, GameConstants.HEIGHT); //sets the size of our window
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.pack();
				
		game.start();
	}
	
	private synchronized void start(){
		if (isRunning)
			return;
		isRunning = true;
		game_thread = new Thread(this);
		game_thread.start();
	}
	
	private synchronized void stop(){
		if (!isRunning)
			return;
		isRunning = false;
		
		try {
			game_thread.join();
		} catch (InterruptedException e) { e.printStackTrace(); }
		
		System.exit(1);
	}	
}
