package character;

public class Wizard extends BaseCharacter{
    public Wizard(String name, int hp, int power){
	super(name, hp, power);
    }
    
    public void magic(Character e){
	System.out.println(name+"はファイアーを唱えた．");
	e.attacked(20);
    }
}
