class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        if (isOK(firstName)) {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if (isOK(lastName)) {
            this.lastName = lastName;
        }
    }

    private boolean isOK(String val) {
        if (val != null && !val.isEmpty()) return true;
        return false;
    }

    public String getFullName() {
        if (isOK(firstName) && isOK(lastName)) return firstName + " " + lastName;
        if (isOK(firstName)) return firstName;
        if (isOK(lastName)) return lastName;
        return "Unknown";
    }
}