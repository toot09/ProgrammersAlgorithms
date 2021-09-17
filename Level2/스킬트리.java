class skilltree {
    public int solution(String skill, String[] skill_trees) {
        char[] steps = skill.toCharArray();
        int answer = skill_trees.length;
        for(String skill_tree : skill_trees) {
            boolean stop = false;
            int idx = -1;
            for(char step : steps) {
                int i = skill_tree.indexOf(step);
                if(i==-1) {
                    stop = true;
                    continue;
                }
                if(stop || i<=idx) {
                    answer--;
                    break;
                }
                idx = i;
            }
        }
        return answer;
    }
}