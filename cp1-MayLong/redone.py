n=int(input())

L=list()
for i in range(n):
    L.append(i+1)

final=list()

def func(a):
    if(len(a)==1):
        final.append(a[0])
    else:
        for x in range(len(a)):
            for y in range(x+1,len(a)):
                a1=a[:]
                k=a[x]+a[y]+a[x]*a[y]
                a1.remove(a[x])
                a1.remove(a[y])
                a1.append(k)
                func(a1)

func(L)
print(max(final))
print(final.count(max(final)))
print(len(final))
