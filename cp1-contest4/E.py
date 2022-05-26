n,m=map(int,input().split())
t=list(map(int,input().split()))

sumT=10*sum(t)

dp=list()
for i in range(101):
    dp.append([0]*sumT)

def recur(ind,s):
    global t
    global m
    global n
    global dp
    
    if(ind>=n):
        #print(s)
        return s
    check=dp[ind][s]
    if(check>0):
        return check
    
    curMax=0
    findMin=float("inf")
    for i in range(ind,min(ind+m,n)):
        if(t[i]>curMax):
            curMax=t[i]
        findMin=min(findMin,recur(i+1,s+curMax))

    dp[ind][s]=findMin
    return dp[ind][s]

print(recur(0,0))
