package com.fritmk.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 베스트 앨범
 * 문제 유형 : 해시
 * 난이도 : 3
 * https://school.programmers.co.kr/learn/courses/30/lessons/42579
 * 음.. set
 */
public class Solution22 {

    public int[] solution(String[] genres, int[] plays) {

        HashMap<String, Integer> genre = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {
            genre.put( genres[i], genre.getOrDefault(genres[i], 0) + plays[i]);
        }

        ArrayList<String> genreName = new ArrayList<>(genre.keySet());
        genreName.sort((o1, o2) -> genre.get(o2).compareTo(genre.get(o1)));

        HashMap<String, HashMap<Integer, Integer>> songsByGenre = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {
            String g = genres[i];
            HashMap<Integer, Integer> playsBySong = songsByGenre.getOrDefault( g, new HashMap<>() );
            playsBySong.put(i, plays[i]);
            songsByGenre.put(g, playsBySong);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(String g : genreName) {
            HashMap<Integer, Integer> songs = songsByGenre.get(g);

            ArrayList<Integer> songId = new ArrayList<>(songs.keySet());
            songId.sort((o1, o2) -> songs.get(o2) - songs.get(o1));

            result.add(songId.get(0));
            if(songId.size() > 1) {
                result.add(songId.get(1));
            }

        }

        return result.stream().mapToInt(Integer::intValue).toArray();


    }

}