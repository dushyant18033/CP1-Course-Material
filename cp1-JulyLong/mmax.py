t=int(input())

for test in range(t):
    n=int(input())
    k=int(input())
    c=k//n
    a=[c]*n#list
    k-=(n*c)
    for i in range(k):
        a[i]+=1
    b1=list()
    i=0
    j=n-1
    back=True
    while(i<=j):
        if(back):
            b1.append(a[j])
            j-=1
            back=False
        else:
            b1.append(a[i])
            i+=1
            back=True
    b2=list()
    i=0
    j=n-1
    back=False
    while(i<=j):
        if(back):
            b2.append(a[j])
            j-=1
            back=False
        else:
            b2.append(a[i])
            i+=1
            back=True
    s21=0
    s22=0
    for i in range(n-1):
        s21+=abs(b1[i+1]-b1[i])
        s22+=abs(b2[i+1]-b2[i])
    s2=max(s21,s22)
    print(s2)
    
