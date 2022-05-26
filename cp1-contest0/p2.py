n,a,b,c=map(int,input().split())

L=[0]

def countWays(L, way, k, abc):
    if(k<0):
        way=0
        return
    if(k==0):
        if(way>L[0]):
            L[0]=way
        return

    if(abc[0]<=k):
        countWays(L, way+1, k-abc[0], abc)
    if(abc[1]<=k):
        countWays(L, way+1, k-abc[1], abc)
    if(abc[2]<=k):
        countWays(L, way+1, k-abc[2], abc)

k=min((a,b,c))

if(n%k==0):
    print(n//k)
else:
    countWays(L,0,n, (a,b,c))
    print(L[0])
