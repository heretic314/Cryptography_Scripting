sq = 0 #Always stays the same

# Enter all these values by yourself
p = int(input("p: "))
m = int(input("m: "))
u = int(input("u: "))
power = 1
A = 1
mulCount = 0
uCalc = 0
b = m%2
if(b==1):
    uCalc = u
print("m: " + str(m), end=" | ")
print("b: " + str(b), end=" | ")
print("u: " + str(u), end=" | ")
print("squaring: " + str(sq), end=" | ")
print("A: " + str(A), end=" | ")

if b == 1:
    print("comment: " + "multiply")
    mulCount=mulCount+1
else:
    print("comment: " + "skip")
print("------------------------------------------------------------------")

while m != 1:
    power = power * 2
    action = ""
    m = (m - b) / 2
    b = m % 2
    if(m>0):
        u = (u * u) % p
    else:
        u = A

    sq = sq + 1

    if b==1:
        A = (A * u) % p
    else:
        A = A

    print("m: " + str(m), end=" | ")
    print("b: " + str(b), end=" | ")
    print("u: " + str(u), end=" | ")
    print("squaring: " + str(sq), end=" | ")
    print("A: " + str(A), end=" | ")
    if b == 1:
        print("comment: " + "multiply", end=" | ")
        if(uCalc == 0):
            uCalc = u
        else:
            print(str(uCalc) + " * " + str(u) + " mod " + str(p), end=" ")
            uCalc = (uCalc * u) % p
            print(" = " + str(uCalc))

        mulCount = mulCount+1
    else:
        print("comment: " + "skip it")
    print("------------------------------------------------------------------")

print()
print("Minimum number of multiplication = ",mulCount)
print("Number of Squarings = ",sq)
