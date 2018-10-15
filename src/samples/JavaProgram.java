package samples;

/*
public class JavaProgram {
    public static void main(String[] args) {
        // System.out.println(System.out.println());

//        User user = new User("Tom", 42);
//        user.setName("Bob");

    }
}
*/
/*
class User {
    protected String name;
}
*/

/*
// AOP(관점 지향 프로그래밍) => Annotation Processor + Annotation
//  => Lombok
class User {
    private String name;
    private String address;
    private int age;
    private int level;

    private User(Builder builder) {
        name = builder.name;
        address = builder.address;
        age = builder.age;
        level = builder.level;
    }

    static class Builder {
        private String name;
        private String address;
        private int age;
        private int level;

        public Builder(String name) {
            this.name = name;
        }

        Builder address(String address) {
            this.address = address;
            return this;
        }

        Builder age(int age) {
            this.age = age;
            return this;
        }

        Builder level(int level) {
            this.level = level;
            return this;
        }

        User build() {
            return new User(this);
        }

    }


}

public class JavaProgram {
    public static void main(String[] args) {
        User user = new User.Builder("Tom")
                .age(42)
                .address("Suwon")
                .level(10)
                .build();


        // user.name = "Tom";
    }
}
*/

import ex5.User;

public class JavaProgram {
    public static void main(String[] args) {
        User user1 = new User("Tom", "Suwon", 10, 42);
        User user2 = new User("Tom", "Suwon", 10);
        User user3 = new User("Tom", "Suwon");
    }
}











