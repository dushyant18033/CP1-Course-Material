a,b,x,y=map(int,input().split())

def gcd(a,b):
    if(a==0):
        return b
    if(b==0):
        return a
    return gcd(b%a,a)

inc=(a*b)//gcd(a,b)

i=(x//inc)
j=(y//inc)

ctr=j-i+1
if(y%inc>0):
    ctr-=1

print(ctr)
