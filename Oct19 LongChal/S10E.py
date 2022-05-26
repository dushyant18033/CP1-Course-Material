t=int(input())

for tes in range(t):
    n=int(input())
    p=list(map(int,input().split()))
    ctr=1
    for i in range(1,n):
        good=True
        for j in range(i-1,max(-1,i-6),-1):
            if(p[j]<=p[i]):
                good=False
                break
        if(good):
            ctr+=1
    print(ctr)
