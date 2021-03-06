package db.redis;

import com.thankjava.toolkit.radom.Sequence;
import com.thankjava.toolkit.thread.ThreadPool;
import com.thankjava.toolkit3d.db.redis.RedisManager;
import com.thankjava.toolkit3d.db.redis.datasource.JedisManager;

public class RedisManagerTest {

	public static void main(String[] args) {
		final RedisManager redis = JedisManager.getInstance();

//		System.out.println(redis.lpush("test", new String[]{"aa","cc","bb"}));
//		System.out.println(redis.rpop("test"));
		
		ThreadPool pool = new ThreadPool(50, 100, 600000, 1000000);
		for (int i = 0; i < 10000L; i ++) {
			pool.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(redis.set("str", "测试数据"));
					System.out.println(redis.get("str"));
				}
			});
		}
		
//		System.out.println(redis.isKeyExists("str"));
//		System.out.println(redis.setKeyExpiration("str", 10));
		
//		String[] listValue = new String[]{"aa","bb","cc","dd"};
//		System.out.println(redis.setList("list", listValue));
		
//		HashMap<String, String> hashValue = new HashMap<>();
//		hashValue.put("a", "a");
//		hashValue.put("b", "b");
//		System.out.println(redis.setHash("hash", hashValue));
		
	}
	
}

