public class GenericListDemo {

    public static void main(String[] args) {
        //demo1();
        //demo2();
        demo3();
    };

    public static void demo1() {
       // A list of strings
       List<String> cities = new List<String>();
       cities.add("Haifa");
       cities.add("LA");
       cities.add("Paris");
       System.out.println(cities);
    }

    public static void demo2() {
        // A list of fractions
        List<Fraction> fList = new List<Fraction>();
        fList.add(new Fraction(7,8));
        fList.add(new Fraction(1,2));
        fList.add(new Fraction(5,9));
        System.out.println(fList);
     }

     public static void demo3() {
        // a list of int values
        List<Integer> intList = new List<Integer>();
        intList.add(Integer.valueOf(5)); 
        intList.add(3); // (uses autoboxing)
        intList.add(9); 
        System.out.println(intList);
     }
}
