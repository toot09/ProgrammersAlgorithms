import java.util.*;
class 매칭_점수 {
    private int[] scores;
	private int[] extCnt;
	private Map<String, List<Integer>> extUrl;
	private Map<Integer, String> url;
    public int solution(String word, String[] pages) {
        scores = new int[pages.length];
        extCnt = new int[pages.length];
        extUrl = new HashMap<>();
        url = new HashMap<>();
        int ret = 0;
        double retScore = Long.MIN_VALUE;
        
        word = word.toLowerCase();
        
        for(int i=0 ; i<pages.length ; i++) {
        	// lowercase
        	String page = pages[i].toLowerCase();        	
        	init(page, word, i);
        }
        
        for(int i=0 ; i<pages.length ; i++) {	
        	double score = scores[i];
        	if(extUrl.containsKey(url.get(i))) {
	        	for(int extIdx : extUrl.get(url.get(i))) {		
	        		// 외부 url이 없는 경우는 0나누기 에러날텐데?
	        		score += (double)scores[extIdx]/(double)extCnt[extIdx];
	        	}
        	}
        	if(retScore<score) {
        		retScore = score;
        		ret = i;
        	}
        }
        
        return ret;
    }
	
	public void init(String page, String word, int idx) {
		
    	// Get url(실패)
		//int urlStart=page.indexOf("https"); // https가 url 앞에 있을 수도 있나보다.
		//int urlEnd=page.indexOf("\"",urlStart);
		//String curUrl = page.substring(urlStart, urlEnd);
        
        // Get url
        String urlPattern = "<meta property=\"og:url\" content=\"";
		int urlStart = page.indexOf(urlPattern) + urlPattern.length();
		int urlEnd = page.indexOf("\"/>", urlStart);
		String curUrl = page.substring(urlStart, urlEnd);
		url.put(idx, curUrl);

		// Set External url
		String[] aHerf = page.split("<a href=\"");
		for(int a=1 ; a<aHerf.length ; a++) {
			// 연결된 url
			String linkedUrl = aHerf[a].substring(0, aHerf[a].indexOf("\""));
			// 연결 url에 현재 url 추가
			if(!extUrl.containsKey(linkedUrl)) extUrl.put(linkedUrl, new ArrayList<>());
			extUrl.get(linkedUrl).add(idx);
		}
		
		// Set Extrenal url Count
		extCnt[idx] = aHerf.length-1;
		
		// Set score
		page = page.replaceAll("[^a-zA-Z]", " ");
		
		scores[idx] = countWord(page.split(" "), word);
		return;
	}
	
	public int countWord(String[] words, String word) {
		int cnt=0;
		for(String w : words) {
			if(w.equals(word)) cnt++;
		}
		return cnt;
	}
}