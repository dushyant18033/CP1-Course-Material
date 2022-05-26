from math import sqrt

t=int(input())

primes=[999999937,999999929,999999893,999999883,999999797,999999761,999999757,999999751,999999739]

for test in range(t):
    ind=0
    print(1,31623,flush=True)
    r=int(input())
    if(r==-1):
        continue
    x2=1000014129 #31623^2
    n=x2-r
    
    factors=set()
    if(n%2==0):
        factors.add(2)
        n//=2    
    while(n%2==0):
        n//=2

    i=3
    rootn=int(sqrt(n))
    while(i<rootn):
        while n%i==0:
            factors.add(i)
            n//=i
        i+=2

    if(n>2):
        factors.add(n)

    m1=primes[ind]
    ind+=1
    print(1,m1,flush=True)
    r1=int(input())
    if(r1==-1):
        continue

    m1sq=m1*m1

    P=list()
    
    for i in factors:
        if m1sq%i==r1:
            P.append(i)

    while(len(P)>1 and ind<9):
        m=primes[ind]
        ind+=1
        temp=list()
        print(1,m,flush=True)
        r=int(input())
        if(r==-1):
            continue
        m2=m*m
        for i in P:
            if(m2%i==r):
                temp.append(i)
        P=temp

    print(2,P[0],flush=True)
        
    s=input()
    if(s=="No"):
        continue
