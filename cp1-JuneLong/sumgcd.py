t=int(input())

def gcd(a,b):
    if(b==0):
        return a
    else:
        return gcd(b,a%b)

for test in range(t):
    n=int(input())
    A=list(map(int,input().split()))
    M=max(A)
    SM=0
    gcdB=M
    gcdC=0
    
    for i in range(n):
        if(SM<A[i]<M):
            SM=A[i]
        if(A[i]!=M):
            gcdC=gcd(A[i],gcdC)
    if(gcdC==0):
        gcdC=gcdB

    ans1=gcdC+gcdB#######

    gcdB=SM
    gcdC=0

    for i in range(n):
        if(A[i]!=SM):
            gcdC=gcd(A[i],gcdC)
    if(gcdC==0):
        gcdC=gcdB

    ans2=gcdC+gcdB

    if(ans1>=ans2):
        print(ans1)
    else:
        print(ans2)
