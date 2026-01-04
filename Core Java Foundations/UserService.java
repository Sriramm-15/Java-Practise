public class UserService {

    private User[] users = new User[100];
    private int index = 0;

    public void addUser(User user) throws DuplicateUserException {

        if (index >= users.length) {
            throw new RuntimeException("Array size exceeded");
        }

        if (user == null || user.getName() == null ||
                user.getEmail() == null || user.getRole() == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        for (int i = 0; i < index; i++) {
            if (users[i] == null)
                continue;

            if (users[i].equals(user)) {
                throw new DuplicateUserException("Email already exists");
            }

            if (users[i].getEmail().equalsIgnoreCase(user.getEmail())) {
                throw new DuplicateUserException("Email already exists");
            }
        }

        users[index++] = user;

        if (!user.isActive()) {
            user.setActive(true);
        }

        System.out.println("User added successfully");
    }
    public void removeUser(String name) {
        for (int i = 0; i < index; i++) {
            if (users[i] != null &&
                users[i].getName().equalsIgnoreCase(name)) {

                users[i] = users[index - 1];
                users[index - 1] = null;
                index--;

                System.out.println(name + " removed successfully");
                return;
            }
        }
        System.out.println(name + " not found");
    }

    // ✅ ADDED METHOD (as Main.java expects)
    public void updateUserRole(String name, Role role) {
        for (int i = 0; i < index; i++) {
            if (users[i] != null &&
                users[i].getName().equalsIgnoreCase(name)) {

                users[i].setRole(role);
                System.out.println(name + " role updated to " + role);
                return;
            }
        }
        System.out.println(name + " not found");
    }
    public void showUsers() {
    if (index <= 0) {
        System.out.println("No users found");
        return;
    }

    for (int i = 0; i < index; i++) {
        if (users[i] != null) {
            System.out.println(users[i].getName());
        }
}    
        // for (int i = 0; i < index; i++) {
        //     if (users[i] != null && users[i].isActive()) {
        //         System.out.println((i + 1) + "\t" +
        //                 users[i].getName() + "\t" +
        //                 users[i].getEmail() + "\t" +
        //                 users[i].getRole() + "\t" +
        //                 users[i].isActive());
        //     }
    }
    
    }
