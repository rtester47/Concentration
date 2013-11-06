/*
*	Date: Oct 23, 2013
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
package com.spectregames.concentration.utils;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.spectregames.concentration.input.MouseInput;
import com.spectregames.concentration.libs.GameConstants;

/**
 * Project Name: Concentration
 * Package Name: com.spectregames.concentration.utils
 * File Name:    Button.java
 * Class:        Button
 *
 * @author Phantom Coder
 * @license http://www.apache.org/license/LICENSE-2.0
 *
 */
@SuppressWarnings("serial")
public class Button extends Rectangle {



	public Button() {
		super();
	}

	public Button(Rectangle r) {
		super(r);

	}

   public Button(Point p) {
        super(p);

    }

   public Button(Dimension d) {
        super(d);

    }

	public Button(int width, int height) {
		super(width, height);

	}



    public Button(Point p, Dimension d) {
        super(p, d);

    }
    
    public Button(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
  	
	public void drawButton(Graphics g, int offsetX, int offsetY, int offsetHX, int offsetHY, int offsetPX, int offsetPY, BufferedImage image, BufferedImage hoverImage, BufferedImage pressedImage){
        
        if(!GameConstants.isPressed && MouseInput.MOUSE.intersects(this))
            g.drawImage(hoverImage, x - offsetHX, y - offsetHY, null);
        else if(GameConstants.isPressed && MouseInput.MOUSE.intersects(this))
            g.drawImage(pressedImage, x - offsetPX, y - offsetPY, null);
        else
            g.drawImage(image, x - offsetX, y - offsetY, null);
	}
}
