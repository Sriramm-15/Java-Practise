public class User {

    private static int counter = 1;

    private int id;
    private String name;
    private String email;
    private Role role;
    private boolean active;

    public User(String name, String email, Role role) {
        this.id = counter++;
        this.name = name;
        this.email = email;
        this.role = role;
        this.active = true;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object obj) {
        User u = (User) obj;
        return this.email.equals(u.email);
    }

    @Override
    public String toString() {
        return id + " " + name + " " + email + " " + role + " " + active;
    }
}

