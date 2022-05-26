t=int(input())

def expo(n):
    if(n==0):
        return 1
    if(n==1):
        return 2

    abc=expo(n//2)
    if(n%2==0):
        return ((abc%1000000007)*(abc%1000000007))%1000000007
    else:
        return (2*((abc%1000000007)*(abc%1000000007)%1000000007))%1000000007

for i in range(t):
    k=int(input())
    print((5*expo(k))%1000000007)
