package com.mygdx.game;
//main.Game

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BioPirataria extends Game {
	public static SpriteBatch batch;
	public static final int V_WIDTH = 800;
	public static final int V_HEIGHT = 600;
	public static final float PPM =100;

	// Filtro para colis�o.
	public static final short HEROI_BIT = 2;
	public static final short ENEMY_BIT = 4;
	public static final short TERRAIN_BIT = 8;
	public static final short AGUA_BIT = 16;
	public static final short LAVA_BIT = 32;
	public static final short BORDAS_BIT = 64;
	public static final short TIRO_BIT = 128;
	public static final short TIROENEMY_BIT = 256;
	
	
	//Audio
	public static AssetManager manager;
	
	@Override
	public void create () {
        batch = new SpriteBatch();
        manager = new AssetManager();
        manager.load("Songs/Venus.ogg", Music.class); // musica do jogo
        manager.load("Songs/Tiro2.mp3", Sound.class); // som para tiro do heroi
        manager.load("Songs/sfx_weapon_singleshot13.wav", Sound.class); // som para tiro do inimigo
        manager.load("Songs/sfx_movement_jump2.wav", Sound.class); // som para colis�es
        manager.load("Songs/Mercury.wav", Sound.class);
        manager.load("Songs/Fogo.mp3", Sound.class); // som para quando pisar na lava
        manager.load("Songs/ocean3.mp3", Sound.class); // som para quando pisar na agua
        manager.load("Songs/laser6.wav", Sound.class);
        manager.finishLoading();
        this.setScreen(new MenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}

}
