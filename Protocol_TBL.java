import java.util.Arrays;
public class Protocol_TBL {
    private byte sync = 0x54;
    private long source = 51;
    private long destination;
    private byte[] protocolo;
    private byte crc = 0;


    public byte getSync() {

        return sync;
    }

    public Protocol_TBL(long source, long destination) {
        this.source = source;
        this.destination = destination;
    }

    public byte[] encapsulation ( byte[] payload){
        int len = 10;
        int size = payload.length;

        protocolo = new byte[size + 11];

            protocolo[0] = sync;
            protocolo[1] = (byte) (source & 0xff);
            protocolo[2] = (byte) ((source >> 8) & 0xff);
            protocolo[3] = (byte) ((source >> 16) & 0xff);
            protocolo[4] = (byte) ((source >> 24) & 0xff);
            protocolo[5] = (byte) (destination & 0xff);
            protocolo[6] = (byte) ((destination >> 8) & 0xff);
            protocolo[7] = (byte) ((destination >> 16) & 0xff);
            protocolo[8] = (byte) ((destination >> 24) & 0xff);
            protocolo[9] = (byte) (size & 0xff);
            protocolo[10] = (byte) ((size >> 8) & 0xff);


            for (int i = 0; i < size; i++) {
                protocolo[len++] = payload[i];
            }


            CRC8 crcCalculator = new CRC8();
            crcCalculator.update(protocolo);
            crc = (byte) crcCalculator.getValue();

            protocolo[len] = crc;
            return protocolo;
        }
        public String toString() {
            return "Sync: " + sync +
                    "\nSource: " + source +
                    "\ndestination: " + destination +
                    "\nCRC: " + crc +
                    "\nProtocolo: " + Arrays.toString(protocolo);
        }
    }
