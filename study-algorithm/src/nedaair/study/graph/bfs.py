

from Queue import Queue


vList = [[2,3,4,6], [1,3], [1,2,5], [1,6], [3,6], [1,4,5]]

v = [1,2,3,4,5,6]

visited = []

q = Queue()


def init():
    for i in v:
        if i == 1:
            visited.append(True)
        else:
            visited.append(False)
    q.put(1)


def bfs() :

    init()


    while(not q.empty()) :

        qq = q.get()

        for i in vList[qq-1] :

            if(visited[i-1] == False) :
                visited[i-1] = True
                q.put(i)


    print visited


bfs()



