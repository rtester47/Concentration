/*
*	Date: Oct 22, 2013
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

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import com.spectregames.concentration.libs.GameConstants;

/**
 * Project Name: Concentration
 * Package Name: com.spectregames.concentration.utils
 * File Name:    AudioPlayer.java
 * Class:        AudioPlayer
 *
 * @author Phantom Coder
 * @license http://www.apache.org/license/LICENSE-2.0
 *
 */
public class AudioPlayer {

	// A hash map to contain all of our game's sound effects
    private static Map<String, Sound> soundMap = new HashMap<String, Sound>();
    
    // A hash map to contain all of our game's music
    private static Map<String, Music> musicMap = new HashMap<String, Music>();
    

    
  
    public static void addSound(String key, String path){
        try {
            soundMap.put(key, new Sound(GameConstants.SFX + path));
        } catch (SlickException e) {
            
            e.printStackTrace();
        }
    }
    
  
    public static void addMusic(String key, String path){
        try {
            musicMap.put(key, new Music(GameConstants.BGM + path));
        } catch (SlickException e) {
            
            e.printStackTrace();
        }
    }
 
 
    public static Sound getSound(String key){
        return soundMap.get(key);
    }
    
    
    public static Music getMusic(String key){
        return musicMap.get(key);
    }
 
    
    public static void playSound(String key){
        soundMap.get(key).play(); 
    }
    
    
    public static void playMusic(String key){
        musicMap.get(key).loop(); 
    }
}
