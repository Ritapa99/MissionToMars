public interface Spaceship {
    public boolean launch();
    public boolean land();
    public boolean canCarry(Item item);
    public void carry(Item item);
}
