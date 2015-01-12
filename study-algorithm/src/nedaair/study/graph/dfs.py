__author__ = 'nedaair'

vList = [[2,3,4,6], [1,3], [1,2,5], [1,6], [3,6], [1,4,5]]

v = [1,2,3,4,5,6]

visited = []



def dfs() :

    for i in v :
        visited.append(False)

    for i in v :
        if(visited[i-1] == False) : aDfs(i)


def aDfs(x) :
    visited[x-1] = True

    for i in vList[x-1] :
        if(visited[i-1] == False) : aDfs(i)



dfs()

print visited