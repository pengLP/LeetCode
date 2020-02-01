"""
旋转图像
给定一个 n × n 的二维矩阵表示一个图像。

将图像顺时针旋转 90 度。
"""
class Solution:
    def rotate(self, matrix):
        for i in range(0,int(len(matrix)/2)):
            start = i
            end = len(matrix) - i -1
            for j in range(0,end-start):
                temp = matrix[start][start+j]
                matrix[start][start+j] = matrix[end-j][start]
                matrix[end-j][start] = matrix[end][end-j]
                matrix[end][end-j] = matrix[start + j][end]
                matrix[start+j][end] = temp

        print(matrix)


if __name__ == '__main__':
    s = Solution()
    s.rotate([
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
])

