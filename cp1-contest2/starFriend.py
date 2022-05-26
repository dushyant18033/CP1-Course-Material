n=int(input())
nums=list(map(int,input().split()))

def answer(nums,n):
    if(len(nums)==1):
        return 0
    
    maxPair=-1
    ind=[]
    for j in range(len(nums)-1):
        sum1=nums[j]+nums[j+1]
        if(sum1>maxPair):
            ind=[j]
            maxPair=sum1
        elif(sum1==maxPair):
            ind.append(j)
    #print(maxPair,nums)

    answers=list()
    for i in ind:
        answeri=answer(nums[:i]+[maxPair]+nums[i+2:],n-1)
        answers.append(answeri)

    return maxPair+max(answers)


print(answer(nums,n))
