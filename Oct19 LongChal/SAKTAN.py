t=int(input())

for tes in range(t):
    n,m,q=map(int,input().split())


    isOdd=list()
    for i in range(n):
        isOdd.append([0]*m)

    ctr=0
    
    for i in range(q):
        x,y=map(int,input().split())
        x-=1
        y-=1
        for j in range(m):
            if(isOdd[x][j]==0):
                ctr+=1
                isOdd[x][j]=1
            else:
                ctr-=1
                isOdd[x][j]=0
        for j in range(n):
            if(isOdd[j][y]==0):
                ctr+=1
                isOdd[j][y]=1
            else:
                ctr-=1
                isOdd[j][y]=0
        
    print(ctr)


"""
    ctr=[0]*m
    
    mat=list()
    for i in range(n):
        mat.append([0]*m)

    for i in range(q):
        x,y=map(int,input().split())
        x-=1
        y-=1
        
        for a in range(m):
            mat[x][a]+=1
            if(mat[x][a]%2!=0):
                ctr[a]+=1
            else:
                ctr[a]-=1
                
        for a in range(n):
            mat[a][y]+=1
        ctr[y]=n-ctr[y]
        

    #print(row)
    #print(col)
    print(sum(ctr))
    

    oddRow=[0]*(n)
    oddCol=[0]*(m)
"""
