import heapq

n,k=map(int,input().split())
money=list(map(int,input().split()))
dist=list(range(n))

H=[]

for i in range(n):
    heapq.heappush(H,(money[i],dist[i]))

for i in range(k):
    old=heapq.heappop(H)
    heapq.heappush(H,(old[0]+1,old[1]))

Hdash=[]

for j in range(n):
    A=heapq.heappop(H)
    heapq.heappush(Hdash,(A[1],A[0]))

output=''
for j in range(n):
    popped=heapq.heappop(Hdash)
    output+=str(popped[1])+" "

print(output)
