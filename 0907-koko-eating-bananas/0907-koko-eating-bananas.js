/**
 * @param {number[]} piles
 * @param {number} h
 * @return {number}
 */
var minEatingSpeed = function(piles, h) {
    const n=piles.length;
    let low=1;
    let high=-Infinity;
    for(let i=0;i<n;i++){
        high=Math.max(high,piles[i]);

    }
    let ans=0;
    while(low<=high){
        let mid= Math.floor(low+(high-low)/2);
        if(solve(piles,h,mid)){
            ans=mid;
            high=mid-1;
        }else{
            low=mid+1;
        }
    }
    return ans;
};
 function solve(nums,h,mid){
    let count = 0;
    for (let i = 0; i < nums.length; i++) {
        let rem = nums[i] % mid;
        if (rem > 0) count = count + Math.floor(nums[i] / mid) + 1;
        else count = count + Math.floor(nums[i] / mid);
    }
    return count <= h;
 }