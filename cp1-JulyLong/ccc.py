t=int(input())

for test in range(t):
    n,z=map(int,input().split())
    a=list(map(int,input().split()))
    ans=list()
    a.sort(reverse=True)
    for i in range(n):
        ans.append((i+1)*a[i])
    print(min(ans))
    
