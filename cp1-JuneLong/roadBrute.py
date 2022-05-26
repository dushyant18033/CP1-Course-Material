k=int(input())

a=10**k

ctr=0

for i in range(a//2):
    num1=str(i)
    num2=str(a-i-1)
    if(len(set(num1+num2))==2):
        ctr+=1
        print(i,a-i-1)

print(2*ctr)
