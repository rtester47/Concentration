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

import com.spectregames.concentration.libs.Reference;
import com.spectregames.concentration.utils.Images;


/**
 *	Project: Concentration
 * 	Package: com.spectregames.concentration.screens
 *	Class: SplashScreen
 *
 * @author Phantom Coder
 * @license Apache Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
 * 
 *	
 */
public class SplashScreen{
	
	public void render(Graphics g){
		g.drawImage(Images.splash_screen, 0, 0, Reference.WIDTH, Reference.HEIGHT, null);
	}
}
