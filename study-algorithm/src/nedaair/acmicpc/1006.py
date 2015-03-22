#-*- coding: utf-8 -*-ß
__author__ = 'nedaair'



allyCnt   = 100
row       = 8
EnemyRow1 = [70, 60, 55, 43, 57, 60, 44, 50]
EnemyRow2 = [58, 40, 47, 90, 45, 52, 80, 40]
killLoc = 0


ignoreRow1Idx  = []
ignoreRow2Idx  = []



for idx, i in enumerate(EnemyRow1) :

    if idx in ignoreRow1Idx : continue

    if idx == row - 1 :
        if allyCnt >= EnemyRow1[idx] + EnemyRow1[0] :
            ignoreRow1Idx.append(idx+1)
            killLoc += 1
            continue

    else :
        if allyCnt >= EnemyRow1[idx] + EnemyRow1[idx+1] :
            ignoreRow1Idx.append(idx+1)
            killLoc += 1
            continue

    if allyCnt >= EnemyRow1[idx] + EnemyRow2[idx] :
        ignoreRow2Idx.append(idx)
        killLoc += 1
        continue



for idx, i in enumerate(EnemyRow2) :

    if idx in ignoreRow2Idx  or idx +1 in ignoreRow2Idx: continue

    if idx == row - 1 :
        if allyCnt >= EnemyRow2[idx] + EnemyRow2[0] :
            ignoreRow1Idx.append(idx+1)
            killLoc += 1
            continue
    else :
        if allyCnt >= EnemyRow2[idx] + EnemyRow2[idx+1] :
            ignoreRow1Idx.append(idx+1)
            killLoc += 1
            continue


print (( row * 2 ) - (killLoc * 2)) + killLoc



