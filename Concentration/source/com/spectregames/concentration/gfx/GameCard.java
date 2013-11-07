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
package com.spectregames.concentration.gfx;

import java.awt.Graphics;

import com.spectregames.concentration.libs.Card;
import com.spectregames.concentration.utils.ResourceLoader;

/**
 * Project Name: Concentration
 * Package Name: com.spectregames.concentration.gfx
 * File Name:    GameCard.java
 * Class:        GameCard
 *
 * @author Phantom Coder
 * @license http://www.apache.org/license/LICENSE-2.0
 *
 */
public class GameCard extends Card {


	public GameCard(int x, int y, int type, ResourceLoader res) {
		super(x, y, type, res);
	}

	public void tick() {
		
	}

	public void render(Graphics g) {
		if(cardState == state.back)
			g.drawImage(res.card[0], x, y, null);
		else
			g.drawImage(res.card[type], x, y, null);
	}

	
	
}
