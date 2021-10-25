package battle;

public interface BattleCharacter{
    public void attack(BattleCharacter c);
    public void magic(BattleCharacter c);
    public boolean deathStatus();
    public String getName();
    public String getFname();

    // ステータスを返す(数値を文字列に変換)
    public String toString();
}
