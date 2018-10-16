class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList();

        if( nums== null || nums.length == 0){
            return  result;
        }
        List<Integer> temp = new ArrayList();
        backtracking(result, temp, 0, nums);
        return result;

    }

    private void backtracking(List<List<Integer>> result, List<Integer> temp, int startIndex, int[] nums){

        if(temp.size() == nums.length){
            result.add(new ArrayList(temp));
            return ;
        } // END of if

        for(int i = startIndex; i < nums.length ; i++){
            temp.add(nums[i]);
            swap(nums, i, startIndex);


            backtracking(result, temp, i+1, nums);

            swap(nums, i, startIndex);
            temp.remove(temp.size()-1);

        } // END of for i
    }

    private void swap(int[] nums, int i, int j ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



}


class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        permutations(nums, 0, new ArrayList<Integer>());
        return res;
    }
    public void permutations(int[] nums, int start, List<Integer> curList) {
        if (curList.size() == nums.length) {
            res.add(new ArrayList<Integer>(curList));
        }
        else {
            for (int i = start; i < nums.length; i++) {
                curList.add(nums[i]);
                swap(nums, start, i);
                permutations(nums, start + 1, curList);
                swap(nums, start, i);
                curList.remove(curList.size() - 1);
            }
        }
    }
    public void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
