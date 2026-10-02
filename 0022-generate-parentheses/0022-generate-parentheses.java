class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, 0, 0, "", n);
        return res;
    }
    
    private void backtrack(List<String> res, int open, int close, String path, int n) {
        if (path.length() == 2 * n) {
            res.add(path);
            return;
        }
        if (open < n) {
            backtrack(res, open + 1, close, path + "(", n);
        }
        if (close < open) {
            backtrack(res, open, close + 1, path + ")", n);
        }
    }
}
