t=int(input())

for test in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    count=dict()
    sums=dict()
    xor=[0]*n
    xor[0]=a[0]
    for i in range(1,n):
        xor[i]=xor[i-1]^a[i]
        
    ans=0
    for i in range(n):
        temp=xor[i]
        if(temp==0):
            ans+=i
        if(temp in count.keys()):
            ans+=(i*count[temp] - sums[temp])
        
        count[temp]=count.get(temp,0)+1
        sums[temp]=sums.get(temp,0)+(i+1)

    print(ans)
