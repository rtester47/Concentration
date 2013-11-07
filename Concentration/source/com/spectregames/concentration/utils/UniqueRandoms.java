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
package com.spectregames.concentration.utils;

/**
 * Project Name: Concentration
 * Package Name: com.spectregames.concentration.utils
 * File Name:    UniqueRandoms.java
 * Class:        UniqueRandoms
 *
 * @author Jeeter
 * @license http://www.apache.org/license/LICENSE-2.0
 *
 */
public class UniqueRandoms {

	private int numsLeft;
	private int MAX_VALUE;
	int[] chooser;
	
	public UniqueRandoms(int startCounter){
	    MAX_VALUE = startCounter;
	    numsLeft = startCounter;
	    chooser = new int[MAX_VALUE];
	    for (int i = 1; i <= chooser.length; i++) {
	        chooser[i-1] = i;
	    }
	}
	
	public int nextInt() {
	    if(numsLeft == 0){
	        return 0;
	    }
	    int a = chooser[(int)(Math.random() * MAX_VALUE)];
	    if(a == 0) {
	        return this.nextInt();
	    }
	    chooser[a-1] = 0;
	    numsLeft--;
	    return a;

	}
}
