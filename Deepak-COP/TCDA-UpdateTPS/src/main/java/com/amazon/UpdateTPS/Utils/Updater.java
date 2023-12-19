package com.amazon.UpdateTPS.Utils;

public interface Updater {
	
	public int update(String Fleet,String Region,String StableTPS,String CurrentTPS,String NoOfHosts);

}
