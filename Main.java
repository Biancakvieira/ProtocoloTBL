public class Main {
    public static void main(String[] args) {

        Protocolo protocolo = new Protocolo(666L, 777L);


        String mensagem = "ola mundo";
        byte array[] = mensagem.getBytes();
        System.out.println(array.length);
        byte protocoloTbl[] = protocolo.encapsularPacote(array);

        System.out.println(protocoloTbl);

        System.out.println(protocoloTbl.toString());



//            CRC8 crc = new CRC8();
//            crc.reset();
//            crc.update("test".getBytes());
//            System.out.println("181=" + crc.getValue());
//            crc.reset();
//            crc.update("hello world".getBytes());
//            System.out.println("59=" + crc.getValue());
//

    }
}