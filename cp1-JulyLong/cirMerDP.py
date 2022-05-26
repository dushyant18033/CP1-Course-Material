t=int(input())
"""
def funcDP(nums,dp):
    for i in range(n-1):
        for j in range(i+1,n):
            sumij=nums[i]+nums[j]
            for k in range(i,j):
                if(dp[i][j]==0):
                    dp[i][j]=dp[i][k]+dp[k+1][j]+sumij
                else:
                    dp[i][j]=min(dp[i][j],dp[i][k]+dp[k+1][j])+sumij
"""

def recurDP(nums,dp,l,r):
    if(l>=r):
        return 0
    elif(r-l==1):
        dp[l][r]=nums[l]+nums[r]
        return dp[l][r]
    elif(dp[l][r]>0):
        return dp[l][r]
    else:
        sumlr=0
        for k in range(l,r+1):
            sumlr+=nums[k]
        possi=list()
        minInd=0
        for k in range(l,r):
            possi.append(recurDP(nums,dp,l,k)+recurDP(nums,dp,k+1,r))
            if(possi[k-l]<possi[minInd]):
                minInd=k-l
        dp[l][r]=possi[minInd]+sumlr
        return dp[l][r]

for test in range(t):
    n=int(input())
    nums=list(map(int,input().split()))
    for i in range(n):
        nums.append(nums[i])

    ans=list()
    for j in range(n):
        dp=list()
        for i in range(2*n):
            dp.append([0]*2*n)
        ans.append(recurDP(nums,dp,j,j+n-1))
    print(min(ans))
