
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Sample {
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
        result = filter(data, new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        });
        System.out.println(result);

        result = filter(data, new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 1;
            }
        });
        System.out.println(result);

        result = filter(data, new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 20;
            }
        });
        System.out.println(result);

    }
}
