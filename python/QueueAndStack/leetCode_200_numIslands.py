"""
岛屿数量
给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
"""
from queue import Queue
import time
class Solution:
    def checkLand(self,route,map,x,y):
        x_q,y_q = Queue(0) , Queue(0)
        x_q.put(x)
        y_q.put(y)
        while(x_q.empty() != True):
            x , y = x_q.get() , y_q.get()
            route[x][y] = 1
            # 当前点的上方节点入队
            if(x -1 >= 0 and map[x-1][y] == "1" and route[x-1][y] == 0):
                x_q.put(x-1)
                y_q.put(y)
                route[x-1][y] = 1
            # 当前点的左边节点入队
            if(y -1 >= 0 and map[x][y-1] == "1" and route[x][y-1] ==0):
                x_q.put(x)
                y_q.put(y-1)
                route[x][y-1] = 1
            # 当前点的下方节点入队
            if(x+1 < len(map) and map[x+1][y] == "1" and route[x+1][y] ==0):
                x_q.put(x+1)
                y_q.put(y)
                route[x+1][y] = 1
            # 当前点的右边节点入队
            if(y + 1 < len(map[0]) and map[x][y+1] == "1" and route[x][y+1] == 0):
                x_q.put(x)
                y_q.put(y+1)
                route[x][y+1] = 1
    def numIslands(self, grid):
        route = [[0 for i in range(len(grid[0]))]for i in range(len(grid))]
        print(route)
        res = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if(grid[i][j] == "1" and route[i][j] == 0):
                    self.checkLand(route,grid,i,j)
                    res += 1
        return res


if __name__ == '__main__':
    s = Solution()

    print(s.numIslands([["1","1","1","1","1","0","1","1","1","1","1","1","1","1","1","0","1","0","1","1"],
                         ["0","1","1","1","1","1","1","1","1","1","1","1","1","0","1","1","1","1","1","0"],
                         ["1","0","1","1","1","0","0","1","1","0","1","1","1","1","1","1","1","1","1","1"],
                         ["1","1","1","1","0","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],
                         ["1","0","0","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],
                         ["1","0","1","1","1","1","1","1","0","1","1","1","0","1","1","1","0","1","1","1"],["0","1","1","1","1","1","1","1","1","1","1","1","0","1","1","0","1","1","1","1"],["1","1","1","1","1","1","1","1","1","1","1","1","0","1","1","1","1","0","1","1"],["1","1","1","1","1","1","1","1","1","1","0","1","1","1","1","1","1","1","1","1"],["1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],["0","1","1","1","1","1","1","1","0","1","1","1","1","1","1","1","1","1","1","1"],["1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],["1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],["1","1","1","1","1","0","1","1","1","1","1","1","1","0","1","1","1","1","1","1"],["1","0","1","1","1","1","1","0","1","1","1","0","1","1","1","1","0","1","1","1"],["1","1","1","1","1","1","1","1","1","1","1","1","0","1","1","1","1","1","1","0"],["1","1","1","1","1","1","1","1","1","1","1","1","1","0","1","1","1","1","0","0"],["1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],["1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],["1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"]]))