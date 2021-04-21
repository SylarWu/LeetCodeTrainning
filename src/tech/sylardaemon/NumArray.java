package tech.sylardaemon;

public class NumArray {
    private int n;
    private int[] tree;

    private void buildTree(int [] nums){
        this.tree = new int[this.n * 2];
        for (int i = nums.length,j = 0;i < this.tree.length; ++i,++j){
            this.tree[i] = nums[j];
        }
        for (int i = nums.length - 1; i > 0; --i){
            this.tree[i] = this.tree[2 * i] + this.tree[2 * i + 1];
        }
    }

    public NumArray(int[] nums) {
        this.n = nums.length;
        this.buildTree(nums);
    }

    public void update(int index, int val) {
        int loc = this.n + index;
        this.tree[loc] = val;
        while (loc >= 1){
            loc /= 2;
            tree[loc] = tree[2 * loc] + tree[2 * loc + 1];
        }

    }

    public int sumRange(int left, int right) {
        int sum = 0;
        int l = this.n + left;
        int r = this.n + right;
        while (l <= r){
            if (l % 2 == 1){
                sum += this.tree[l];
                ++l;
            }
            if (r % 2 == 0){
                sum += this.tree[r];
                --r;
            }
            l /= 2;
            r /= 2;
        }
        return sum;
    }
}
