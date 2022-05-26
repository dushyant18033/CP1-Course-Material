s1=input().strip()
s2=input().strip()
s3=input().strip()

c1=0
c2=0
c3=0

for i in s1:
    if i in 'aeiou':
        c1+=1

for i in s2:
    if i in 'aeiou':
        c2+=1

for i in s3:
    if i in 'aeiou':
        c3+=1

if(c1==5 and c2==7 and c3==5):
    print("YES")
else:
    print("NO")
