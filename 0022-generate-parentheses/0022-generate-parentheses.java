class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateParenthesis(ans, "", n, n);
        return ans;
    }

    public void generateParenthesis(List<String> ans, String s, int leftCount, int rightCount) {
        if (leftCount == 0 && rightCount == 0) {
            ans.add(s);
            return;
        }
        if (leftCount == -1 || rightCount == -1 || leftCount > rightCount) {
            System.out.println(s);
            return;
        }
        generateParenthesis(ans, s + "(", leftCount - 1, rightCount);
        generateParenthesis(ans, s + ")", leftCount, rightCount - 1);
    }
}