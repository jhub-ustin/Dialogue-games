package Main;

public class Model
{
    double bucks;
    String[] bag;
    int bagCount;
    boolean hasKnife;
    boolean hasWeed;
    public Model()
    {
        bucks=0;
        bag=new String[5];
        bagCount=0;
        hasKnife=false;
        hasWeed=false;
    }
    public void addmoney(double money)
    {
        bucks+=money;
    }
    public double getmoney()
    {
        return bucks;
    }
    public void additem(String item)
    {
        bag[bagCount]=item;
        bagCount++;
    }
    public boolean hasknife()
    {
        return hasKnife;
    }
    public boolean hasweed()
    {
        return hasWeed;
    }
}