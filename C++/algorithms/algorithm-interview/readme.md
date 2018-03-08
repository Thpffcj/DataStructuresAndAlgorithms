## 玩儿转算法面试

## 课程源码目录 

- 算法面试优秀不意味着技术面试优秀
- 技术面试优秀不意味着能够拿到offer


- 如何准备算法面试
  - 算法面试并没有那么难
  - 学习切忌完美主义（高级数据结构和算法面试提及的概率很低 e.g. 红黑树 B-Tree 斐波那契堆 计算几何 数论 FFT）
  - 不要轻视基础算法和数据结构，而只关注"有意思"的题目。
  - 在学习和实践做题之间，要掌握平衡。


- 解决算法面试问题的整体思路
  - 注意题目中的条件：
    1. 给定一个有序数组。
    2. 有一些题目中的条件本质是暗示
  - 当没有思路的时候：
    1. 自己给自己几个简单的测试用例，试验一下。
    2. 不要忽视暴力解法，暴力解法通常是思考的起点。


- 优化算法：
  1. 遍历常见的算法思路
  2. 遍历常见的数据结构
  3. 空间和时间的交换(哈希表)
  4. 预处理信息(排序)
  5. 在瓶颈初寻找答案(O(nlogn)+O(n^2);O(n^3))


- 实际编写问题
  1. 极端条件的判断
  2. 变量名
  3. 模块化，复用性


- 一个时间复杂度的问题
- 有一个字符串数组，将数组中的每一个字符串按照字母序排序；之后再将整个字符串数组按照字典序排序。整个操作的时间复杂度？
  - 假设最长的字符串长度为s；数组中有n个字符串
  - 对每个字符串排序：O(slogs)
  - 将数组中的每一个字符串按照字母序排序：O(n*slog(s))
  - 将整个字符串数组按照字典序排序：O(s*nlog(n))
O(n*slog(s))+O(s*nlog(n))=O(n*s*(logs+logn))


- 算法复杂度在有些情况是用例相关的
  - 插入排序算法O(n^2)
    -最差情况：O(n^2)
    - 最好情况：O(n)
  - 快速排序算法O(nlogn)
    - 最差情况：O(n^2)
    - 最好情况：O(nlogn)


- 数据规模的概念：如果要想在1S之内解决问题：
  1. O(n^2)的算法可以处理大约10^4级别的数据；
  2. O(n)的算法可以处理大约10^8级别的数据；
  3. O(nlogn)的算法可以处理大约10^7级别的数据；
实际情况由于系数，处理数据量可能更少。


- 空间复杂度
  - 递归调用是有空间代价的
  - 递归的深度是多少，空间复杂度就是多少。


- 如何写出正确的程序
  - 写一个二分查找法：对于有序数组，才能使用二分查找法。保持循环的不变量。(定义在[l...r]的范围里寻找target)
    1. 明确变量的含义
    2. 循环不变量
    3. 小数据量调试
    4. 大数据量测试