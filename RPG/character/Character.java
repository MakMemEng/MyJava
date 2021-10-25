package character;

public interface Character{
    public String getName();
    public int getHp();  // +
    public int getPower();  // +

    public void attack(Character c);
    public void magic(Character c);
    public void attacked(int power);
    public void recover(int power);

    public boolean deathStatus();
}
