from math import gcd

n,x=map(int,input().split())
ai=list(map(int,input().split()))

ai.append(x)
ai.sort()

diff=0
for i in range(n):
    d1=ai[i+1]-ai[i]
    diff=gcd(diff,d1)

print(diff)
