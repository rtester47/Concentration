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
package com.spectregames.concentration;

import java.awt.Graphics;
import java.util.LinkedList;

import com.spectregames.concentration.libs.Card;

/**
 * Project Name: Concentration
 * Package Name: com.spectregames.concentration
 * File Name:    Handler.java
 * Class:        Handler
 *
 * @author Phantom Coder
 * @license http://www.apache.org/license/LICENSE-2.0
 *
 */
public class Handler {
	
	public LinkedList<Card> card = new LinkedList<Card>();
	
	private Card tempcard;
	
	public void tick(){
		for(int i = 0; i < card.size(); i++){
			tempcard = card.get(i);
			
			tempcard.tick();
		}
	}
	
	public void render(Graphics g){
		for(int i = 0; i < card.size(); i++){
			tempcard = card.get(i);
			
			tempcard.render(g);
		}
	}
	
	public void addcard(Card card){
		this.card.add(card);
	}
	
	public void removecard(Card card){
		this.card.remove(card);
	}
	
}
