import java.util.HashMap;
import java.util.Stack;

class FreqStack {

    HashMap<Integer, Stack<Integer>> freqStack;
    HashMap<Integer, Integer> frequency;
    int maxFreq;

    public FreqStack() {
        freqStack = new HashMap<>();
        frequency = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        frequency.put(val, frequency.getOrDefault(val, 0) + 1);
        int freq = frequency.get(val);
        if(!freqStack.containsKey(frequency.get(val)))
            freqStack.put(freq, new Stack<>());
        freqStack.get(freq).push(val);
        maxFreq = Math.max(maxFreq, freq);
    }

    public int pop() {
        int frequentElement = 0;
        frequentElement = freqStack.get(maxFreq).pop();
        frequency.put(frequentElement, frequency.get(frequentElement) - 1);
        if(freqStack.get(maxFreq).isEmpty())
            maxFreq--;
        return frequentElement;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
