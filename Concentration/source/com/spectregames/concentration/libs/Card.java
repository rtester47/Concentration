/*
*	Date: Nov 6, 2013
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

import java.awt.Graphics;

import com.spectregames.concentration.utils.ResourceLoader;

/**
 * Project Name: Concentration
 * Package Name: com.spectregames.concentration.libs
 * File Name:    Card.java
 * Class:        Card
 *
 * @author Phantom Coder
 * @license http://www.apache.org/license/LICENSE-2.0
 *
 */
public abstract class Card {
	
	protected int x, y, type;
	protected enum state{
		show,
		back;
	}
	protected state cardState = state.show;
	protected ResourceLoader res;
	
	public Card(int x, int y, int type, ResourceLoader res)
	{
		this.x = x;
		this.y = y;
		this.type = type;
		this.res = res;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public int getY(){
		return y;
	}
	
	public int getX(){
		return x;
	}

}
