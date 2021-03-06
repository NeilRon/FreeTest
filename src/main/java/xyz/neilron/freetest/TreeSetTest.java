package xyz.neilron.freetest;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by Neil on 2016/10/13.
 * TreeSet Test.
 */

class Song {

    private String name;
    private int score;

    Song(String name) {
        this.name = name;
        this.score = 3;
    }

    void setScore(int score) {
        this.score = score;
    }

    int getScore() {
        return score;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(this.name)
                .toHashCode();
    }

    @Override
    public String toString() {
        return String.format("%s\t%d", this.name, this.score);
    }
}

public class TreeSetTest {
    public static void main(String[] args) {

        // 定义一个无序的HashSet和一个按分数排序的TreeSet
        HashSet<Song> hashSet = new HashSet<Song>();
        TreeSet<Song> treeSet = new TreeSet<Song>(new Comparator<Song>() {
            public int compare(Song o1, Song o2) {
                return o2.getScore() - o1.getScore();
            }
        });

        Song song1 = new Song("前世情人");
        Song song2 = new Song("床边故事");

        treeSet.add(song1);
        treeSet.add(song2);
        hashSet.add(song1);
        hashSet.add(song2);

        System.out.println("TreeSet Result:");
        for (Song song : treeSet){
            System.out.println(song);
        }

        System.out.println("\nHashSet Result:");
        for (Song song : hashSet){
            System.out.println(song);
        }

        song2.setScore(4);

        treeSet.add(song2);

        System.out.println("\nTreeSet Result After setScore:");
        for (Song song : treeSet){
            System.out.println(song);
        }

    }
}
