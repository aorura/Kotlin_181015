
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Sample2 {
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




