t=int(input())

for i in range(t):
    n,m=map(int,input().split())

    chance=True #Aris chance

    while(n>0 and m>0):
        if(n==m):
            break
        elif(n>m):
            if(n//m == 1):
                n=n%m
            else:
                break
        else:
            if(m//n == 1):
                m=m%n
            else:
                break
        chance=not chance

    if(chance):
        print("Ari")
    else:
        print("Rich")
        
