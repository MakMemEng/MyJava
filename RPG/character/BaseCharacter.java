package character;

public abstract class BaseCharacter implements Character{
    protected String name;
    protected int hp;
    protected int power;
    
    public BaseCharacter(String name, int hp, int power){
	this.name = name;
	this.hp = hp;
	this.power = power;
    }

    // 名前の取得
    public String getName(){
	return name;
    }

    // HPの取得  // +
    public int getHp(){
	return hp;
    }

    // Powerの取得  // +
    public int getPower(){
	return power;
    }
    
    // 攻撃のメソッド
    public void attack(Character h){
	System.out.println("\n"+name+"の攻撃！");
	h.attacked(power);
    }
    
    // 魔法のメソッド
    public abstract void magic(Character e); // 魔法が不明で実装できない
    
    // ダメージのメソッド
    public void attacked(int power){
	System.out.println(name+"は"+power+"ダメージを受けた．");
	this.hp -= power;
	if(deathStatus()){
	    this.hp = 0;
	    System.out.println(name+"は死んだ．");
	}
    }
    
    // 回復のメソッド
    public void recover(int hp){
	System.out.println(name+"のＨＰは"+hp+"回復した．");
	this.hp += hp;
    }
    
    // 死亡判定のメソッド
    public boolean deathStatus(){
	if(hp <= 0) return true;
	return false;
    }

    // 名前とＨＰの表示メソッド
    public String toString(){
	return name+"のHP: "+hp;
    }
}
