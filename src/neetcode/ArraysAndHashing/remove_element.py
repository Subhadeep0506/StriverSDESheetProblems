from typing import List


class RemoveElement:
    def removeElement(self, nums: List[int], val: int) -> int:
        # Put one pointer in beginning and another at end of array
        start, end = 0, len(nums) - 1
        # Move start while start and end pointers collide
        while start <= end:
            # If the number at start pointer is the value to be removed,
            # then replace it with the number at end pointer and move end pointer to left.
            if nums[start] == val:
                nums[start] = nums[end] + nums[start]
                nums[end] = nums[start] - nums[end]
                nums[start] = nums[start] - nums[end]
                end -= 1
            # If not, then move start pointer to right.
            else:
                start += 1
        return len(nums[: end + 1])


if __name__ == "__main__":
    obj = RemoveElement()
    res = obj.removeElement(
        nums=[0, 1, 2, 2, 3, 0, 4, 2],
        val=2,
    )
    print(res)
