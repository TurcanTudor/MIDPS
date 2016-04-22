package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.math.Rectangle;

import java.sql.Time;
import java.util.Iterator;
import java.util.Random;

public class GameScreen implements Screen {

    final Mygame game;
    OrthographicCamera camera;
    SpriteBatch batch;
    Texture dropImage;
    Texture bucketImage;
    Sound dropSound;
    Music rainMusic;
    Rectangle bucket;
    Vector3 touchPos;
    Array<Rectangle> raindrops;
    long lastDropTime;
    long lastDropTime2;
    int dropGetchered;
    int lives=3;
    Texture dropImage1;
     int t=0;
    Array<Rectangle> raindrops2;

    public  GameScreen (final Mygame gam) {
        this.game=gam;


        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        batch = new SpriteBatch();

        touchPos = new Vector3();

        dropImage = new Texture("rsz_sock.png");
        bucketImage = new Texture("laundry.png");
        dropImage1= new Texture("rsz_t-shirt.png");


        dropSound = Gdx.audio.newSound(Gdx.files.internal("catch.mp3"));



        bucket = new Rectangle();
        bucket.x = 800 / 2 - 120 / 2;
        bucket.y = 20;
        bucket.width = 120;
        bucket.height = 64;

        raindrops = new Array<Rectangle>();
        spawnRaindrop();

        raindrops2 = new Array<Rectangle>();
        spawnRaindrop2();

    }

    private void spawnRaindrop(){
        Rectangle raindrop = new Rectangle();
        raindrop.x = MathUtils.random(0, 800-64);
        raindrop.y = 480;
        raindrop.width = 64;
        raindrop.height = 64;
        raindrops.add(raindrop);

        lastDropTime = TimeUtils.nanoTime();

    }

    private void spawnRaindrop2(){
        Rectangle raindrop2 = new Rectangle();
        raindrop2.x = MathUtils.random(0, 800-64);
        raindrop2.y = 480;
        raindrop2.width = 64;
        raindrop2.height = 64;
        raindrops2.add(raindrop2);

        lastDropTime2 = TimeUtils.nanoTime();

    }


    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor(1, 0.8f,0.9f , 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.font.draw(game.batch, "Haine Prinse:  " + dropGetchered, 0, 480);
        game.font.draw(game.batch,"Vieti:  "+lives,700,480);
        game.batch.draw(bucketImage, bucket.x, bucket.y);

        for (Rectangle raindrop: raindrops){
            game.batch.draw(dropImage, raindrop.x, raindrop.y);

        }
        for(Rectangle raindrop2:raindrops2){
            game.batch.draw(dropImage1,raindrop2.x,raindrop2.y);
        }
        game.batch.end();

        if(Gdx.input.isTouched()){
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            bucket.x = (int) (touchPos.x -120 / 2);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) bucket.x -= 200 * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) bucket.x += 200 * Gdx.graphics.getDeltaTime();

        if (bucket.x < 0) bucket.x = 0;
        if (bucket.x > 800 - 120) bucket.x = 800 - 120;


        if (TimeUtils.nanoTime() - lastDropTime > 1000000000) spawnRaindrop();
        if(TimeUtils.nanoTime()-lastDropTime2>100000000) spawnRaindrop2();

        Iterator<Rectangle> iter = raindrops.iterator();
        Iterator<Rectangle> iter2= raindrops2.iterator();

        while (iter.hasNext()){

            Rectangle raindrop = iter.next();
            Rectangle raindrop2=iter2.next();
            raindrop.y -= 200 * Gdx.graphics.getDeltaTime();
            raindrop2.y -= 100 * Gdx.graphics.getDeltaTime();


            if (raindrop.y + 64 < 0){ iter.remove();
            lives--;
            }
            if (raindrop2.y + 64 < 0){ iter2.remove();
                lives--;
            }
            if (raindrop.overlaps(bucket)){
                dropGetchered++;
                dropSound.play();
                iter.remove();
            }

            if (raindrop2.overlaps(bucket)){
                dropGetchered++;
                dropSound.play();
                iter2.remove();
            }
            if(lives==0){
                game.setScreen(new MainMenuScreen(game));
                dispose();

            }
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

        dropImage.dispose();
        bucketImage.dispose();
        dropSound.dispose();
        rainMusic.dispose();

    }

    @Override
    public void show() {

    }
}
