t=int(input())
for test in range(t):
    n,m=map(int,input().split())
    Vi=[0]*m
    for i in range(n):
        D,V=map(int,input().split())
        if(V>Vi[D-1]):
            Vi[D-1]=V
    Vi.sort()
    print(Vi[-1]+Vi[-2])
