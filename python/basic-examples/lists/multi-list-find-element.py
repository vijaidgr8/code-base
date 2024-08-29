a = [1,3,5,"Vijai",9]
b = [1,"Vijai",3,"Hai",5]
c = []

for itema in a:
    for itemb in b:
        if itema == itemb:
            c.append(itema)

print(c)

