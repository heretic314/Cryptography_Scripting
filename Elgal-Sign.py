M = int(input("M: "))
p = int(input("p: "))
g = int(input("g: "))
r = int(input("r: "))

K = pow(g,r,p)
print("K= " + str(K))

#gcd function
def gcd(x, y):
    while y != 0:
        (x, y) = (y, x % y)
    return x
#enter R
R = int(input("R: "))

if gcd(R, p-1) != 1:
    print("invalid R")

X = pow(g,R,p)
print("X= " + str(X))

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


Rinv = modinv(R, (p-1))
inside = M-(r*X)
if inside <0:
    inside = inside+(p-1)
    print("(M-rX)mod p= " + str(inside))
Y = ((M-(r*X))*Rinv)%(p-1)
print("Y= " + str(Y))

print("verification")
A = (pow(K,X)*pow(X,Y))%p
print("A= " + str(A))

print("g^M mod p = " + str(pow(g,M,p)))
if pow(g,M,p) == A:
    print("accepted")
else:
    print("rejected")