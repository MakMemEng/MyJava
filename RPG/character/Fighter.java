package character;

public class Fighter extends BaseCharacter{
    public Fighter(String name, int hp, int power){
	super(name, hp, power);
    }
    
    public void magic(Character h){
	System.out.println(name+"は回復魔法を唱えた．");
	System.out.println("しかし、"+name+"は魔法を使えなかった．");
    }
}


