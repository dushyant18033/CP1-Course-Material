n=int(input())
a=list(map(int,input().split()))

half=sum(a)/2

a.sort(reverse=True)

ctr=0
s=0
c=0
while(s<=half):
    s+=a[c]
    c+=1
    ctr+=1

print(ctr)
