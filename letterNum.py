#Ceasar cipher implementation
lowerCaseLetters = 'abcdefghijklmnopqrstuvwxyz'
upperCaseLetters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'

def numVal(letter):
    if letter in lowerCaseLetters:
        return lowerCaseLetters.find(letter)
    if letter in upperCaseLetters:
        return upperCaseLetters.find(letter)
    else:
        return 0
    

userInput = ""
print("Enter letter to return the # or type \"quit\" at any time")

while userInput != "quit":
    userInput = input("Letter: ")
    if len(userInput) != 1 or not(userInput.isalpha()):
        print("just a letter please")
        continue
    returnNum = numVal(userInput)
    print(userInput + " = " + str(returnNum))
    #EOF
