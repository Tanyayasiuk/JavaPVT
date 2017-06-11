package javapvt.lesson9;


public class City {

    private Street street;
    private Avenue avenue;
    private Square square;

    public void setStreet(Street street){
        this.street = street;
    }

    public void setAvenue(Avenue avenue) {
        this.avenue = avenue;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public class Street {
        private String street;

        public Street (String street){
            this.street = street;
        }

        void showStr(){
            System.out.println(this.street);
        }
    }

    public class Avenue {
        private String avenue;

        public Avenue (String avenue){
            this.avenue = avenue;
        }

        void showAv(){
            System.out.println(this.avenue);
        }
    }

    public class Square {
        private String square;

        public Square (String square){
            this.square = square;
        }
        void showSq(){
            System.out.println(this.square);
        }
    }

    void showAll(){
        System.out.println(this.street + "\n" + this.avenue + "\n" + this.square);
    }
}
