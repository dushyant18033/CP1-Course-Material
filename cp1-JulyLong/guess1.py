from math import sqrt

t=int(input())

for test in range(t):
    print(1,31623,flush=True)
    r=int(input())
    if(r==-1):
        continue
    x2=1000014129 #31623^2
    n=x2-r
    
    factors=list()
    if(n%2==0):
        factors.append(2)
        n//=2    
    while(n%2==0):
        n//=2

    i=3
    rootn=int(sqrt(n))
    while(i<=rootn):
        if n%i==0:
            factors.append(i)
            n//=i
        while n%i==0:
            n//=i
        i+=2

    if(n>2):
        factors.append(n)

    if(len(factors)==1):
        print(2,factors[0],flush=True)
    else:
        x1=50101
        print(1,x1,flush=True)
        r1=int(input())
        if(r1==-1):
            continue

        x1sq=x1*x1
        ans=0
        for i in factors:
            if x1sq%i==r1:
                ans=i

        print(2,ans,flush=True)
        
    s=input()
    if(s=="No"):
        continue
