t=int(input())

L=[0,1,3,7,12,20,30,44,65,80,96]

for i in range(t):
    n=int(input())

    s='.'*n

    k=0

    ctr=0
    for j in range(n):
        if j in L:
            s='o'+s[:-1]
            k+=1
        else:
            s='.'+s[:-1]
        print(s)
        
        ctr+=s.count('o')
    print(ctr)
