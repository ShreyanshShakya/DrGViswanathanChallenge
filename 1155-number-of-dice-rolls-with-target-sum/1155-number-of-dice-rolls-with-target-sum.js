/**
 * @param {number} n
 * @param {number} k
 * @param {number} target
 * @return {number}
 */
var numRollsToTarget = function(d, f, target) {
       let DP = [];
    for (let i = 0; i<= d; i++) {
        for (let t = 0; t <= target; t++) {
            let sum = 0;
            if (!DP[i]) {
                DP[i] = [];
            }
            if (i === 0) {
                DP[i][t] = 0;
                continue;
            }
            if (t === 0) {
                DP[i][t] = 0;
                continue;
            }
            if (t <= f && i == 1) {
                sum++;
            }
            let prev = DP[i-1];
            if (prev) {
                for (let j = 1; j <= f; j++) {
                    if (prev[t - j]) {
                        sum += prev[t-j];
                    }
                }
            }
            DP[i][t] = sum % (Math.pow(10, 9) + 7);
        }
    }
    return DP[d][target] % (Math.pow(10,9) + 7);
};