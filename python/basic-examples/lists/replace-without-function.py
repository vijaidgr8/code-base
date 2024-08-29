if _name_ == "_main_":
    word1 = "a"
    word2 = "def"
    result = ""
    pointer= ""
    for i in range(min(len(word1),len(word2))):
        result += word1[i]
        result += word2[i]
        pointer = i
    if len(word1) > len(word2):
        result += word1[pointer+1:]
    elif len(word2) > len(word1):
        result += word2[pointer+1:]
        
    print(result)