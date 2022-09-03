package top.wsure.interview.written.JLL;

import java.util.*;

/*
    FileName:   Cluster
    Author:     wsure
    Date:       2022/8/25
    Description:已知有1000个不重复且不重叠的点，这些点零散分布，如果点x1与点x2之间的距离小于等于m，则x2视为x1的邻点，当x1邻点个数大于n，
        则视{x1,x2,x3...xn…xx}形成一个集聚。如果集聚1与集聚2相交，则形成1个簇，如果集聚1不与任何另一集聚相交，则单独形成一个簇。
        同一个点可以属于不同的集聚，但只能属于1个簇。实现一个算法能将这1000个点划分成不同的簇，
        函数返回值为 [ { name: “簇1”, points: [x1,x2,x3…xx] }, { name: “簇2”, points: [xx,xx,xx…]} … ]
*/
public class ClusterTest {

    public static void main(String[] args) {
        Point[] input = new Point[100];
        Random r = new Random();
        for(int i = 0;i< 100;i++ ){
            input[i] = new Point(r.nextInt(1000),r.nextInt(1000));
        }
        createCluster(input,100,5)
                .stream()
                .peek( v -> System.out.printf(v.name + "  :"))
                .peek( v -> System.out.println(v.points))
                .count();
        ;

        System.out.println(distance(new Point(1,12),new Point(1,1002)));
    }

    public static List<Cluster> createCluster(Point[] points,double distance,int mix){
        HashMap<Point,List<Point>> visit = new HashMap<>();
        List<Cluster> res = new ArrayList<>();
        List<List<Point>> clusters = new ArrayList<>();
        for (int i = 0;i< points.length;i++){
            List<Point> c = null ;
            if(visit.containsKey(points[i])) {
                c = visit.get(points[i]);
            } else {
                Point p =points[i];
                c = new ArrayList<Point>(){{
                    add(p);
                }};
                clusters.add(c);
            }
            for (int j = i + 1;j< points.length ;j++) {
                double distances = distance(points[i],points[j]);
                if(distances < distance){
                    c.add(points[j]);
                    visit.put(points[j],c);
                }
            }
        }
        for (List<Point> list:clusters){
            if(list.size() < mix){
                for (Point p:list){
                    res.add(new Cluster(""+res.size(),new LinkedList<Point>(){{ add(p); }}));
                }
            } else {
                res.add(new Cluster(""+res.size(),new LinkedList<Point>(list)));
            }
        }
        return res;

    }

    public static double distance(Point a,Point b){
        return Math.sqrt(Math.pow(a.x - b.x,2)+ Math.pow(a.y - b.y,2));
    }

}
class Cluster {

        String name;

        LinkedList<Point> points;

    public Cluster(String name, LinkedList<Point> points) {
        this.name = name;
        this.points = points;
    }
}
class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

