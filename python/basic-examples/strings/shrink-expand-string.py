shrinkstring = "bbacaadd"
count = 0
shrinkedstring = ""
expandstring = "a3b4d9"
uniquestrings = ""
expandedstrings = ""

for i in range(len(shrinkstring)):
    if shrinkstring[i] not in uniquestrings:
        uniquestrings += shrinkstring[i]

for i in range(len(uniquestrings)):
    count = 0
    shrinkedstring += uniquestrings[i]
    for j in range(len(shrinkstring)):
        if uniquestrings[i] == shrinkstring[j]:
            count += 1
    shrinkedstring += str(count)

print (f"Shrinked String would be : {shrinkedstring}")

for k in range(len(expandstring)-1):
    if expandstring[k+1].isdigit():
        expandedstrings += expandstring[k] * int(expandstring[k+1])

print (f"Expanded strings would be : {expandedstrings}")

