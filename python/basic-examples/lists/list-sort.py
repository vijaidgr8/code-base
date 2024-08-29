list1 = [5,6,4,8,1]
for i in range(len(list1)):
    if list1[i] > list1[i-1]:
        list1[i],list1[i-1]=list1[i-1],list1[i]
print (list1)
print (sorted(list1))