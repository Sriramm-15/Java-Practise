import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private Map<String, User> userMap = new HashMap<>();
    private Map<String, List<String>> loginHistory = new HashMap<>();
    public void addUser(User user) throws DuplicateUserException {
        if (user == null ||user.getName() == null|| user.getEmail() == null || user.getRole() == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (userMap.containsKey(user.getEmail())) {
            throw new DuplicateUserException("Duplicate User is not allowed");
        }
        userMap.put(user.getEmail(), user);
        loginHistory.put(user.getEmail(), new ArrayList<>());
        System.out.println("User added successfully");
    }
    // SHOW ALL USERS (NAMES ONLY)
    public void showUsers() {
        if (userMap.size() == 0) {
            System.out.println("No users found");
            return;
        }
        for (User user : userMap.values()) {
            System.out.println(user.getName());
        }
    }
    public List<User> getUsersByRole(Role role) {
        List<User> list = new ArrayList<>();
        for (User user : userMap.values()) {
            if (user.getRole() == role) {
                list.add(user);
            }
        }

        return list;
    }
        public List<User> getActiveUsersSortedByName() {

        List<User> list = new ArrayList<>();
        for (User user : userMap.values()) {
            if (user.isActive()) {
                list.add(user);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {

                if (list.get(i).getName()
                        .compareToIgnoreCase(list.get(j).getName()) > 0) {

                    User temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }

        return list;
    }
    public void addLogin(String email, String time) {
        List<String> history = loginHistory.get(email);
        if (history != null) {
            history.add(time);
        }
    }
    public List<String> getLoginHistory(String email) {
        return loginHistory.get(email);
    }
    public void removeUser(String name) {
        String emailToRemove = null;
        for (User user : userMap.values()) {
            if (user.getName().equalsIgnoreCase(name)) {
                emailToRemove = user.getEmail();
                break;
            }
        }
        if (emailToRemove != null) {
            userMap.remove(emailToRemove);
            loginHistory.remove(emailToRemove);
            System.out.println(name + " removed successfully");
        } else {
            System.out.println(name + " not found");
        }
    }
    public void updateUserRole(String name, Role role) {

        for (User user : userMap.values()) {
            if (user.getName().equalsIgnoreCase(name)) {
                user.setRole(role);
                System.out.println(name + " role updated to " + role);
                return;
            }
        }

        System.out.println(name + " not found");
    }
}
