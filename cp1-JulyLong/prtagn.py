t=int(input())


    
for test in range(t):
    q=int(input())
    s=set()
    Even=0
    Odd=0
    for i in range(q):
        x=int(input())
        xHasEven1s=bin(x).count('1')%2==0

        if(x in s):
            print(Even,Odd)
        else:
            s1=list(s)
            for i in s1:
                s.add(x^i)

            if(xHasEven1s):
                Even=2*Even+1
                Odd*=2
            else:
                Even+=Odd
                Odd=Even+1
            
            s.add(x)
            print(Even,Odd)
