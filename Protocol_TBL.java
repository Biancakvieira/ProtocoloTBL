public class Protocol_TBL {
    private char sync;

    private final int source = 57;

    private int destination;

    private short size;

    public char getSync() {
        return sync;
    }

    public void setSync(char sync) {
        this.sync = sync;
    }

    public int getSource() {
        return source;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public short getSize() {
        return size;
    }

    public void setSize(short size) {
        this.size = size;
    }
}
