n=int(input("Enter an integer p: "))
modulus = n
x = n-1
Array = []

#n =x
print("Factors of p-1 = " +str(n)+ " is/are:")
i=1
while(i<=n):
    k=0
    if(n%i==0):
        j=1
        while(j<=i):
            if(i%j==0):
                k=k+1
            j=j+1
        if(k==2):
            print(i)
            Array.append(i)
    i=i+1


print("-----------------------------")

randomPrime = [2,3,4,5,7,11,13,17,19,23,29,31,37,41,43,47]

for prime in randomPrime:
    equal1 = 0
    for item in Array:
        power = int(x/item)
        if (prime ** power) % modulus == 1:
            equal1 = equal1 + 1
    if equal1 == 0:
        print(str(prime) + " is a generator")
    exit