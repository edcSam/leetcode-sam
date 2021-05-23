"""
Yang Rong Individual Service
All Rights Reserved @2021

堆相关的实现。

@author: Yang Rong
@version 1.0
@email: samyang3125c@gmail.com
@create: 2021-05-23
"""


class BigHeap:
    """
    大顶堆实现。
    """

    def __init__(self, data=None):
        """
        大顶堆的初始化。
        """
        self.data = [0]
        if data:
            self.build(data)

    def build(self, data):
        """
        插入式建堆。
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
        while int(index / 2) > 0 and self.data[index] >= self.data[int(index / 2)]:
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


if __name__ == '__main__':
    # 大顶堆测试，也可在 LeetCode.215 中测试。
    heap = BigHeap()
    heap.build([3, 2, 1])
    print(heap.pop() == 3)
    print(heap.pop() == 2)
