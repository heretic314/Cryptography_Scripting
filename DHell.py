import random

p = int(input("p: "))
g = int (input ("generator g: "))

a = random.randint(1, p-1)
a =256
b = random.randint(1, p -1)
b = 4096

if(a == b):
    print("a: ", a)
    print("b: ", b)
    print("Random values suck! Looks like they are same. please run again")
    quit()

print("a: ", a)
A = g**a % p
print("A = (" +str(g) +" pow "+str(a) + ") mod "+str(p)+ " = " +str(A))
print("Value Alice sends to Bob: ", A)

print()
print("b: ", b)
B = g**b % p
print("B = (" +str(g) +" pow "+str(b) + ") mod "+str(p)+ " = " +str(B))
print("Value Bob sends to Alice: ", B)

print()
print("Alice's internal calculation:")
Ka = B**a % p
print("Ka = (" +str(B) +" pow "+str(a) + ") mod "+str(p)+ " = " +str(Ka))
print("Secret key for Alice: "+str(Ka))

print()
print("Bob's internal calculation:")
Kb = A**b % p
print("Ka = (" +str(A) +" pow "+str(b) + ") mod "+str(p)+ " = " +str(Kb))
print("Secret key of Bob: "+str(Kb))

print()
if(Ka == Kb):
    print("Deffie Helman Verified")
else:
    print("Run again, check the val of generator")