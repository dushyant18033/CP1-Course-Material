t=int(input())
for test in range(t):
    n,k=map(int,input().split())
    div=n//k
    one=div
    two=(div//k)*k
    if(div%k>0):
        two+=k
    if(one==two):
        print("NO")
    else:
        print("YES")
