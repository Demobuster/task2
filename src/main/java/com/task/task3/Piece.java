package com.task.task3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Sergey
 */
class Piece {

	private ArrayList<String> stringsOfLyric;

	/**
	 * Providing data from file
	 *
	 * @param path
	 *            file path
	 */
	public Piece(String file) {
		stringsOfLyric = new ArrayList<String>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home") + "/app-root/data/" + file));
			
			String tmp = "";
			while ((tmp = br.readLine()) != null) {
				stringsOfLyric.add(tmp);
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getLyric() {
		String lyric = "";

		for (String strings : stringsOfLyric) {
			lyric += strings;
			lyric += '\n';
		}

		return lyric;
	}

	/**
	 * String sorting
	 */
	public void sort() {
		Collections.sort(stringsOfLyric, new StringsLengthComparator());
	}

	public ArrayList<String> getStringsOfLyric() {
		return stringsOfLyric;
	}
}
