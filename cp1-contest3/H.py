import math

n,m=map(int,input().split())

edges=list()
dist=[math.inf]*(n+1)
for i in range(m):
    a,b,c=input().split()
    edges.append((int(a),int(b),-math.log(float(c),10)))

dist[n]=0

for i in range(n-1):
    for u,v,c in edges:
        newDist=dist[u]+c
        if(newDist<dist[v]):
            dist[v]=newDist

neg_cycle=False
for u,v,c in edges:
    newDist=dist[u]+c
    if(newDist<dist[v]):
        neg_cycle=True
        break

if(neg_cycle):
    print("yes")
else:
    print("no")
