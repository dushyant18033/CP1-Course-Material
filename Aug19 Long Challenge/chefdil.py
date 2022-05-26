t=int(input())
nums=list()
for test in range(t):
    nums=input()
    xor=0
    for i in nums:
        if i=='1':
            xor+=1
            
    if(xor%2==0):
        print("LOSE")
    else:
        print("WIN")
