t=int(input())

for test in range(t):
    n,first=map(int,input().split())
    ctr=(first-1)%1000000007

    last=first+n-1

    diff=(first-n) #A
    if(diff<=0):
        print(ctr)
        continue
    
    diff=diff%1000000007
    inc=1-n #D

    while(True):
        ctr=(ctr+(diff%1000000007))%1000000007
        diff+=inc
        if(diff<=0):
            break
    print(ctr)
