package test;

import java.util.HashSet;
import java.util.Set;

public class Task2 {

    public static Set<Object> getIntersection(Set<Object> a, Set<Object> b) {
        /*
          Please implement this method to
          return a Set equal to the intersection of the parameter Sets
          The method should not chage the content of the parameters.
         */

        if (a == null && b == null) {
            return null;
        }
        if (a == null && b != null) {
            return b;
        }
        if (a != null && b == null) {
            return a;
        }
        Set<Object> inter = new HashSet<>(a);
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

        if (a == null && b == null) {
            return null;
        }
        if (a == null && b != null) {
            return b;
        }
        if (a != null && b == null) {
            return a;
        }

        Set<Object> tmpUnion = new HashSet<>(a) ;
        tmpUnion.addAll(b);

        Set<Object> inter = getIntersection(a, b);

        Set<Object> diff = new HashSet<>(tmpUnion);
        diff.removeAll(inter);
    	return diff;
    }

    public static void main(String args[]) {
        Set<Object> setA = new HashSet<>();
        Set<Object> setB = new HashSet<>();
        setA.add("D");
        setA.add("B");
        setB.add("B");

        System.out.println("set A: " + setA.toString());
        System.out.println("set B: " + setB.toString());
        Set<Object> inter = Task2.getIntersection(setA, setB);
        System.out.println("getIntersection(): " + inter.toString());

        Set<Object> symDiff = Task2.getUniqueElements(setA, setB);
        System.out.println("getUniqueElements(): " + symDiff.toString());
        System.out.println("  set A after: " + setA.toString());
        System.out.println("  set B after: " + setB.toString());


        setA = new HashSet<>();
        setA.add("A");
        setA.add("B");
        setA.add("C");
        setB = new HashSet<>();
        setB.add("D");
        setB.add("A");
        setB.add("C");

        System.out.println("set A: " + setA.toString());
        System.out.println("set B: " + setB.toString());
        inter = Task2.getIntersection(setA, setB);
        System.out.println("getIntersection(): " + inter.toString());

        System.out.println("set A: " + setA.toString());
        System.out.println("set B: " + setB.toString());
        symDiff = Task2.getUniqueElements(setA, setB);
        System.out.println("getUniqueElements: " + symDiff.toString());
        System.out.println("set A: " + setA.toString());
        System.out.println("set B: " + setB.toString());
    }
}
