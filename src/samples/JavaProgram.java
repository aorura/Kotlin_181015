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

/*
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
        User.Foo obj = new User("Tom", 42)
                .createFoo();

        User.Foo obj = new User.Foo();

    }
}
*/

// 객체의 복제가 필요한 이유?


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// import java.util.function.Predicate;

// Immutable Object
class Rect {
    private final Point leftTop;
    private final Point rightBottom;

    public Rect(Point leftTop, Point rightBottom) {
        // 방어 복제본을 생성하는 코드
        this.leftTop = leftTop.clone();
        this.rightBottom = rightBottom.clone();
    }

    @Override
    public String toString() {
        return "Rect{" +
                "leftTop=" + leftTop +
                ", rightBottom=" + rightBottom +
                '}';
    }
}


// Object.clone()
// 1. protected -> public 으로 변경해야 합니다.
// 2. 예외를 메소드 안에서 처리해야 합니다.
// 3. 공변 반환의 룰
//    : 부모 메소드의 반환 타입을 하위 타입으로 변경하는 것을 허용한다.
// 4. 내부적으로 캐스팅을 수행한다.

// clone() 한계
//  1. 만드는 것이 번거롭고 복잡하다.
//  2. 특정 클래스의 하위 타입으로 만들었을 경우, 부모가 Cloneable 하지 않다면
//     clone을 재정의할 수 없다.

// - Clone() 보다는 '복사 생성자'를 고려하라.

class Point implements Cloneable {
    private int x;
    private int y;

    @Override
    public Point clone() {
        try {
            return (Point) super.clone();
            /*
            // check up interface
            if (!(this instanceOf Cloneable))
                throw new CloneNotSupportedException();
            */

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 복사 생성자를 고려해라.
    public Point(Point rhs) {
        this.x = rhs.x;
        this.y = rhs.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

//public class JavaProgram {
//    public static void main(String[] args) {
//        Point p1 = new Point(10, 32);
//        Point p2 = p1.clone();
//
//        System.out.println(p1);
//        System.out.println(p2);
//
//    }
//}

/*
public class JavaProgram {
    public static void main(String[] args) {
        Point leftTop = new Point(10, 32);
        Point rightBottom = new Point(30, 100);

        Rect rect = new Rect(leftTop, rightBottom);
        leftTop.setX(1000);

        System.out.println(rect);

//        List<String> list = new ArrayList<>();
//        list.add("Tom");
//        list.add("Bob");

                            // listOf
        List<String> list = Arrays.asList("Tom", "Bob");
        System.out.println(list.get(0));
        //                 list[0]

    }
}
*/

// Singleton: GoF's Design Pattern
//   의도: 오직 한개의 객체를 생성하고, 언제 어디서든 동일한 방법으로
//        접근할 수 있어야 한다.

// 안전하지 않은 싱글톤
//  1. Reflection
//  2. Serialization

/*
class Cursor {
    // 1. private 생성자
    private Cursor() {

    }

    // 2. 오직 한개의 객체
    private static final Cursor INSTANCE = new Cursor();

    // 3. 정적 메소드
    public static Cursor getInstance() {
        return INSTANCE;
    }
}

public class JavaProgram {
    public static void main(String[] args) throws Exception {
        Cursor c1 = Cursor.getInstance();
        Cursor c2 = Cursor.getInstance();
        System.out.println(c1);
        System.out.println(c2);

        Class clazz = Cursor.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Cursor c3 = (Cursor) constructor.newInstance();

        System.out.println(c3);
    }
}
*/


// Bloch's Singleton
// => enum Singleton
/*
enum Cursor {
    INSTANCE;

    void move() {
        System.out.println("Cursor move");
    }
}
*/

// 위의 싱글톤들은 프로그램 시작시 생성된다.
// 프로그램 내부에 싱글톤이 많을 경우, 또는 싱글톤의 생성에 시간이 걸릴 경우
// 프로그램 시작 속도에 악영향을 미친다.

// Lazy Initialization Singleton
/*
class Cursor {
    private Cursor() {}
    private static Cursor sInstance = null;
    // static final: 동시에 여러 개의 스레드가 생성하더라도 정상적으로 하나만 생성되는 것을
    //               보장된다.

    // Version 1
    public synchronized static Cursor getInstance() {
        if (sInstance == null)
            sInstance = new Cursor();

        return sInstance;
    }

    // Version 2 - DCLP(Double Check Locking Pattern)
    //  문제점: 선언적이지 않다.
    //   -> 메소드의 이름이랑 하는일이랑 차이가 있다.
    public static Cursor getInstance() {
        if (sInstance == null) {
            synchronized (Cursor.class) {
                if (sInstance == null)
                    sInstance = new Cursor();
            }
        }

        return sInstance;
    }

    // Idioms
    //   언어가 가지고 있는 특성을 이용해서 문제를 해결하는 방식

    // Version 3. IODH(Initialize on Demand Holder)
    //  : 중첩 클래스를 이용한다.
    //  JLS 표준: 중첩 클래스의 정적 필드는 처음 접근하는 시점에 로드한다.
    static class Singleton {
        private static final Cursor INSTANCE = new Cursor();
    }

    public static Cursor getInstance() {
        return Singleton.INSTANCE;
    }
}
*/


/*
public class JavaProgram {
    public static void main(String[] args) throws Exception {
        // Cursor.INSTANCE.move();
        // Cursor.INSTANCE.move();

        // User.Companion.className()
        // User.Shared.className()
        Dialog dialog = new Dialog();

        Button button = new Button(100);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(@NotNull Button view) {
                dialog.close();
            }
        });

        // Java 7 - JodaTime
        // Java 8 - New Date API
        //    : LocalDate, LocalDateTime
        System.out.println(LocalDate.now());
        System.out.println(LocalDateTime.now());
    }
}
*/

/*
public class JavaProgram {
    public static void main(String[] args) throws Exception {
        List<Integer> s = new ArrayList<>();

        // Immutable Collection을 만드는 방법
        //  : Decorator Pattern
        //   -> 실행 시간에 새로운 기능을 객체에 추가하는 방법

        // s = Collections.unmodifiableList(s);
        // s.add(10);

//        s.add(20);
//        s.add(30);
    }
}
*/

// 람다를 사용하기 위해서는 인터페이스에 오직 하나의 메소드만
// 존재해야 한다. - Functional Interface
@FunctionalInterface
interface Predicate<E> {
    boolean test(E e);

    // void foo();
}

public class JavaProgram {
    static List<Integer> filter(List<Integer> data, Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for (Integer e : data) {
            if (predicate.test(e)) {
                result.add(e);
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        List<Integer> data = Arrays.asList(10, 20, 30, 40, 50);

        List<Integer> result;
        // 정책을 익명의 클래스로 전달하는 방법
        //  Java Lambda: 익명의 클래스를 통해 정책을 전달하는 방법을 대체한다.
        //  : 별도의 class 파일을 생성하지 않는다.

        // 람다의 한계!

        result = filter(data, (Integer e) -> {
            return e % 2 == 0;
        });
        System.out.println(result);

        result = filter(data, e -> e % 2 == 0);
        System.out.println(result);

        result = filter(data, integer -> integer > 20);
        System.out.println(result);

    }
}




































