package Main;

public class driver
{
    public static void main(String[] args)
    {
        View view=new View();
        Model model=new Model();
        Controller c=new Controller(model,view);
        c.runProgram();
    }
}