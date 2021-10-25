import battle.BattleCharacter;
import character.Character;

public class BattleCharacterAdapter implements BattleCharacter{
    private Character chara;

    public BattleCharacterAdapter(Character chara){
	this.chara = chara;
    }

    public void attack(BattleCharacter c){
	chara.attack((Character)c);
    }

    public void magic(BattleCharacter c){
	Character ch;
	if(c instanceof BattleCharacterAdapter){
	    ch = ((BattleCharacterAdapter)c).getCharacter();
	}else{
	    ch = (Character)c;
	}
	chara.magic(ch);
    }

    public boolean deathStatus(){
	return chara.deathStatus();
    }

    public String getName(){
	return chara.getName();
    }

    public String getFname(){
	return null;
    }

    public Character getCharacter(){
	return chara;
    }

    // ステータスを返す
    public String toString(){
	return chara.toString();
    }

}

