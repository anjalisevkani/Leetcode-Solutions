class Solution {
    String[] letters={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        if(digits.length()==0){
            return ans;
        }
        generate(digits,0,"",ans);
        return ans;
    }
    void generate(String digits,int index,String s,List<String> ans){
        if(index==digits.length()){
            ans.add(s);
            return;
        }
        String str=letters[digits.charAt(index)-'0'];
        for(int i=0;i<str.length();i++){
            generate(digits,index+1,s+str.charAt(i),ans);
        }
    }
}