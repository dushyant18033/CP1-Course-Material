t=int(input())
for test in range(t):
    n=int(input())
    A=list(map(int,input().split()))
    B=list(map(int,input().split()))
    maxScore=0
    for i in range(n):
        newScore=(2*A[i]-B[i])*10
        if(newScore>maxScore):
            maxScore=newScore
    print(maxScore)
