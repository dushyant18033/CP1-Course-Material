t=int(input())

for test in range(t):
    n=int(input())
    S=input()
    U=input()
    score=0
    i=0
    while(i<n):
        if(i==n-1):
            if(U[i]==S[i]):
                score+=1
                i+=1
            else:
                i+=1
        elif(U[i]=='N'):
            i+=1
            continue
        else:
            if(U[i]==S[i]):
                score+=1
                i+=1
            else:
                i+=2
    print(score)
