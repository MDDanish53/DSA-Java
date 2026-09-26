class NextGreaterElementI {
    // brute force
    // public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    //     int[] res = new int[nums1.length];
    //     boolean found = false;
    //     for(int i = 0; i < nums1.length; i++) {
    //         found = false;
    //         for(int j = 0; j < nums2.length; j++) {
    //             if(nums1[i] == nums2[j]) {
    //                 found = true;
    //             }
    //             if(found && nums2[j] > nums1[i]) {
    //                 res[i] = nums2[j];
    //                 break;
    //             }
    //         }
    //     }
    //     for(int i = 0; i < res.length; i++) {
    //         if(res[i] == 0) {
    //             res[i] = -1;
    //         }
    //     }
    //     return res;
    // }

    // another brute force
    // public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    //     int[] res = new int[nums1.length];
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     // storing nums2 value and its index in the map 
    //     for(int i = 0; i < nums2.length; i++) {
    //         map.put(nums2[i], i);
    //     }

    //     for(int i = 0; i < nums1.length; i++) {
    //         for(int j = map.get(nums1[i]) + 1; j < nums2.length; j++) {
    //             if(nums2[j] > nums1[i]) {
    //                 res[i] = nums2[j];
    //                 break;
    //             }
    //         }
    //     }

    //     for(int i = 0; i < res.length; i++) {
    //         if(res[i] == 0) res[i] = -1;
    //     }

    //     return res;
    // }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nums2.length; i++) {
            while(!stack.isEmpty() && stack.peek() < nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        for(int i : stack) {
            map.put(i, -1);
        }
        for(int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}