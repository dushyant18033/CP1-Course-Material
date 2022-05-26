def check(n, L):
    a=list()
    for i in range(len(L)):
        for j in range(i+1,len(L)):
            a=L[i:j+1]
            if sum(a)==n:
                return a
    return -1
