t=int(input())


def printThem(L,s,sums):
    if(len(L)==1):
        sums.append(s)
        return
    for i in range(len(L)):
        s1=L[i]+L[i-1]
        L1=list()
        if(i==0):
            L1=[s1]+L[1:-1]
        else:
            L1=L[:i-1]+[s1]+L[i+1:]
        printThem(L1,s+s1,sums)


for test in range(t):
    n=int(input())
    nums=list(map(int,input().split()))
    sums=list()
    printThem(nums,0,sums)
    print(min(sums))
