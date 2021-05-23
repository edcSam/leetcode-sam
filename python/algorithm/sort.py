"""
Yang Rong Individual Service
All Rights Reserved @2021

排序相关算法的实现。

@author: Yang Rong
@version 1.0
@email: samyang3125c@gmail.com
@create: 2021-04-05
"""


def bubble_sort(arr):
    """
    冒泡排序的实现。
    :param arr: list to sort.
    :return: list: sorted arr.
    """
    _len = len(arr)
    for i in range(_len - 1):
        for j in range(_len - 1 - i):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
    return arr


def insert_sort(arr):
    """
    插入排序的实现。
    :param arr: list to sort.
    :return: list: sorted arr.
    """
    _len = len(arr)
    for i in range(1, _len):
        insert = arr[i]
        pos = i - 1
        while pos >= 0 and arr[pos] > insert:
            arr[pos + 1] = arr[pos]
            pos -= 1
        arr[pos + 1] = insert
    return arr


def select_sort(arr):
    """
    选择排序的实现。
    :param arr: list to sort.
    :return: list: sorted arr.
    """
    _len = len(arr)
    for i in range(_len):
        pos = i
        for j in range(i, _len):
            if arr[j] < arr[pos]:
                pos = j
        arr[i], arr[pos] = arr[pos], arr[i]
    return arr


def merge_sort(arr):
    """
    归并排序的实现。
    :param arr: list to sort.
    :return: list: sorted arr.
    """

    def partition(array, left, right):
        if left >= right:
            return
        mid = left + ((right - left) >> 1)
        # 递归分区。
        partition(array, left, mid)
        partition(array, mid + 1, right)
        # 分到无法拆分之后，分区天然有序，然后有序合并各分区。
        merge(array, left, mid, right)

    def merge(array, left, mid, right):
        # 直到某个分区所有的元素均完成排序。
        i = left
        j = mid + 1
        tmp = []
        while i <= mid and j <= right:
            if array[i] < array[j]:
                tmp.append(array[i])
                i += 1
            else:
                tmp.append(array[j])
                j += 1
        # 将未完成排序的那个分区剩余的元素进行填充。
        if i > mid:
            start, end = j, right
        else:
            start, end = i, mid
        for E in array[start: end + 1]:
            tmp.append(E)
        # 将排序完的数据按顺序拷回原数组。
        for offset in range(right - left + 1):
            array[left + offset] = tmp[offset]

    partition(arr, 0, len(arr) - 1)
    return arr


def quick_sort(arr):
    """
    快速排序的实现。
    :param arr: list to sort.
    :return: list: sorted arr.
    """

    def partition(array, left, right):
        if left >= right:
            return
        p = quick(array, left, right)
        partition(array, left, p - 1)
        partition(array, p + 1, right)

    def quick(array, left, right):
        # 选取分界元素和分界游标。
        pivot = array[right]
        p = left
        # 与分界元素比较，分界游标左边均小于它、右边和自身均大于它。
        for i in range(left, right):
            if array[i] < pivot:
                array[p], array[i] = array[i], array[p]
                p += 1
        # 将分界元素和分界游标元素对调。
        array[p], array[right] = pivot, array[p]
        return p

    partition(arr, 0, len(arr) - 1)
    return arr


def heap_sort(arr):
    """
    堆排序的实现。
    :param arr: list to sort.
    :return: list: sorted arr.
    """

    def heapify(data, index, size=None):
        if not size:
            size = len(data)
        while True:
            # bigger_pos 引入可以帮助左右子节点的比较，还可以用作终止判断。
            bigger_pos = index
            if 2 * index < size and data[index] < data[2 * index]:
                bigger_pos = 2 * index
            if 2 * index + 1 < size and data[bigger_pos] < data[2 * index + 1]:
                bigger_pos = 2 * index + 1
            if bigger_pos == index:
                break
            data[index], data[bigger_pos] = data[bigger_pos], data[index]
            index = bigger_pos

    def build(data):
        data.insert(0, None)
        # 满二叉树的第 n/2 + 1 至 n 个节点是叶子结点，循环从 n/2 个开始。
        # 加入哨兵节点后 len(data) - 1，因此是 int((len(data) - 1) / 2)。
        # 第几个节点比数组的下标多一，而哨兵节点又需要补一。int((len(data) - 1) / 2) - 1 + 1。
        for i in range(int((len(data) - 1) / 2), 0, -1):
            heapify(data, i)

    # 待排序数组的堆化处理。
    build(arr)
    # 不断处理大顶堆堆顶，原地排序。
    for j in range(len(arr) - 1, 0, -1):
        arr[1], arr[j] = arr[j], arr[1]
        heapify(arr, 1, j)
    return arr[1:]


if __name__ == '__main__':
    sorted_arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    print(f'bubble_sort() is {"ok" if bubble_sort([4, 3, 5, 7, 8, 1, 2, 9, 6]) == sorted_arr else "not ok"}.')
    print(f'insert_sort() is {"ok" if insert_sort([4, 3, 5, 7, 8, 1, 2, 9, 6]) == sorted_arr else "not ok"}.')
    print(f'select_sort() is {"ok" if select_sort([4, 3, 5, 7, 8, 1, 2, 9, 6]) == sorted_arr else "not ok"}.')
    print(f'merge_sort() is {"ok" if merge_sort([4, 3, 5, 7, 8, 1, 2, 9, 6]) == sorted_arr else "not ok"}.')
    print(f'quick_sort() is {"ok" if quick_sort([4, 3, 5, 7, 8, 1, 2, 9, 6]) == sorted_arr else "not ok"}.')
    print(f'heap_sort() is {"ok" if heap_sort([4, 3, 5, 7, 8, 1, 2, 9, 6]) == sorted_arr else "not ok"}.')
