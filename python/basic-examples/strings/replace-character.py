word1 = "Vijai"
result = ""
i = 0
while (i < len(word1)):
    if (word1[i] == "i"): 
        result += "a"
    else:
        result += word1[i]
    i += 1

print(f"Output Using Logic {result}")
print(f"Output using function {word1.replace('i',"a")}")