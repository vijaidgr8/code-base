list1 = [3,1,6,5,9]
least_num = None

for i in range(0,len(list1)-1):
    for j in range(0,len(list1)-1):
        if list1[j] > list1[j+1]:
            list1[j],list1[j+1] = list1[j+1],list1[j]
        elif list1[j] < list1[j+1]:
            continue
least_num = list1[0]
list1.remove(least_num)
list1.append(least_num)
print(list1)