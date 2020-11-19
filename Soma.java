public class Soma implements Interface {
    private int x = 0;
    private int y = 0;

    public Soma(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public double executar(double a, double b) {
        return a + b;
    }
}
