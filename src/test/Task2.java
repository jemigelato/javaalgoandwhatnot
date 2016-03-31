package test;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class Task2 {

    public static Set<Object> getIntersection(Set<Object> a, Set<Object> b) {
        /*
          Please implement this method to
          return a Set equal to the intersection of the parameter Sets
          The method should not chage the content of the parameters.
         */

        if (a == null && b == null) return null;
        if (a == null && b != null) return b;
        if (a != null && b == null) return a;
        Set<Object> inter = new HashSet<>();
//        HashSet<Object> hash = new HashSet<>();
//        for (Object obj: a) {
//            hash.add(obj);
//        }
//        for (Object x: b) {
//            if (hash.contains(x)) {
//                inter.add(x);
//            }
//        }
        inter = new HashSet<>(a);
        inter.retainAll(b);

        return inter;
    }

    public static Set<Object> getUniqueElements(Set<Object> a, Set<Object> b) {
        /*
          Please implement this method to
          return a set of elements that can be found only in set a or set b,
          but not in both Sets.
          The method should not change the content of the parameters.
         */

    	return null;
    }
}
