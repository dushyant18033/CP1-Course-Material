s=input()
n=len(s)

locations=[0]
ctr=0

for i in range(n-1):
    if(s[i]!=s[i+1]):
        ctr+=1
    locations.append(ctr)

"""
n1=len(locations)

q=int(input())

for i in range(q):
    l,r=map(int,input().split())
    l-=1
    r-=1
    j=0
    while(j<n1 and locations[j]<l):
        j+=1

    ctr=j

    while(j<n1 and locations[j]<r):
        j+=1

    print(j-ctr)
"""
q=int(input())

for i in range(q):
    l,r=map(int,input().split())
    print(locations[r-1]-locations[l-1])
