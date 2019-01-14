sq = 0 #Always stays the same

# Enter all these values by yourself
p = int(input("p: "))
m = int(input("m: "))
u = int(input("u: "))
b = 0
A = 1
power=1
A_PlaceHolder = 1
A_Value=1

print("m: " + str(m), end=" | ")
print("b: " + str(b), end=" | ")
print("u: " + str(u), end=" | ")
print("squaring: " + str(sq), end=" | ")
print("A: " + str(A), end=" | ")
if b == 1:
    print("comment: " + "multiply")
else:
    print("comment: " + "skip")
print("------------------------------------------------------------------")

while m != 1:
    power = power * 2
    action = ""
    m = (m - b) / 2
    b = m % 2
    uVal = (u ** power) % p
    sq = sq + 1
    A_PlaceHolder = u ** power
    if b == 1:
        A = A_PlaceHolder * A
    A_Value = A % p



    print("m: " + str(m), end=" | ")
    print("b: " + str(b), end=" | ")
    print("u: " + str(uVal), end=" | ")
    print("squaring: " + str(sq), end=" | ")
    print("A: " + str(A_Value), end=" | ")
    if b == 1:
        print("comment: " + "multiply")
    else:
        print("comment: " + "skip")
    print("------------------------------------------------------------------")


input("Press enter to exit:")
199
