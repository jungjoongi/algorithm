package com.jungjoongi.algorithm.programmers.exercise;


import java.util.*;
import java.util.stream.Collectors;

public class Main39 {

    public static void main(String[] args) {
        Arrays.stream(solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 2500, 150, 800, 2500})).forEach(System.out::println);

    }

    public static int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> genreMap = new HashMap<>();
        List<String> priorityGenreList = new ArrayList<>();

        for(int i = 0; i < genres.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        while (genreMap.size() > 0) {
            int max = 0;
            String indexKey = "";
            for(String key : genreMap.keySet()) {
                int value = genreMap.get(key);

                if(value > max) {
                    indexKey = key;
                    max = value;
                }
            }
            priorityGenreList.add(indexKey);
            genreMap.remove(indexKey);
        }

        List<Integer> result = new ArrayList<>();
        for(String genre : priorityGenreList) {

            List<Music> resultList = new ArrayList<>();
            for(int i = 0; i < genres.length; i++) {
                if(genre.equals(genres[i])) {
                    resultList.add(new Music(genres[i], plays[i], i ));
                }
            }
            resultList = resultList.stream().sorted((s1, s2) -> {
                return s2.getPlay() - s1.getPlay();
            }).sorted((s1, s2) -> {
                if(s1.getPlay() == s2.getIndex()) {
                    return s1.getIndex() - s2.getIndex();
                } else {
                    return s2.getPlay() - s1.getPlay();
                }
            }).collect(Collectors.toList());

            if(resultList.size() < 3) {
                for(Music music : resultList) {
                    result.add(music.getIndex());
                }
            } else {
                result.add(resultList.get(0).getIndex());
                result.add(resultList.get(1).getIndex());
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}

class Music {
    private String genre;
    private int play;
    private int index;

    public Music(String genre, int play, int index) {
        this.genre = genre;
        this.play = play;
        this.index = index;
    }

    public String getGenre() {
        return genre;
    }

    public int getPlay() {
        return play;
    }

    public int getIndex() {
        return index;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPlay(int play) {
        this.play = play;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
