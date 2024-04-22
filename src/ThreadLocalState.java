import java.util.HashMap;
import java.util.Map;

public class ThreadLocalState {
    static ThreadLocal<Map<String,String>> threadData =  ThreadLocal.withInitial(() -> new HashMap<>());
}
