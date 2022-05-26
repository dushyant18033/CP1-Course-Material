n=int(input())
a=list(map(int,input().split()))

ctr=0
maxSoFar=-1
for i in a:
    if(i>maxSoFar):
        maxSoFar=i
        ctr+=1
print(ctr)
