import math

n,m=map(int,input().split())

edges=list()
dist=[math.inf]*(n+1)
for i in range(m):
    t1=tuple(map(int,input().split()))
    t2=(t1[1],t1[0],t1[2])
    edges.append(t1)
    edges.append(t2)

dist[1]=0

for i in range(n-1):
    changed=False
    for u,v,c in edges:
        newDist=dist[u]+c
        if(newDist<dist[v]):
            dist[v]=newDist
            changed=True
        
    if(not changed):
        break

if(dist[n]!=math.inf):
    print(dist[n])
else:
    print(-1)
