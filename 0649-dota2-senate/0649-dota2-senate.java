import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Character> senaters = new LinkedList<>();
        int countR = 0;
        int countD = 0;
        int bansForR = 0;
        int bansForD = 0;

        for(char ch : senate.toCharArray()){
            senaters.add(ch);
            if(ch == 'R')
                countR++;
            else
                countD++;
        }

        while(countD > 0 && countR > 0){
            char current = senaters.poll();

            if(current == 'R'){
                if(bansForR > 0){
                    bansForR--;
                    countR--;
                } else {
                    bansForD++;
                    senaters.add(current);
                }
            } else {
                if(bansForD > 0){
                    bansForD--;
                    countD--;
                } else {
                    bansForR++;
                    senaters.add(current);
                }
            }
        }

        return (countD > 0) ? "Dire" : "Radiant";
    }
}