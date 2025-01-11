/** Represents a social network. The network has users, who follow other uesrs.
 *  Each user is an instance of the User class. */
public class Network {

    // Fields
    private User[] users;  // the users in this network (an array of User objects)
    private int userCount; // actual number of users in this network

    /** Creates a network with a given maximum number of users. */
    public Network(int maxUserCount) {
        this.users = new User[maxUserCount];
        this.userCount = 0;
    }

    /** Creates a network  with some users. The only purpose of this constructor is 
     *  to allow testing the toString and getUser methods, before implementing other methods. */
    public Network(int maxUserCount, boolean gettingStarted) {
        this(maxUserCount);
        users[0] = new User("Foo");
        users[1] = new User("Bar");
        users[2] = new User("Baz");
        userCount = 3;
    }

    /** Finds in this network, and returns, the user that has the given name.
     *  If there is no such user, returns null.
     *  Notice that the method receives a String, and returns a User object. */
    public User getUser(String name) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equals(name)) {
                return users[i];
            }
        }
        return null;
    }

    /** Adds a new user with the given name to this network.
    *  If ths network is full, does nothing and returns false;
    *  If the given name is already a user in this network, does nothing and returns false;
    *  Otherwise, creates a new user with the given name, adds the user to this network, and returns true. */
    public boolean addUser(String name) {
        if (userCount == users.length) {
            System.out.println("Network is full, cannot add more users.");
            return false;
        }
        if (getUser(name) != null) {
            System.out.println("User " + name + " already exists in the network.");
            return false;
        }
        // Creates a new user, and adds it to this network.
        users[userCount++] = new User(name);
        System.out.println("Added: " + name);
        return true;
    }

    /** Makes the user with name1 follow the user with name2. If successful, returns true.
     *  If any of the two names is not a user in this network,
     *  or if the "follows" addition failed for some reason, returns false. */
    public boolean addFollowee(String name1, String name2) {
        User user1 = getUser(name1);
        User user2 = getUser(name2);
        if ((user1 == null) || (user2 == null)) {
            System.out.println("At least one of the two names is not a user of this network.");
            return false;
        }
        return user1.addFollowee(name2);
    }
    
    /** For the user with the given name, recommends another user to follow. The recommended user is
     *  the user that has the maximal mutual number of followees as the user with the given name. */
    public String recommendWhoToFollow(String name) {
        User user = getUser(name);
        if (user == null) {
            System.out.println("User " + name + " does not exist.");
            return null;
        }
        // Computes the maximin mutual number of followees.
        // Iterates through all the users, except the one with the given name.
        int maxCountMutual = 0;
        User mostRecommendedUserToFollow = null;
        for (int i = 0; i < userCount; i++) {
            User current = users[i];
            if (current.getName().equals(name)) continue;
            int countMutual = user.countMutual(current);
            if (countMutual > maxCountMutual) {
                maxCountMutual = countMutual;
                mostRecommendedUserToFollow = current;
            }
        }
        return mostRecommendedUserToFollow.getName();
    }

    /** Computes and returns the name of the most popular user in this network: 
     *  The user who appears the most in the follow lists of all the users. */
    public String mostPopularUser() {
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < userCount; i++) {
            int count = followeeCount(users[i].getName());
            if (count > max) {
                max = count;
                maxIndex = i;
            }
        }
        return users[maxIndex].getName();
    }

    /** Returns the number of times that the given name appears in the follows lists of all
     *  the users in this network. Note: A name can appear 0 or 1 times in each list. */
    private int followeeCount(String name) {
        int followeeCount = 0;
        for (int i = 0; i < userCount; i++) {
            if (users[i].follows(name)) {
                followeeCount++;
            }
        }
        return followeeCount;
    }

    // Returns a textual description of all the users in this network, and who they follow.
    public String toString() {
        String ans = "Network:";
        for (int i = 0; i < userCount; i++) {
            ans = ans + "\n" + users[i];
        }
        return ans;
    }
}
