class Solution {
    public int[] decrypt(int[] code, int k) {

        int n = code.length;

        int[] arr = new int[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            arr[i] = code[i % n];
        }

        if (k > 0) {

            int l = 1;
            int r = k;

            int sum = 0;

            // Initial window sum
            for (int i = l; i <= r; i++) {
                sum += arr[i];
            }

            for (int i = 0; i < n; i++) {

                code[i] = sum;

                sum -= arr[l];
                l++;

                r++;
                sum += arr[r];
            }

        }

        else if (k < 0) {

            k = -k;

            int l = n - k;
            int r = n - 1;

            int sum = 0;

            // Initial window sum
            for (int i = l; i <= r; i++) {
                sum += arr[i];
            }

            for (int i = 0; i < n; i++) {

                code[i] = sum;

                sum -= arr[l];
                l++;

                r++;
                sum += arr[r];
            }

        }

        else {

            for (int i = 0; i < n; i++) {
                code[i] = 0;
            }

        }

        return code;
    }
}