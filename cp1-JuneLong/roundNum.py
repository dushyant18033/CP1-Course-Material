t=int(input())

for test in range(t):
    n=int(input())
    n1=n
    digSum=0
    while(n1>0):
        digSum+=n1%10
        n1//=10

    num=10*n + (10 - digSum%10)%10
    print(num)
