public class Main {
    public static void main(String[] args) {

        UserService service = new UserService();

        try {
            service.addUser(new User("Sriram", "s@gmail.com", Role.ADMIN));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            service.addUser(new User("Neha", "n@gmail.com", Role.USER));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            service.addUser(new User("Ravi", "n@gmail.com", Role.USER)); // duplicate
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            service.addUser(new User("sriram", "s@gmail.com", Role.USER)); // duplicate
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            service.addUser(new User("Shiva", "sh@gmail.com", Role.USER));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- USERS AFTER ADD ---");
        service.showUsers();

        System.out.println("\n--- REMOVE USER ---");
        service.removeUser("Shiva");
        service.showUsers();

        System.out.println("\n--- UPDATE ROLE ---");
        service.updateUserRole("Neha", Role.ADMIN);
        service.showUsers();

        System.out.println("\n--- UPDATE ROLE (NOT FOUND) ---");
        service.updateUserRole("Ravi", Role.ADMIN);

        System.out.println("\n--- UPDATE ROLE ---");
        service.updateUserRole("Sriram", Role.USER);
        service.showUsers();
    }
}






























// public class Main {
//     public static void main(String[] args) {
//         UserService service = new UserService();

//         try {
//             service.addUser(new User("Sriram", "s@gmail.com", Role.ADMIN));
//             service.addUser(new User("Neha", "n@gmail.com", Role.USER));
//             service.addUser(new User("Ravi", "n@gmail.com", Role.USER));
//             service.addUser(new User("sriram", "s@gmail.com", Role.USER));
//             service.addUser(new User("Shiva", "sh@gmail.com", Role.USER));
//         } catch (DuplicateUserException e) {
//             System.out.println(e.getMessage());
//         }
//         System.out.println();
//         service.showUsers();
//         System.out.println();
//         service.removeUser("Shiva");
//         service.showUsers();
//         System.out.println();
//         service.updateUserRole("Neha", Role.ADMIN);
//         service.showUsers();
//         System.out.println();
//         service.updateUserRole("Ravi", Role.ADMIN);
//         service.showUsers();
//         System.out.println();
//         service.updateUserRole("Sriram", Role.USER);
//         service.showUsers();
//         System.out.println();
//     }
// }
