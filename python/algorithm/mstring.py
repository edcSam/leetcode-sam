"""
Yang Rong Individual Service
All Rights Reserved @2021

字符串相关算法实现。

@author: Yang Rong
@version 1.0
@email: samyang3125c@gmail.com
@create: 2021-04-23
"""


def bf(primary, pattern):
    """
    单模式串匹配的 BF(Brute Force) 的实现。
    :param primary: 主串。
    :param pattern: 模式串。
    :return: int，模式串在主串中存在的起始下标，-1 表示模式串在主串中不存在。
    """
    len_primary = len(primary)
    len_pattern = len(pattern)
    # 主串长度小于模式串，直接返回不存在。
    if len_primary < len_pattern:
        return -1
    # 开始做 BF 匹配。
    for i in range(len_primary - len_pattern + 1):
        if not pattern[0] == primary[i]:
            continue
        j = len_pattern - 1
        while j >= 0:
            if pattern[j] != primary[i + j]:
                break
            j -= 1
        if j < 0:
            return i
    return -1


def rk(primary, pattern):
    """
    单模式串匹配的 RK(Rabin-Karp) 的实现。
    该版本仅适用于小写英文字母。
    :param primary: 主串。
    :param pattern: 模式串。
    :return: int，模式串在主串中存在的起始下标，-1 表示模式串在主串中不存在。
    """
    len_primary = len(primary)
    len_pattern = len(pattern)
    # 主串长度小于模式串，直接返回不存在。
    if len_primary < len_pattern:
        return -1
    # 初始化自定义哈希值。
    pos = ord('a')
    carry = [pow(26, x) for x in range(len_pattern - 1, -1, -1)]
    hash_primary = 0
    hash_pattern = 0
    for m in range(len_pattern):
        hash_primary += (ord(primary[m]) - pos) * carry[m]
        hash_pattern += (ord(pattern[m]) - pos) * carry[m]
    # 开始做 RK 匹配。
    if hash_pattern == hash_primary:
        return 0
    for i in range(1, len_primary - len_pattern + 1):
        hash_primary = 26 * (hash_primary - carry[0] * (ord(primary[i - 1]) - pos)) + (
                    ord(primary[i + len_pattern - 1]) - pos)
        if hash_pattern == hash_primary:
            return i
    return -1


if __name__ == '__main__':
    s1 = 'dkalfjappjgeihappledfjadfdsa'
    s2 = 'apple'
    s3 = 'dkalfjappjgeihappladfjadfdsa'
    print(bf(s1, s2))
    print(bf(s3, s2))
    print(rk(s1, s2))
    print(rk(s3, s2))
