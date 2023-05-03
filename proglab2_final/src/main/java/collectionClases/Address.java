package collectionClases;

public class Address {
    public Address(){
        street = " ";
    }
    private String street; //Поле не может быть null
    public void setStreet(String street){
        this.street = street;
    }

    public String getStreet() {
        return street;
    }
}
