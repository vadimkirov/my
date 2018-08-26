package com.javarush.task.task20.task2027;

 class my {

    static int [] find(int [][] crossword, String word, int varPoiskaX, int varPoiskaY, int i, int j) {
        int [] findMass = new int[4];
        int x = -1;
        int y = -1;
        int xEnd = -1;
        int yEnd = -1;



                    if ((char) crossword[i + ((word.length() - 1) * varPoiskaX)][j] == word.charAt(word.length() - 1))
                    {
                        x = j;
                        y = i;
                        yEnd = i + ((word.length() - 1) * varPoiskaX);
                        xEnd = j;
                    }

                    if (word.charAt(word.length() - 1) == (char) crossword[i + ((word.length() - 1) * varPoiskaX)][j + ((word.length() - 1) * varPoiskaY)])
                    {
                        x = j;
                        y = i;
                        yEnd = i + ((word.length() - 1) * varPoiskaX);
                        xEnd = j + ((word.length() - 1) * varPoiskaY);
                    }

                    if (word.charAt(word.length() - 1) == (char) crossword[i][j + ((word.length() - 1) * varPoiskaY)])
                    {
                        x = j;
                        y = i;
                        yEnd = i;
                        xEnd = j + ((word.length() - 1) * varPoiskaY);

                    }

                    // гдобальная проверка всего слова

                    String proverka = "";
                    if (xEnd > -1 && (word.length() > 2))
                    {
                        int deltaY = (yEnd - y) / (word.length() - 1);
                        int deltaX = (xEnd - x) / (word.length() - 1);

                        for (int k = 0; k < word.length(); k++)
                        {
                            int yk = y + k * deltaY;
                            int xk = x + k * deltaX;
                            proverka =proverka + (char) crossword[yk][xk];

                        }
                    } else
                        {
                            if (xEnd > -1 && (word.length() == 2))
                            {
                                proverka = proverka + (char) crossword[y][x] + (char) crossword[yEnd][xEnd];
                            }
                        }

                    if (proverka.equals(word))
                    {
                        findMass[0] = x;
                        findMass [1] = y;
                        findMass[2] = xEnd;
                        findMass[3] = yEnd;
                        return findMass;
                    }

        return null;
    }
}
