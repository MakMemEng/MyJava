package character;

public class Enemy extends BaseCharacter{
    //    private Figure fig;
    private String imFname;

    //    public Enemy(String name, int hp, int power, Figure fig, String imFname){
    public Enemy(String name, int hp, int power, String imFname){
	super(name, hp, power);
	//	this.fig = fig;
	this.imFname = imFname;
    }
    
    public void magic(Character e){
	System.out.println(name+"は回復魔法を唱えた．");
	e.recover(20);
    }

    /*
    public Figure getFigure(){
	return fig;
    }

    public void move(int dx, int dy){
	fig.move(dx, dy);
    }
    
    public int getX(){
	return fig.getX();
    }
    
    public int getY(){
	return fig.getY();
    }
    */

    public String getFname(){
	return imFname;
    }
}
