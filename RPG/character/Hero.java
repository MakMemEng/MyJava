package character;

public class Hero extends BaseCharacter{
    public Hero(String name, int hp, int power){
	super(name, hp, power);
    }
    
    // heal
    public void magic(Character h){
	System.out.println(name+"は回復魔法を唱えた．");
	h.recover(10);
    }
}
