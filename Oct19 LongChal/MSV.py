t=int(input())

for tes in range(t):
    n=int(input())
    A=list(map(int,input().split()))
    star=[0]
    for i in range(1,n):
        ctr=0
        for j in range(i-1,-1,-1):
            if(A[j]%A[i]==0):
                ctr+=1
        star.append(ctr)
    print(max(star))
