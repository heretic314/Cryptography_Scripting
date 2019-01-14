import random

#gcd function
def gcd(x, y):
    while y != 0:
        (x, y) = (y, x % y)
    return x


# calculating modular inverse
def egcd(a, b):
    if a == 0:
        return b, 0, 1
    else:
        g, y, x = egcd(b % a, a)
        return g, x - (b // a) * y, y

def modinv(a, m):
    g, x, y = egcd(a, m)
    if g != 1:
        raise Exception('modular inverse does not exist')
    else:
        return x % m

p = int(input("p: "))
q = int(input("q: "))
m = p*q
phim = (p-1)*(q-1)

r = int(input("r: "))
s = int(input("s: "))
n = r*s
phin = (r-1)*(s-1)

print()
print("Sender's process: ")
print("m = "+str(m))
print("phim = "+str(phim))
e = int(input("To calculate value of e, run the prime-factors program to input the value for e: "))
if gcd(e,phim) != 1:
    print("invalid e")
d = modinv(e, phim)
print("d such that d*e = 1 mod phim = "+str(d))

print()
print("Reciever's process")
print ("n= "+str(n))
print("phin = "+str(phin))
h = int(input("To calculate value of h,input phi(n) run the prime-factors program to input the value for h: "))
if gcd(h, phin) != 1:
    print("invalid h")
g = modinv(h, phin)
print("g such that g*h = 1 mod phin = "+str(g))
print()
print("Sender's action")
a = int(input("message a: "))
x=pow(a,d,m)
print("Signature: x = a^d mod m = "+str(x))
y=pow(x,h,n)
print ("Encrypt: y = x^h mod n = "+str(y))

print()
print("Receiver's action")
z=pow(y,g,n)
print("Decrypt: z = y^g mod n = "+str(z))
u=pow(z,e,m)
print ("Sig Verification: u = z^e mod m = "+str(u))

if(a == u):
    print("RSA Signature Verified a=u => Solution Accepted!")
