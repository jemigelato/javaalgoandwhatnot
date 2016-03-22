package com.astra.jem.java;

/**
 * Created by jem on 2016/03/18.
 */
public class TowersOfHanoi {
    public void solveTower(int n, Stack start, Stack end, Stack aux) {
        if (n == 1) {
//            Object obj = start.pop();
            SQNode<Integer> nod = start.pop();
            end.push(nod.data);
        } else if (n > 1) {
            // step 1
            solveTower(n-1, start, aux, end);
            // step 2
            SQNode<Integer> ob = start.pop();
            end.push(ob.data);
            // step 3
            solveTower(n-1, aux, end, start);
        }
    }

//    void solveTwoDisks(Stack start, Stack end, Stack aux) {
//        // step 1
//        Object o1 = start.pop();
//        aux.push(o1);
//
//        // step 2
//        Object o2 = start.pop();
//        end.push(o2);
//
//        // step 3
//        end.push(o1);
//    }
}
