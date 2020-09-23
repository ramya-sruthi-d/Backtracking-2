//Time Complexity: O(n*2^n)
//Space Complexity: O(n)
//Did it run on leetcode: yes
//Problems faced any: No
import java.util.*;
public class Problem72 {
    public List<List<String>> partition(String s) {
        List<List<String>> output = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtrack(output, s, path, 0);
        return output;
    }

    private void backtrack(List<List<String>> output, String s, List<String> path, int index){
        //base case
        if(index>=s.length()){
            output.add(new ArrayList<>(path));
            return;
        }


        //recursive
        for(int i=index; i<s.length(); i++){
            String str = s.substring(index, i+1);
            if(isPalindrome(str)){
                path.add(str);
                backtrack(output, s, path, i+1);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String str){
        int i=0;
        int j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j))
                return false;
            else{
                i++;
                j--;
            }
        }
        return true;
    }
}
