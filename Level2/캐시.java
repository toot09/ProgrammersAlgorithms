import java.util.*;
class 캐시 {
    private int cache_hit = 1;
    private int cache_miss = 5;
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();
        for(String city : cities) {
            city = city.toLowerCase();
            if(cache.contains(city) && cacheSize>0) {
                answer += cache_hit;
                cache.remove(city);
            } else {
                answer += cache_miss;
                if(cache.size()==cacheSize) {
                    cache.pollLast();
                }
            }
            cache.offerFirst(city);
        }
        return answer;
    }
}
