package ee.rebecca.hilowgame;

public enum Suits {
    SPADES("SPADES"), HEARTS("HEARTS"), CLUBS("CLUBS"), DIAMONDS("DIAMONDS");

    private String val;
    private Suits(String value){
        this.val = value ;
    }
    public String getSuit() {
        return val;
    }
}
