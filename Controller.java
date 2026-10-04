package Main;

import java.util.Scanner;
public class Controller
{
	public Controller() {}
    Model model;
    View view;
    String next;
    public Controller(Model model, View view)
    {
        this.model=model;
        this.view=view;
        sc=new Scanner(System.in);
    }
    Scanner sc;
    public void runProgram()
    {
        view.start();
        String[] verb={"take", "pick", "bring", "get", "ride","on", "board", "jump", "run", "smoke","grab", "pack"};
        String[] noun={"bread", "bottle", "knife", "phone", "map","weed", "clothes", "money", "bike", "bus","plane", "flashlight", "tent", "compass", "water"};
        int total=1;
        while (total<=5)
        {
        	boolean check_verb=false;
            boolean check_noun=false;
            String current_verb="";
            String sentence=sc.nextLine();
            next=sentence.toLowerCase();
            if(next=="q")
            {
                view.output("The end.");
                return;
            }
            for(int i=0;i<verb.length;i++)//check verb
            {
            	current_verb=verb[i];
            	for(int j=0;j<=next.length()-current_verb.length();j++)//if the first of every word is same then keep going,otherwise save time go next word
                {
            		check_verb=true;
            		for(int k=0;k<current_verb.length();k++)
                    {
            			if(next.charAt(j+k)!=current_verb.charAt(k))
                        {
            				check_verb=false;
                            break;
                        }
                    }
                    if(check_verb==true)
                    {
                        break;
                    }
                }
                if(check_verb==true)
                {
                    break;
                }
            }
            String current_noun="";
            for(int i=0;i<noun.length;i++)//check noun
            {
            	current_noun=noun[i];
                for (int j=0;j<=next.length()-current_noun.length();j++)//if the first of every word is same then keep going,otherwise save time go next word
                {
                	check_noun=true;
                    for (int k=0;k<current_noun.length();k++)
                    {
                        if(next.charAt(j+k)!=current_noun.charAt(k))
                        {
                        	check_noun=false;
                            break;
                        }
                    }
                    if(check_noun==true)
                    {
                        break;
                    }
                }
                if (check_noun==true)
                {
                    break;
                }
            }
            if (check_verb==true && check_noun==true)//add item
            {
                if(current_noun=="money")//add money
                {
                    view.askmoney();
                    double money=sc.nextDouble();
                    model.addmoney(money);
                    view.output("You put money into your backpack.\n");
                    sc.nextLine();
                }
                else
                {
                    model.additem(current_noun);
                    view.output("You put " + next + " into your backpack.\n");
                }
                total++;
            }
            else
            {
            	view.output("there's no such item\n");
            }
        }
        view.output("\rI think everything is well prepared...");
        view.output("\rBut it's a little bit far...");
        view.output("\rLet me look...... Bus, bike and plane will arrive");
        if (model.getmoney()<20)//decide final procedure
        {
            view.output("\rI don't have enough money so I'll walk to there");
            view.output("\rWalking......");
            view.output("\rOH NO, someone is following me. "+"If I have knife then I can deter him "+"or I can give him weed to make sure I'm safe");
            if(model.hasknife()==true && model.hasweed()==true)
            {
                view.output("\rPress 1 to use knife. Press 2 to take weed.\n");
                int answer=sc.nextInt();
                if(answer==1)
                {
                    view.output("\rLet's fight...");
                    view.output("\rYou are dead...");
                    view.output("\rThe end.");
                }
                else
                {
                    view.output("\rWait, I can give you weed, "+"don't kill me,please");
                    view.output("\rYou are alive and travel safely...");
                    view.output("\rThe end.");
                }
            }
            else if(model.hasknife()==true && model.hasweed()==false)
            {
                view.output("\rLet's fight...");
                view.output("\rYou are dead...");
                view.output("\rThe end.");
            }
            else if(model.hasknife()==false && model.hasweed()==true)
            {
                view.output("\rWait, I can give you weed, "+"don't kill me,please");
                view.output("\rYou are alive and travel safely...");
                view.output("\rThe end.");
            }
            else
            {
                view.output("\rYou have nothing to protect yourself.");
                view.output("\rThe end.");
            }
        }
        else if(model.getmoney()>=20 && model.getmoney()<=50)
        {
            view.output("\rI can take either bus or ride a bike");
            view.output("\rThe end.");
        }
        else if (model.getmoney()>50)
        {
            view.output("\rI think I've enough money to fly~");
            view.output("\rThe end.");
        }
    }
}