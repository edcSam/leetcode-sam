"""
Yang Rong Individual Service
All Rights Reserved @2021

堆相关的实现。
todo 有空可以重构一下，共有代码可提出来，大小顶堆主要是比较不用，可用函数式编程统一。

@author: Yang Rong
@version 1.0
@email: samyang3125c@gmail.com
@create: 2021-05-23
"""


class BigHeap:
    """
    大顶堆。
    """

    def __init__(self, data=None):
        """
        大顶堆的初始化。
        """
        self.data = [None]
        if data:
            self.build(data)

    def build(self, data):
        """
        从前往后，从下往上实现大顶堆。
        :param data: 待建堆的数组。
        :return: None.
        """
        for d in data:
            self.insert(d)

    def pop(self):
        """
        弹出堆顶元素。
        :return: int.
        """
        if len(self.data) > 1:
            data = self.data[1]
        else:
            return None
        self.delete(data)
        return data

    def insert(self, data):
        """
        插入元素，并保持堆化。
        :param data: 待插入的元素。
        :return: None.
        """
        self.data.append(data)
        index = len(self.data) - 1
        while int(index / 2) > 0 and self.data[index] > self.data[int(index / 2)]:
            self.data[index], self.data[int(index / 2)] = self.data[int(index / 2)], self.data[index]
            index = int(index / 2)

    def delete(self, data):
        """
        删除元素，并保持堆化。
        :param data: 待删除元素。
        :return: None
        """
        # 堆中仅有哨兵元素。
        if len(self.data) <= 1 or data not in self.data:
            return
        # 删除的元素是数组最后一个，直接弹出，堆化自动保持。
        index = self.data.index(data)
        if index + 1 == len(self.data):
            self.data.pop(-1)
            return
        # 删除的元素不是数组最后一个，删除后，采用自顶向下堆化。
        self.data[index], self.data[-1] = self.data[-1], self.data[index]
        self.data.pop(-1)
        size = len(self.data)
        while True:
            bigger_pos = index
            if 2 * index < size and self.data[index] < self.data[2 * index]:
                bigger_pos = 2 * index
            if 2 * index + 1 < size and self.data[bigger_pos] < self.data[2 * index + 1]:
                bigger_pos = 2 * index + 1
            if bigger_pos == index:
                break
            self.data[index], self.data[bigger_pos] = self.data[bigger_pos], self.data[index]
            index = bigger_pos


class SmallHeap:
    """
    小顶堆。
    """

    def __init__(self, data=None):
        """
        小顶堆的初始化。
        """
        self.data = [None]
        if data:
            self.build(data)

    def build(self, data):
        """
        从后往前，从上往下实现小顶堆。
        :param data: 待建堆的数组。
        :return: None.
        """
        begin_pos = int(len(data) / 2) + 1  # 考虑哨兵元素，需要加一。
        self.data += data
        size = len(self.data)
        for i in range(begin_pos, 0, -1):
            index = i
            while True:
                bigger_pos = index
                if 2 * index < size and self.data[index] > self.data[2 * index]:
                    bigger_pos = 2 * index
                if 2 * index + 1 < size and self.data[bigger_pos] > self.data[2 * index + 1]:
                    bigger_pos = 2 * index + 1
                if bigger_pos == index:
                    break
                self.data[index], self.data[bigger_pos] = self.data[bigger_pos], self.data[index]
                index = bigger_pos

    def pop(self):
        """
        弹出堆顶元素。
        :return: int.
        """
        if len(self.data) > 1:
            data = self.data[1]
        else:
            return None
        self.delete(data)
        return data

    def insert(self, data):
        """
        插入元素，并保持堆化。
        :param data: 待插入的元素。
        :return: None.
        """
        self.data.append(data)
        index = len(self.data) - 1
        while int(index / 2) > 0 and self.data[index] < self.data[int(index / 2)]:
            self.data[index], self.data[int(index / 2)] = self.data[int(index / 2)], self.data[index]
            index = int(index / 2)

    def delete(self, data):
        """
        删除元素，并保持堆化。
        :param data: 待删除元素。
        :return: None
        """
        # 堆中仅有哨兵元素。
        if len(self.data) <= 1 or data not in self.data:
            return
        # 删除的元素是数组最后一个，直接弹出，堆化自动保持。
        index = self.data.index(data)
        if index + 1 == len(self.data):
            self.data.pop(-1)
            return
        # 删除的元素不是数组最后一个，删除后，采用自顶向下堆化。
        self.data[index], self.data[-1] = self.data[-1], self.data[index]
        self.data.pop(-1)
        size = len(self.data)
        while True:
            bigger_pos = index
            if 2 * index < size and self.data[index] > self.data[2 * index]:
                bigger_pos = 2 * index
            if 2 * index + 1 < size and self.data[bigger_pos] > self.data[2 * index + 1]:
                bigger_pos = 2 * index + 1
            if bigger_pos == index:
                break
            self.data[index], self.data[bigger_pos] = self.data[bigger_pos], self.data[index]
            index = bigger_pos


if __name__ == '__main__':
    # 大顶堆的测试，也可用 LeetCode.215 测试。
    big_heap = BigHeap()
    big_heap.build([3, 2, 1])
    print(big_heap.pop() == 3)
    print(big_heap.pop() == 2)
    # 小顶堆的测试，也可用 LeetCode 剑指 Offer.40 测试。
    small_heap = SmallHeap()
    small_heap.build([3, 2, 1])
    print(small_heap.pop() == 1)
    print(small_heap.pop() == 2)
