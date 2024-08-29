word1 = 'Vijai'
result = ""
for item in word1:
    if item != "i":
        result += item
for item in word1:
    if item == "i":
        result += item
        
print(result)