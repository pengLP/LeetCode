"""
有效的数独
判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
"""
class Solution(object):

    def containsDuplicate(self, nums):
        return len(nums) != len(set(nums))

    def isValidSudoku(self, board):
        test = []

        # 验证行元素是否重复
        for i in range(0,9):
            for j in range(0,9):
                if(board[i][j] != '.'):
                    test.append(int(board[i][j]))
            if(self.containsDuplicate(test)):
                return False
            test.clear()


        # 验证列元素是否重复
        for i in range(0,9):
            for j in range(0,9):
                if(board[j][i] != '.'):
                    test.append(int(board[j][i]))
            if(self.containsDuplicate(test)):
                return False
            test.clear()

        # 验证3x3宫格是否重复
        for i in range(0,3):
            for j in range(0, 3):
                for x in range(i*3,i*3+3):
                    for y in range(j*3,j*3+3):
                        if(board[x][y] != "."):
                            test.append(int(board[x][y]))
                if (self.containsDuplicate(test)):
                    return False
                test.clear()

        return True

if __name__ == '__main__':
    s = Solution()
    print(s.isValidSudoku([
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]))