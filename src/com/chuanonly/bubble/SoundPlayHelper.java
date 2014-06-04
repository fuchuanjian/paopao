package com.chuanonly.bubble;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

public class SoundPlayHelper {

	private static SoundPlayHelper instance;
	private SoundPlayHelper() {
	}
	public static SoundPlayHelper getInstance()
	{
		if (instance == null)
		{
			instance = new SoundPlayHelper();
			instance.initSounds(APP.getContext());
		}
		return instance;
	}
	// 音效的音量
	int streamVolume;

	// 定义SoundPool 对象
	private MediaPlayer mMediaPlayer;
	// 定义HASH表

	
	public void initSounds(Context context) {

		// 获得声音设备和设备音量
		AudioManager mgr = (AudioManager) context
				.getSystemService(Context.AUDIO_SERVICE);
		streamVolume = mgr.getStreamVolume(AudioManager.STREAM_MUSIC);
		mMediaPlayer = MediaPlayer.create(context, R.raw.aftertherain);
		mMediaPlayer.setLooping(true);
	}

	
	public  void release()
	{
		mMediaPlayer.stop();
		mMediaPlayer.release();
		mMediaPlayer = null;
	}

	public void playBGMusic() {
		if (Util.isSoundSettingOn() && !mMediaPlayer.isPlaying())
		{			
			mMediaPlayer.start();
		}
	}

	public void stopBGMusic() {
		if (mMediaPlayer.isPlaying())
		{			
			mMediaPlayer.pause();
		}
	}
}

