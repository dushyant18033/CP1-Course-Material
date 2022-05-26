import math

t=int(input())

for test in range(t):
    n,k=map(int,input().split())
    a=k-n
    d=n-1
    
    s=(k-1)
    if(a>0):
        c=(a//d)
        s+=((c+1)*(2*a-c*d)//2)
    print(s%1000000007)
