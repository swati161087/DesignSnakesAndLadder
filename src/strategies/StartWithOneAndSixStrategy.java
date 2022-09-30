package strategies;

public class StartWithOneAndSixStrategy implements StartStrategy{
    @Override
    public boolean canStart(int value) {
        return value==1||value>=6;
    }
}
