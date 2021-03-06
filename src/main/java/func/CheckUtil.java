package func;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author linzy
 * @create 2021-04-21 11:19:58
 */
public class CheckUtil {

    public static <T> Optional<T> resolve(Supplier<T> resolver) {
        try {
            T result = resolver.get();
            return Optional.ofNullable(result);
        }
        catch (NullPointerException e) {
            // 可能会抛出空指针异常，直接返回一个空的 Optional 对象
            return Optional.empty();
        }
    }

    public static void main(String[] args) {
        Outer obj = new Outer();
        // 直接调用 resolve 方法，内部做空指针的处理
        resolve(() -> obj.getNested().getInner().getFoo())
        .ifPresent(System.out::println); // 如果不为空，最终输出 foo 的值
    }
}

// 最外层对象
class Outer {
    Nested nested;
    Nested getNested() {
        return nested;
    }
}
// 第二层对象
class Nested {
    Inner inner;
    Inner getInner() {
        return inner;
    }
}
// 最底层对象
class Inner {
    String foo;
    String getFoo() {
        return foo;
    }
}
