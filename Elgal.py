import random

#p = int(input("p: "))
#g = int (input ("generator g: "))
#a = int(input("a: "))
#b = int(input("b: "))
#ka = int(input ("A's private key ka: "))
p = 746959
g = 3
a =16
b = 256
ka =18
m = int(input("Input Message m: "))

Pb = (g**b % p)
print("Bob's public key: g^b mod Pb: ", str(Pb))
print()
print("Alice: ")
#print("Mask = [Pb]^k mod p")
M = pow(Pb,ka,p)
if M == 1 % p:
    ka = random.randint(1, p - 1)
    ka = 18
    print("Bad Choice of A's Private key. since M = 1modp")
    print("New private key for A(radomly selected): ", Pb)
    M = Pb**ka % p
print("Mask = [Pb]^ka mod p = "+str(M))
C = (m*M) % p
print("CT: (mM)mod p = "+ str(C))
H = pow(g,ka,p)
print("Hint: (g^ka)modp = "+ str(H))

print()
print("Alice sends to Bob: [CT,Hint] = ["+str(C)+","+str(H)+"]")

print("Bob")
q = (p-1)-b
print("q = p-1-b = "+ str(q))
R = pow(H,q,p)
print("Reopener: H^q mod p ="+(str(R)))
D = (C*R) % p
print("Decryption: (CR)modp = "+str(D))