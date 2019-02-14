import java.util.Date;

public class Demo {

    public static void main(String[] args) {

        HotelDAO hotelDAO = new HotelDAO();
        RoomDAO roomDAO = new RoomDAO();

        //Hotel hotel1 = new Hotel("Fastiv", "Ukraine", "Fastiv", "Soborna");//41

        Hotel hotel = hotelDAO.findById(41);
        Hotel hotel2 = hotelDAO.findById(49);
        Hotel hotel3 = hotelDAO.findById(42);
        //System.out.println(hotel.toString());

//        Room room1 = new Room(2, 480.50, 1, 0, new Date(), hotel2);
//        Room room2 = new Room(1, 320.43, 1, 0, new Date(), hotel2);
//        Room room3 = new Room(2, 480.43, 1, 0, new Date(), hotel2);
//        Room room4 = new Room(1, 230.50, 0, 0, new Date(), hotel2);
//        Room room5 = new Room(1, 167.90, 0, 0, new Date(), hotel2);
//
//        Room room6 = new Room(1, 180.37, 0, 0, new Date(), hotel2);
        //Room room7 = new Room(1, 233.45, 0, 1, new Date(), hotel2);
//        roomDAO.save(room1);
//        roomDAO.save(room2);
//        roomDAO.save(room3);
//        roomDAO.save(room4);
//        roomDAO.save(room5);
//        roomDAO.save(room6);

      // System.out.println(roomDAO.getAll().toString());

        //hotelDAO.delete(hotelDAO.findById(41));
        //roomDAO.delete(roomDAO.findById(55));
        //System.out.println(roomDAO.getAll().toString());

        Room room56 = new Room(58,2, 834.03, 1, 0, new Date(), hotel3);
        System.out.println(room56.toString());
        roomDAO.update(room56);

      //  System.out.println(roomDAO.findById(53));
      //  System.out.println(roomDAO.findById(53));

 //      System.out.println(roomDAO.getAll());
//        roomDAO.delete(roomDAO.findById(48));
//        roomDAO.delete(roomDAO.findById(46));
//        roomDAO.delete(roomDAO.findById(47));
//        roomDAO.delete(roomDAO.findById(50));
//        roomDAO.delete(roomDAO.findById(51));

       // Room room = roomDAO.findById(45);
        //roomDAO.delete(room);

       // System.out.println(hotelDAO.findById(41));


//        Hotel hotel2 = new Hotel("Словянський двір", "Україна", "Івано-Франківськ", "Залізнична");//42
//
//        Hotel hotel3 = new Hotel("Смерека", "Україна", "Тернопіль", "Кївська");//43
//        //Hotel hotel2
//
//        hotelDAO.save(hotel2);
//        hotelDAO.save(hotel3);

       // Hotel hotell4 = new Hotel("Сакура", "Японія", "Кіото", "7 Самураїв");
        //hotelDAO.save(hotell4);

    }

}
