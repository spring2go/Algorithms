[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

# Algorithms

数据结构和算法是良好的程序设计和高效代码的基础。如果你想要成为一个牛逼的程序员，那么掌握高效的数据结构和算法，是必须的技能。本课程的目标，是帮助广大程序员夯实数据结构和算法基础，提升抽象思维和编程能力。

本课程涉及的数据结构包括(但不限于)：数组、链表、栈、队列和优先队列，并查集，二分搜索树，哈希表，AVL 树等。

本仓库包括课程的 PPT(包括文案讲稿)，还有部分源代码。

本项目主要参考谷歌工程师 Wlliam Fiset 开源的[算法项目](https://github.com/williamfiset/Algorithms)。

# 课程大纲

| 章节 | 标题(+视频链接)                                                                             |                                                         内容                                                         |
| :--- | :------------------------------------------------------------------------------------------ | :------------------------------------------------------------------------------------------------------------------: |
| 01   | [数据结构介绍](https://www.bilibili.com/video/BV1U5411W7x9?p=1)                             |                           介绍什么是数据结构，为什么要学数据结构，还有什么是抽象数据类型。                           |
| 02   | [算法复杂度](https://www.bilibili.com/video/BV1U5411W7x9?p=2)                               |                                    介绍算法复杂度和 Big-O 标记，并分析相关案例。                                     |
| 03   | [静态和动态数组](https://www.bilibili.com/video/BV1U5411W7x9?p=3)                           |                             介绍数组概念，应用场景，支持的操作和复杂度，还有使用样例等。                             |
| 04   | [实现动态数组](https://www.bilibili.com/video/BV1U5411W7x9?p=4)                             |                                   通过现场编程，演示如何基于静态数组实现动态数组。                                   |
| 05   | [单向和双向链表](https://www.bilibili.com/video/BV1U5411W7x9?p=5)                           |                          介绍单向和双向链表，应用场景，术语，复杂度。演示如何插入和删除节点                          |
| 06   | [实现双向链表](https://www.bilibili.com/video/BV1U5411W7x9?p=6)                             |                                         通过现场编程，演示如何实现双向链表。                                         |
| 07   | [栈 Stack](https://www.bilibili.com/video/BV1U5411W7x9?p=7)                                 | 介绍什么是栈，栈有哪些使用场景，演示栈的操作，分析栈操作的复杂度。演示如何通过栈来解决括号匹配问题。演示汉诺塔游戏。 |
| 08   | [栈操作演示](https://www.bilibili.com/video/BV1U5411W7x9?p=8)                               |                                       通过 PPT 演示如何基于单向链表来实现栈。                                        |
| 09   | [实现栈(现场编程)](https://www.bilibili.com/video/BV1U5411W7x9?p=9)                         |                                        通过代码演示如何基于双向链表来实现栈。                                        |
| 10   | [队列 Queue](https://www.bilibili.com/video/BV1U5411W7x9?p=10)                              |              介绍什么是队列，队列的术语，队列有哪些使用场景，队列的操作演示，还有分析队列的操作复杂度。              |
| 11   | [队列操作演示(基于单向链表)](https://www.bilibili.com/video/BV1U5411W7x9?p=11)              |                        演示如何基于队列实现宽度优先搜索 BFS 算法，如何基于单向链表实现队列。                         |
| 12   | [实现队列(现场编程)](https://www.bilibili.com/video/BV1U5411W7x9?p=12)                      |                                       现场编程演示如何基于双向链表来实现队列。                                       |
| 13   | [优先队列 PriorityQueue(穿插讲解堆 Heap)](https://www.bilibili.com/video/BV1U5411W7x9?p=13) |         介绍什么是优先队列 PQ，有哪些应用场景，演示 PQ 的主要操作，然后分析操作复杂度。中间穿插讲解堆 Heap。         |
| 14   | [将最小堆转换成最大堆](https://www.bilibili.com/video/BV1U5411W7x9?p=14)                    |                       演示如何将最小堆(Min Heap)转换成最大堆(Max Heap)，包括数值和字符串场景。                       |
| 15   | [向二叉堆中添加元素](https://www.bilibili.com/video/BV1U5411W7x9?p=15)                      |                  介绍二叉堆和完全二叉树，解释如何基于数组来实现二叉堆，演示如何向二叉堆中添加元素。                  |
| 16   | [从二叉堆中移除元素](https://www.bilibili.com/video/BV1U5411W7x9?p=16)                      |                       演示如何从二叉堆中移除元素，然后演示如何通过哈希表优化移除操作的复杂度。                       |
| 17   | [实现二叉堆(现场编程)(上)](https://www.bilibili.com/video/BV1U5411W7x9?p=17)                |       现场编程演示如何基于 ArrayList 实现二叉堆，并且采用 HashMap 对移除 Removal 操作进行优化。这是上半部分。        |
| 18   | [实现二叉堆(现场编程)(下)](https://www.bilibili.com/video/BV1U5411W7x9?p=18)                |       现场编程演示如何基于 ArrayList 实现二叉堆，并且采用 HashMap 对移除 Removal 操作进行优化。这是下半部分。        |
| 19   | [并查集(Union Find)](https://www.bilibili.com/video/BV1U5411W7x9?p=19)                      |                                     介绍什么是并差集，应用场景，还有操作复杂度。                                     |
| 20   | [并查集应用~克努斯卡尔算法](https://www.bilibili.com/video/BV1U5411W7x9?p=20)               |                                     演示并查集的应用~克努斯卡尔最小生成树算法。                                      |
| 21   | [查找和合并操作演示](https://www.bilibili.com/video/BV1U5411W7x9?p=21)                      |                                        演示并查集的查找和合并操作是如何工作的                                        |
| 22   | [并查集路径压缩](https://www.bilibili.com/video/BV1U5411W7x9?p=22)                          |                                           演示并查集的路径压缩是如何工作的                                           |
| 23   | [实现并查集(现场编程)](https://www.bilibili.com/video/BV1U5411W7x9?p=23)                    |                                        通过现场编程演示如何基于数据实现并查集                                        |
