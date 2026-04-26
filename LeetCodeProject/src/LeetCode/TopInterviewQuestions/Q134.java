package LeetCode.TopInterviewQuestions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Q134 {
    /*
     There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

    You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.

    Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique
    */
    public int canCompleteCircuit_myAnswer(int[] gas, int[] cost) {
        LinkedHashMap<Integer, Integer> instantCostMap = new LinkedHashMap<>();
        for (int i = 0; i < gas.length; i++) {
            instantCostMap.put(i, gas[i] - cost[i]);
        }
        return reduceMap(instantCostMap);
    }

    int reduceMap(LinkedHashMap<Integer, Integer> map) {
        if (map.size() == 1) {
            return (int) map.values().toArray()[0] >= 0 ? (int) map.keySet().toArray()[0] : -1;
        } else {
            int firstIndex = 0;
            int lastKey = 0;
            LinkedHashMap<Integer, Integer> newMap = new LinkedHashMap<>();
            List<Integer> keys = map.keySet().stream().toList();
            for (int i = 0; i < keys.size(); i++) {
                int index = keys.get(i);
                if (newMap.size() == 0 && map.get(index) < 0) {
                    continue;
                } else if (newMap.size() == 0 && map.get(index) >= 0) {
                    firstIndex = i;
                }

                if (map.get(index) >= 0) {
                    newMap.put(index, map.get(index));
                    lastKey = index;
                } else {
                    newMap.put(lastKey, newMap.get(lastKey) + map.get(index));
                }
            }
            for (int i = 0; i < firstIndex; i++) {
                int index = keys.get(i);
                newMap.put(lastKey, newMap.get(lastKey) + map.get(index));
            }
            return reduceMap(newMap);
        }
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0) {
            return -1;
        }
        int totalConsume = 0;
        int currentConsume = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            int curr = gas[i] - cost[i];
            if (currentConsume < 0) {
                start = i;
                currentConsume = curr;
            } else {
                currentConsume += curr;
            }
            totalConsume += curr;
        }

        return totalConsume >= 0 ? start : -1;
    }

    /*
    If the gas is more than the cost in total, there must be some stations we have enough gas to go through them.

    Let’s say they are green stations. So the other stations are red .

    The adjacent stations with the same color can be joined together as one.

    Then there must be a red station that can be joined into a precedent green station unless there isn’t any red station because the total gas is more than the total cost. In other words, all of the stations will join into a green station at last.
    */

    public static void main(String[] args) {
//        int[] gas = new int[]{1, 2, 3, 4, 5};
//        int[] cost = new int[]{3, 4, 5, 1, 2};

//        int[] gas = new int[]{2, 3, 4};
//        int[] cost = new int[]{3, 4, 3};

        int[] gas = new int[]{3, 3, 4};
        int[] cost = new int[]{3, 4, 4};
        Q134 q134 = new Q134();
        System.out.println(q134.canCompleteCircuit(gas, cost));
    }
}
