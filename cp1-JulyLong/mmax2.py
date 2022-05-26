t=int(input())

for test in range(t):
    n=int(input())
    k=int(input())
    More=k%n
    Less=n-More
    if(More==Less):
        print(n-1)
    elif(More<Less):
        print(2*More)
    else:
        print(2*Less)
