/*
*	Date: Oct 16, 2013
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
package com.spectregames.concentration.output;

import java.util.Random;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

import com.spectregames.concentration.libs.GameConstants;

/**
 * Project Name: Concentration
 * Package Name: com.spectregames.concentration.output
 * File Name:    TickSound.java
 * Class:        TickSound
 *
 * @author Phantom Coder
 * @license http://www.apache.org/license/LICENSE-2.0
 *
 */
public class ClickSound extends Thread{

	  public void run() {
		    try {
				ClickSound.click();
			} catch (LineUnavailableException | InterruptedException e) {
				e.printStackTrace();
			}
		  }

	/**
	 * 
	 */
	  public static void click() throws LineUnavailableException, InterruptedException {
		    AudioFormat af = new AudioFormat(
	          GameConstants.SAMPLE_RATE, // sampleRate
	          8,           // sampleSizeInBits
	          1,           // channels
	          true,        // signed
	          true);      // bigEndian
		    SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
		    sdl.open(af);
		    sdl.start();

		    byte[] buf = new byte[1];
		    Random r = new Random();
		    boolean silence = true;
		    for (int i=0 ; i < 280 ; i++) {
		      while(r.nextInt() % 5 != 0) {
		          buf[0] =
		            silence ? 0 :
		              (byte)Math.abs(r.nextInt() %
		                  (int)(1. + 80. * (1. + Math.cos(((double)i)
		                      * Math.PI /280.))));
		          i++;
		          sdl.write(buf,0,1);
		      }
		      silence = !silence;
		  }
		    sdl.drain();
		    sdl.stop();
		    sdl.close();
		  }
}
