class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        """
        44 ms: 94.66%
        14.3 MB: 6.74%
        """
        dic = {}
        res = []
        for num in nums:
            dic.update({num: dic.get(num, 0) + 1})
        
        for key, value in dic.items():
            if value > len(nums) // 3:
                res.append(key)
        return res
