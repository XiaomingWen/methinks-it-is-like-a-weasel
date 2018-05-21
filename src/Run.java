import java.util.HashMap;
import java.util.Random;

public class Run {
    public Run(){
        Random randNum = new Random();
        char[] characters = "ABCDEFGH IJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] target = "METHINKS IT IS LIKE A WEASEL".toCharArray();
        char[][] wordList = makeCopies(characters,randNum);
        char[] best = pickBest(wordList,target);
        System.out.println("GENERATION  1 " + String.valueOf(best) + " SCORE " + String.valueOf(countSame(best,target)));
        if(String.valueOf(best).equals(String.valueOf(target))){
            System.out.println("MATCH " + String.valueOf(best));
        }
        else{
            int counter = 2;
            Boolean match = false;
            while(!(match)){
                if(counter > 9){
                    System.out.println("GENERATION " + String.valueOf(counter) + " " + String.valueOf(best)  + " SCORE " + String.valueOf(countSame(best,target)));
                }
                else {
                    System.out.println("GENERATION  " + String.valueOf(counter) + " " + String.valueOf(best)  + " SCORE " + String.valueOf(countSame(best,target)));
                }
                wordList = makeCopiesFromSelected(randNum,best,characters);
                best = pickBest(wordList,target);
                if(String.valueOf(best).equals(String.valueOf(target))){
                    System.out.println("GENERATION " + String.valueOf(counter) + " " + String.valueOf(best)  + " SCORE " + String.valueOf(countSame(best,target)));
                    match = true;
                }
                else{
                    counter = counter + 1;
                }
            }
        }
    }

    public char[][] makeCopiesFromSelected(Random randNum,char[] best, char[] characters){
        String copyBest = String.valueOf(best);
        char[][] wordList = new char[100][28];
        for(int i = 0; i < 100; i++){
            char[] word = mutateWord(randNum,copyBest.toCharArray(),characters);
            wordList[i] = word;
        }
        return wordList;
    }


    public char[] generateRandom(char[] charList, Random rand){
        char[] word = new char[28];
        for(int i = 0; i < 28; i++){
            word[i] = charList[rand.nextInt((26))];
        }
        return word;
    }

    public char[] mutateWord(Random rand,char[] word, char[] characters){
        for(int i = 0; i < word.length; i++) {
            if (rand.nextFloat() > 0.94) {
                word[i] = characters[rand.nextInt(26)];
            }
        }
        return word;
    }

    public char[][] makeCopies(char[] charList, Random rand){
        char[][] wordList = new char[100][28];
        for(int i = 0; i < 100; i++){
            char[] word = mutateWord(rand,generateRandom(charList,rand),charList);
            wordList[i] = word;
        }
        return wordList;
    }

    public HashMap compare(char[] word, char[] target){
        HashMap<Integer, char[]> hm = new HashMap<>();
        int score = 0;
        for(int i = 0; i < 28; i++){
            if(word[i] == target[i]){
                score = score + 1;
            }
        }
        hm.put(score,word);
        return hm;
    }

    public char[] pickBest(char[][] wordList, char[] target){
        int score = 0;
        char[] winner = null;
        for(char[] word : wordList){
            HashMap<Integer,char[]> hm = (compare(word,target));
            for (Integer key : hm.keySet() ) {
                if (key > score) {
                    score = key;
                    winner = hm.get(key);
                }
            }
        }
        return winner;
    }

    public int countSame(char[] best, char[] target){
        int same = 0;
        for(int i = 0; i < 28; i++){
            if(best[i] == target[i]){
                same = same + 1;
            }
        }
        return same;
    }
}
