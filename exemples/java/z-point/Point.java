
class Point {
    public int x, y;
    public Point(int x, int y) { this.x = x; this.y = y; }
    public String toString(){ return "(" + this.x + "," + this.y + ")"; }
    public static void main(String[] args) {
        Point a = new Point(1, 1);
        Point b = a;
        a.x = 2;
        System.out.println(a);
        System.out.println(b);
    }
}

