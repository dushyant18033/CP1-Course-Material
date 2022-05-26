t=int(input())

for test in range(t):
    n,m=map(int,input().split())
    Ci=[0]+list(map(int,input().split()))
    
    Cust=list()
    money=0
    for i in range(n):
        D,F,B=map(int,input().split())
        if(Ci[D]>0):
            money+=F
            Ci[D]-=1
            Cust.append(D)
        else:
            money+=B
            maxFreq=1
            for i in range(2,m+1):
                if(Ci[i]>Ci[maxFreq]):
                    maxFreq=i
            Cust.append(maxFreq)
            Ci[maxFreq]-=1
    print(money)
    for i in Cust:
        print(i,end=' ')
