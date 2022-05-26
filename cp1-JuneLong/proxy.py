t=int(input())

for i in range(t):
    D=int(input())
    S=input()
    #S1=S[:]
    cur=S.count('P')
    
    if((cur/D)>=0.75):
        print(0)
    elif(1<=D<=3):
        if(S.count('A')==0):
            print(0)
        else:
            print(-1)
    elif(D==4):
        if(S.count('A')<=1):
            print(0)
        else:
            print(-1)
    else:
        i=2
        ctr=0
        while(i<=(D-3) and (cur/D)<0.75):
            if(S[i]=='A'):
                left = S[i-2] + S[i-1]
                right = S[i+1] + S[i+2]

                if('P' in left and 'P' in right):
                    #S1+='P'
                    cur+=1
                    ctr+=1

            i+=1
            
        if((cur/D)>=0.75):
            print(ctr)
        else:
            print(-1)
