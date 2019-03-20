package Field;

public class MockMineRandom implements MineRandom {

    private final int first;
    private final int second;
    private final int third;
    private int calledTimes = 0;

    public MockMineRandom(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public int nextInt(int upperBound) {
        if(calledTimes == 0) {
            calledTimes++;
            return this.first;
        } else if(calledTimes == 1) {
            calledTimes++;
            return this.second;
        }
        return this.third;
    }

}
