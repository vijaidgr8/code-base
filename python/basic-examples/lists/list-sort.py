list1 = [5,6,4,8,1]
for i in range(0,len(list1)-1):
    for j in range(0,len(list1)-1):
        if list1[j] > list1[j+1]:
            list1[j],list1[j+1] = list1[j+1],list1[j]
        elif list1[j] < list1[j+1]:
            continue

print (f"Sorted Using Logic\n{list1}")
# Simplest way 
print (f"Simple Sort Using Function \n{sorted(list1)}")
