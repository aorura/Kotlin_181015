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

/*
import ex5.User;

public class JavaProgram {
    public static void main(String[] args) {
        User user1 = new User("Tom", "Suwon", 10, 42);
        User user2 = new User("Tom", "Suwon", 10);
        User user3 = new User("Tom", "Suwon");
    }
}
*/

/*
// 생성자에서는 절대 오버라이딩 가능한 메소드를 호출하지 마라.
// => 생성자에서 호출하는 초기화에 관련된 메소드는
//    반드시 final 이거나 private 메소드 이어야 한다.
class Car {
    Car() {
        initialize();
    }

    private void initialize() {
        System.out.println("Car Init");
    }
}

class Truck extends Car {
    Truck() {
        // super();
        initialize();
    }

    private void initialize() {
        System.out.println("Truck init");
    }


}

public class JavaProgram {
    public static void main(String[] args) {
        Car car = new Truck();

    }
}
*/

/*
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

interface State extends Serializable {

}

interface View {
    State getCurrentState();

    void restoreState(State state);
}

class Button implements View {
    @Override
    public State getCurrentState() {
        return new ButtonState();
    }

    @Override
    public void restoreState(State state) {
        // ...
    }

    // Memento Pattern

    // 1. Inner class(내부 클래스)
    //  : 외부 클래스의 인스턴스 필드나 메소드에 바로 접근할 수 있지만,
    //    외부 클래스의 인스턴스에 대한 암묵적인 참조가 만들어진다.
    class ButtonState implements State {
    }
    // 2. Nested class(중첩 클래스)
    // static class ButtonState ... {}


}

class SampleState implements State {

}

public class JavaProgram {
    public static void main(String[] args) throws Exception {
        Button button = new Button();
        // SampleState state = new SampleState();

        FileOutputStream fos = new FileOutputStream("state.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // oos.writeObject(state);
        oos.writeObject(button.getCurrentState());
    }
}
*/

class User {
    private String name;
    private int age;

    private static final String NAME = "User";

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Foo createFoo() {
       return new Foo();
    }

    static class Foo {
        void foo() {
            // System.out.println("name: " + name + " age: " + age);
            System.out.println(NAME);
        }
    }
}

public class JavaProgram {
    public static void main(String[] args) {
        /*
        User.Foo obj = new User("Tom", 42)
                .createFoo();
        */

        User.Foo obj = new User.Foo();

    }
}



























