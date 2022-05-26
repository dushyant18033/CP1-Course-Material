import math 


  
def DigCtr(n): 
    return math.floor(math.log(n, 10)+1)


t=int(input())


for i in range(t):
    n=int(input())
    digs=DigCtr(n)
    start=10**(digs)
    cur=(start//10)-1
    start+=9
    while(cur!=n):
        s=sum(map(int,list(str(start))))
        if(s%10==0):
            cur+=1
        start+=1
    print(start-1)
        
