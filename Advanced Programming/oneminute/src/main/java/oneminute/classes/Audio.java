package oneminute.classes;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Audio {
    private MediaPlayer gameBgm;
    private MediaPlayer shoppingBgm;
    private AudioClip buttonStart;
    private AudioClip buttonClick;
    private AudioClip buttonTick;
    private AudioClip bookFlip;
    private AudioClip cashierRegister;

    public Audio() {
        // Initialize background music players
        gameBgm = new MediaPlayer(new Media(getClass().getResource("/oneminute/audio/bgm-game.mp3").toExternalForm()));
        shoppingBgm = new MediaPlayer(new Media(getClass().getResource("/oneminute/audio/bgm-shopping.mp3").toExternalForm()));

        // Initialize sound effect clips
        buttonStart = new AudioClip(getClass().getResource("/oneminute/audio/button-start.mp3").toExternalForm());
        buttonClick = new AudioClip(getClass().getResource("/oneminute/audio/button-click.mp3").toExternalForm());
        buttonTick = new AudioClip(getClass().getResource("/oneminute/audio/button-tick.mp3").toExternalForm());
        bookFlip = new AudioClip(getClass().getResource("/oneminute/audio/button-bookflip.mp3").toExternalForm());
        cashierRegister = new AudioClip(getClass().getResource("/oneminute/audio/bgm-cashier.mp3").toExternalForm());
    }

    // Background Music Settings
    public void playBackgroundMusic(String type) {
        stopAllBackgroundMusic();
        switch (type) {
            case "game":
                playMusic(gameBgm);
                break;
            case "shopping":
                playMusic(shoppingBgm);
                break;
            default:
                break;
        }
    }

    private void playMusic(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.play();
        }
    }

    public void stopAllBackgroundMusic() {
        stopMusic(gameBgm);
        stopMusic(shoppingBgm);
    }

    private void stopMusic(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    public void setBackgroundMusicVolume(String type, double volume) {
        switch (type) {
            case "game":
                setVolume(gameBgm, volume);
                break;
            case "shopping":
                setVolume(shoppingBgm, volume);
                break;
            default:
                break;
        }
    }

    private void setVolume(MediaPlayer mediaPlayer, double volume) {
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(volume);
        }
    }

    // Sound Effect Settings
    public void playSoundEffect(String type) {
        switch (type) {
            case "buttonStart":
                playSoundEffect(buttonStart);
                break;
            case "buttonClick":
                playSoundEffect(buttonClick);
                break;
            case "buttonTick":
                playSoundEffect(buttonTick);
                break;
            case "bookFlip":
                playSoundEffect(bookFlip);
                break;
            case "cashierRegister":
                playSoundEffect(cashierRegister);
                break;
            default:
                break;
        }
    }

    private void playSoundEffect(AudioClip clip) {
        clip.play();
    }

    public void setSoundEffectVolume(AudioClip clip, double volume) {
        if (clip != null) {
            clip.setVolume(volume);
        }
    }
}
