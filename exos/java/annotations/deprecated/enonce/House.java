
interface House {
    @Deprecated
    void open();
    void openFrontDoor();
    void openBackDoor();
}

class MyHouse implements House{
    public void open() {}
    public void openFrontDoor() {}
    public void openBackDoor() {}
}
