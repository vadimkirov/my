package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        System.out.println(detectAllWords(crossword, "home", "same","re","m","").toString());

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        List<Word> resultList = new ArrayList<>();
        int [] vremen;
        List<Integer> poiskX = new ArrayList<>();
        List<Integer> poiskY = new ArrayList<>();

        for (String word : words){
            if(word.length() == 0) break;
            for (int i = 0; i < crossword.length; i++)
            {
                for (int j = 0; j <crossword[0].length ; j++)
                {
                    char currentChar = (char) crossword[i][j];

                    if(word.charAt(0) == currentChar)
                    {
                        if (word.length()== 1)
                        {
                            Word foundWorld = new Word(word);
                            foundWorld.setStartPoint(j,i);
                            foundWorld.setEndPoint(j,i);
                            resultList.add(foundWorld);
                        }
// выбираем направление поиска
                        if( i+(word.length()-1) <= crossword.length ) poiskX.add(1);
                        if( j+(word.length()-1) <= crossword[0].length ) poiskY.add(1);
                        if( j-(word.length()-1) >= 0 ) poiskY.add(-1);
                        if( i-(word.length()-1) >= 0 ) poiskX.add(-1);

                        for (Integer varPoiskaX: poiskX )
                        {
                            for (Integer varPoiskaY: poiskY )
                            {
                                vremen = my.find(crossword, word, varPoiskaX, varPoiskaY, i, j);
                                if (vremen !=null)
                                {
                                    Word foundWorld = new Word(word);
                                    foundWorld.setStartPoint(vremen[0],vremen[1]);
                                    foundWorld.setEndPoint(vremen[2],vremen[3]);
                                    resultList.add(foundWorld);
                                }
                            }
                            poiskY.clear();
                        }
                        poiskX.clear();
                        }
                    }
                }
            }



        return resultList;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
