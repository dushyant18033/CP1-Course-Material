t=int(input())

for test in range(t):
    n=int(input())
    A=list(map(int,input().split()))

    k=n

    score=0
    for i in range(n-1):
        minPair=A[0]+A[-1]
        ind=-1
        k-=1
        for j in range(k):
            cur=A[j]+A[j+1]
            if(cur<minPair):
                minPair=cur
                ind=j
        print(A[ind],A[ind+1],"-",A)
        if(ind==-1):
            A[0]=minPair
            A=A[:-1]
        else:
            A=A[:ind]+[minPair]+A[ind+2:]

        score+=minPair

    print(score)
