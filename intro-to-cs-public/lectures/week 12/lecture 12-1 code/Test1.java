// Tests the Person and Instructor classes.
public class Test1 {

    public static void main(String args[]) {
        Instructor inst1 = new Instructor("raanan", "raanana", "dr.");
        Instructor inst2 = new Instructor("neta",   "netanya", "prof.");

        System.out.println(inst1);
        inst1.setTitle("prof.");
        System.out.println(inst1);
        inst1.setAddresss("kfar saba");
        System.out.println(inst1);
    }
}
