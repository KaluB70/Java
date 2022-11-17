import java.awt.*;
import java.sql.Time;
import java.util.*;
import java.util.List;

import static java.lang.Long.min;
import static java.lang.Long.sum;

public class Main {
    public static void main(String[] args) {
        //task1_1();
        //task1_3();
        //task1_5();
        //task1_20();
        //task1_21();
        //task1_25();
        task1_26();
        //task1_28();
    }


    private static void task1_1() {
        // Prove that a + b can be less than minimum of a and b
        long a = -1;
        long b = -1;

        System.out.println("Task 1");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("a + b < min(a, b) = " + (sum(a, b) < min(a, b)));
    }


    private static void task1_3() {
        // Design a road network with two points a and b such that the fastest route between a and b is not the shortest route.

        Road shortestRoad = new Road(10, 30);
        Road fastestRoad = new Road(20, 65);

        System.out.println("\nTask 3");
        System.out.println("Shortest road: " + shortestRoad);
        System.out.println("Fastest road: " + fastestRoad);
        System.out.println("Fastest route time < shortest route time = "
                + (fastestRoad.getTravelTime() < shortestRoad.getTravelTime()));
    }

    private static void task1_5() {
        // The knapsack problem is as follows: given a set of integers S={s1,s2,...,sn} and a target number T,
        // find a subset of S which adds up exactly to  T. For example, there exists a subset within S={1,2,5,9,10}
        // that adds up to T=22 but not to T=23.
        // Find counterexamples to each of the following algorithms for the knapsack problem. That is, giving an S and T
        // such that the subset is selected using the algorithm but does not leave the knapsack completely full, even
        // though there such a solution exists.

        // 1. Put the elements of S in the knapsack in left to right order if they fit, i.e. the first-fit algorithm.
        // 2. Put the elements of S in the knapsack in from smallest to largest, i.e. the best-fit algorithm.
        // 3. Put the elements of S in the knapsack in from largest to smallest.

        System.out.println("\nTask 5");
        Set<Integer> set = new HashSet<>(Set.of(1,2,5,9,10));
        int target = 22;
        System.out.println("Set = " + set);
        System.out.println("Target = " + target);

        System.out.println("Solution would be: [1, 2, 9, 10]" + System.lineSeparator());
        Map<String, Integer> firstFitResult = firstFit(set, target);
        System.out.println("First fit: " + firstFitResult.keySet().iterator().next());
        System.out.println("Sum: " + firstFitResult.values().iterator().next() + System.lineSeparator());

        Map<String, Integer> bestFitResult = bestFit(set, target);
        System.out.println("Best fit: " + bestFitResult.keySet().iterator().next());
        System.out.println("Sum: " + bestFitResult.values().iterator().next() + System.lineSeparator());

        Map<String, Integer> largestToSmallest = largestToSmallest(set, target);
        System.out.println("Largest to smallest: " + largestToSmallest.keySet().iterator().next());
        System.out.println("Sum: " + largestToSmallest.values().iterator().next() + System.lineSeparator());

        System.out.println("None of these algorithms found a solution, even though it is solvable.");

    }

    private static void task1_20() {
        //How many words are there in this textbook?
        System.out.println("\nTask 20");
        System.out.println("The book is 741 pages long, according to Finna.");
        System.out.println("Shorter pages can be as low as ~100 words, and longer pages can be as high as ~700 words.");
        System.out.println("I would assume the average word count per page to be ~450, "+
                        "since there are pages with pictures and diagrams, but also some longer ones.");
        System.out.println("This gives us a total word count of 741 * 450 = 333450 words.");
    }

    private static void task1_21() {
        //How many hours are one million seconds? How many days? Answer these questions by doing all arithmetic in your head.
        System.out.println("\nTask 21");
        System.out.println("One hour is 3600 seconds.");
        System.out.println("Let's take 1 hundredth of a million seconds, which is 10000 seconds.");
        System.out.println("3600 fits into 10000 a little less than 3 times.");
        System.out.println("We then multiply 3 * 100 =  ~300 hours in a million seconds.");
        System.out.println("Let's yet again take 1 tenth of 300 hours, which is 30 hours.");
        System.out.println("24 fits into 30 a little less than 1.25 times.");
        System.out.println("We then multiply 1.25 * 10 = ~12.5 days in a million seconds.");
    }

    private static void task1_25() {
        //A sorting algorithm takes 1 second to sort 1,000 items on your local machine.
        // How long will it take to sort 10,000 items. . .
        //a. if you believe that the algorithm takes time proportional to n^2?
        //and
        //b. if you believe that the algorithm takes time roughly proportional to n log n?

        System.out.println("\nTask 25");
        System.out.println("a.)");
        System.out.println("10000/1000 = 10 times more items to sort.");
        System.out.println("If 1000 items take 1 second to process, then 10000 items with time proportional to n^2 "+
                "would take (10000/1000)^2 = ");
        System.out.println(Math.pow(10, 2) + " seconds.");
        System.out.println("b.)");
        System.out.println("If 1000 items take 1 second to process, then 10000 items with time proportional to n log n "+
                "would take (10000 * log2(10000)) / (1000 * log2(1000))) = ");
        System.out.println((10000 * Math.log(10000)) / (1000 * Math.log(1000)) + " seconds.");
    }

    private static void task1_26() {
        //[5] Implement the two TSP heuristics of Section 1.1 (page 5).
        // Which of them gives better-quality solutions in practice?
        // Can you devise a heuristic that works better than both of them?

        System.out.println("\nTask 26");
        List<Point> points = new ArrayList<>(Set.of(
                new Point(1, 3),
                new Point(2, 1),
                new Point(3, 2),
                new Point(4, 4),
                new Point(5, 6)
        ));
        points.sort((o1, o2) -> o1.getX() - o2.getX() != 0 ? o1.getX() - o2.getX() : o1.getY() - o2.getY());

        nearestNeighborHeuristic(points);
        closestPairHeuristic(points);
    }

    private static void task1_28() {
        //[5] Write a function to perform integer division without using either the / or * operators.
        // Find a fast way to do it.

        System.out.println("\nTask 28");
        System.out.println("Division of 10 by 3 is " + divide(10, 3));
        System.out.println("Division of " + Double.valueOf(Math.pow(10, 9)).intValue() + " by 2 is " + divide((int) Math.pow(10, 9), 2));
    }

    private static void nearestNeighborHeuristic(List<Point> points) {
        System.out.println("Nearest neighbor heuristic:");
        List<Point> visited = new ArrayList<>();
        List<Point> unvisited = new ArrayList<>(points);

        System.out.println("Unvisited: " + unvisited);
        Point current = unvisited.get(Math.abs(new Random().nextInt()) % unvisited.size());
        visited.add(current);
        unvisited.remove(current);
        System.out.println("Initial point: " + current);

        while (!unvisited.isEmpty()) {
            Point nearest = unvisited.get(0);
            for (Point point : unvisited) {
                if (current.distance(point) < current.distance(nearest)) {
                    nearest = point;
                }
            }
            current = nearest;
            visited.add(current);
            unvisited.remove(current);
        }

        System.out.println("Visited: " + visited);
        System.out.println("Total distance: " + totalDistance(visited) + System.lineSeparator());
    }

    private static void closestPairHeuristic(List<Point> points) {
        System.out.println("Closest pair heuristic:");
        List<Point> unvisited = new ArrayList<>(points);
        List<Edge> edges = new ArrayList<>();
        System.out.println("Unvisited: " + unvisited);

        while (unvisited.size() > 1) {
            double shortestDistance = Double.MAX_VALUE;
            Edge closestEdge = null;
            for (Point point1 : unvisited) {
                for (Point point2 : unvisited) {
                    if (point1 != point2 && point1.distance(point2) < shortestDistance) {
                        closestEdge = new Edge(point1, point2);
                        shortestDistance = point1.distance(point2);
                    }
                }
            }
            edges.add(closestEdge);
            unvisited.remove(closestEdge.getFrom());
            unvisited.remove(closestEdge.getTo());
        }

        System.out.println("Edges: " + edges);
        List<Point> edgePoints = new ArrayList<>();
        for (Edge edge : edges) {
            edgePoints.add(edge.getFrom());
            edgePoints.add(edge.getTo());
        }
        System.out.println("Total distance: " + totalDistance(edgePoints) + System.lineSeparator());
    }

    private static String totalDistance(List<Point> visited) {
        double totalDistance = 0;
        for (int i = 0; i < visited.size() - 1; i++) {
            totalDistance += visited.get(i).distance(visited.get(i + 1));
        }
        return String.format("%.2f", totalDistance);
    }

    private static Map<String, Integer> largestToSmallest(Set<Integer> set, int target) {
        List<Integer> sortedSet = new ArrayList<>(set);
        sortedSet.sort(Collections.reverseOrder());
        return findSubset(sortedSet, target);
    }

    private static Map<String, Integer> findSubset(List<Integer> sortedSet, int target) {
        int sum = 0;
        StringBuilder subset = new StringBuilder();
        subset.append("[");
        for (int i = 0; i < sortedSet.size(); i++) {
            if (sum + sortedSet.get(i) <= target) {
                sum += sortedSet.get(i);
                subset.append(sortedSet.get(i)).append(", ");
            }
            else {
                break;
            }
        }
        subset.deleteCharAt(subset.length() - 1);
        subset.deleteCharAt(subset.length() - 1);
        subset.append("]");
        return Map.of(subset.toString(), sum);
    }

    private static Map<String, Integer> bestFit(Set<Integer> set, int target) {
        List<Integer> sortedSet = new ArrayList<>(set);
        sortedSet.sort(Comparator.naturalOrder());
        return findSubset(sortedSet, target);
    }

    private static Map<String, Integer> firstFit(Set<Integer> set, int target) {
       return findSubset(new ArrayList<>(set), target);
    }

    private static int divide(int dividend, int divisor) {
        long startTime = System.currentTimeMillis();
        int result = 0;
        int tempDivisor = divisor + divisor;
        while (dividend - tempDivisor >= 0) {
            dividend -= tempDivisor;
            result += 2;
        }
        while (dividend - divisor >= 0) {
            dividend -= divisor;
            result++;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
        return result;
    }

}