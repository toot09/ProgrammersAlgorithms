class cdggcsg {
    public String solution(String s) {
        String[] nums = s.split(" ");
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(String num : nums) {
            max = Math.max(max, Integer.valueOf(num));
            min = Math.min(min, Integer.valueOf(num));
        }
        return String.valueOf(min)+" "+String.valueOf(max);
    }
}