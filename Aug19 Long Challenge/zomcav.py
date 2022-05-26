t=int(input())
for test in range(t):
    n=int(input())
    c=list(map(int,input().split()))
    h=set(map(int,input().split()))
    
    b=[0]*n
    for i in range(n):
        for j in range(max(0,i-c[i]),min(n,i+c[i]+1)):
            b[j]+=1

    s1=set(b)

    if(s1==h):
        print("YES")
    else:
        print("NO")
