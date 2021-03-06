package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameOverScreen implements Screen {
	private Viewport viewport;
	private Stage stage;
	private Game game;
	
	private static final int gameOver_width = 190; //tamanho na tela 
	private static final int gameOver_height = 70;
	
	private Texture gameOverBanner;
	
	public GameOverScreen(Game game) {
		this.game = game;
		viewport = new FitViewport(BioPirataria.V_WIDTH, BioPirataria.V_HEIGHT, new OrthographicCamera());
		stage = new Stage(viewport, ((BioPirataria)game).batch);
		Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);
		
		gameOverBanner = new Texture("gameover.png"); // cria textura do banner da tela game over
		
		Table table = new Table();
		table.center();
		table.setFillParent(true);
		Label clickToReturn = new Label("Click para Retornar ao Menu ", font);
		table.add(clickToReturn).expandX().padTop(500f);
		table.row();
		stage.addActor(table);
	}
	//
	@Override
	public void dispose() {
		game.setScreen(new MenuScreenRetorno((BioPirataria)game));
		stage.dispose();
	}
//
	@Override
	public void hide() {}

	@Override
	public void pause() {}

	@Override
	public void render(float dt) {
		if (Gdx.input.justTouched()) { 
			dispose();
			BioPirataria.manager.get("Songs/Venus.ogg", Music.class).pause();
		}
		Gdx.gl.glClearColor(0, 0, 0, 1); //COR DA TELA = PRETO
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		BioPirataria.batch.begin();
		BioPirataria.batch.draw(gameOverBanner, 242, 345); //POSI��O DA IMAGEM TITULO na TELA DO JOGO
		BioPirataria.batch.end();
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {}

	@Override
	public void resume() {}

	@Override
	public void show() {}
	
}
