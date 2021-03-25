"""
Yang Rong Individual Service
All Rights Reserved @2021

二分搜索及二分搜索的变化形式代码实现。

@author: Yang Rong
@version 1.0
@email: samyang3125c@gmail.com
@create: 2021-03-25
"""


def binary_search_with_loop(nums, target):
    """
    循环实现的二分查找。
    :param nums: 被查找的集合。
    :param target: 查找的目标元素。
    :return: int，存在则返回下标，否则返回 -1。
    """
    left, right, ans = 0, len(nums) - 1, -1
    while left <= right:
        mid = left + ((right - left) >> 1)
        if nums[mid] < target:
            left = mid + 1
        elif nums[mid] > target:
            right = mid - 1
        else:
            ans = mid
            break
    return ans


def binary_search_with_insert(nums, target):
    """
    循环实现的二分查找，不存在则寻在合适插入位置以保持数组有序。
    :param nums: 被查找的集合。
    :param target: 查找的目标元素。
    :return: int，如果存在则返回下标，如果不存在则返回插入后且保持数组有序的下标。
    """
    left, right, ans = 0, len(nums) - 1, -1
    while left <= right:
        mid = left + ((right - left) >> 1)
        if nums[mid] < target:
            left = mid + 1
        elif nums[mid] > target:
            right = mid - 1
        else:
            ans = mid
            break
    return ans if ans != -1 else left


def binary_search_with_recursion(nums, target):
    """
    递归实现的二分查找。
    :param nums: 被查找的集合。
    :param target: 查找的目标元素。
    :return: int，存在则返回下标，否则返回 -1。
    """

    def recursion_helper(left, right):
        if left > right:
            return -1
        mid = left + ((right - left) >> 1)
        if nums[mid] < target:
            return recursion_helper(mid + 1, right)
        elif nums[mid] > target:
            return recursion_helper(left, mid - 1)
        else:
            return mid

    return recursion_helper(0, len(nums) - 1)


if __name__ == '__main__':
    # init some test case including conner case.
    data1 = [1]
    target1 = 1
    data2 = [1, 2]
    target2 = 1
    data3 = [1, 2]
    target3 = 2
    data4 = [1, 2, 3]
    target4 = 2
    data5 = [1, 3, 5]
    target5 = 2
    data6 = [1, 3, 5]
    target6 = 4
    # test binary_search_with_loop.
    print(binary_search_with_loop(data1, target1) == 0)
    print(binary_search_with_loop(data2, target2) == 0)
    print(binary_search_with_loop(data3, target3) == 1)
    print(binary_search_with_loop(data4, target4) == 1)
    print(binary_search_with_loop(data5, target5) == -1)
    print(binary_search_with_loop(data6, target6) == -1)
    # test binary_search_with_recursion.
    print(binary_search_with_recursion(data1, target1) == 0)
    print(binary_search_with_recursion(data2, target2) == 0)
    print(binary_search_with_recursion(data3, target3) == 1)
    print(binary_search_with_recursion(data4, target4) == 1)
    print(binary_search_with_recursion(data5, target5) == -1)
    print(binary_search_with_recursion(data6, target6) == -1)
    # test binary_search_with_recursion.
    print(binary_search_with_insert(data1, target1) == 0)
    print(binary_search_with_insert(data2, target2) == 0)
    print(binary_search_with_insert(data3, target3) == 1)
    print(binary_search_with_insert(data4, target4) == 1)
    print(binary_search_with_insert(data5, target5) == 3)
    print(binary_search_with_insert(data6, target6) == 2)
