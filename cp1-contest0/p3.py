num=input()
n=len(num)

maxSum=-1

for i in range(1,n-1):
    for j in range(i+1,n):
        s1=num[:i]
        s2=num[i:j]
        s3=num[j:]
        if( (len(s1)>1 and s1[0]=='0') or (len(s2)>1 and s2[0]=='0') or (len(s3)>1 and s3[0]=='0')):
            continue
        n1=int(s1)
        n2=int(s2)
        n3=int(s3)
        if(n1>1000000 or n2>1000000 or n3>1000000):
            continue

        k=n1+n2+n3
        if(k>maxSum):
            maxSum=k

print(maxSum)
