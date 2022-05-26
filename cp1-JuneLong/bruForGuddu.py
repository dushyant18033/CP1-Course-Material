n=int(input())

ctr=0
prev=0

for i in range(19,1000*n):
    s=sum(map(int,list(str(i))))
    if(s%10==0):
        #if((i-prev)!=9):
        #    print(str(prev)+" "+str(i)+" ",i-prev)
        print(i,end=' ')
        prev=i
        ctr+=1
    if(ctr==n):
        break

print("\n",ctr)
