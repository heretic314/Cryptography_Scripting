#Ceasar cipher implementation
lowerCaseLetters = 'abcdefghijklmnopqrstuvwxyz'
upperCaseLetters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
 
def Encrypt(rawMessage, shift):
    data = []
    for i in rawMessage:                     
        if i.strip() and i in lowerCaseLetters:                  
            data.append(lowerCaseLetters[(lowerCaseLetters.index(i) + shift) % 26])    
        elif i.strip() and i in upperCaseLetters:                  
            data.append(upperCaseLetters[(upperCaseLetters.index(i) + shift) % 26])
        else:
            data.append(i)           
    output = ''.join(data)
    return output



def Decrypt(Message, shift):
    shift = -(shift)
    data = []
    for i in Message:                     
        if i.strip() and i in lowerCaseLetters:                  
            data.append(lowerCaseLetters[(lowerCaseLetters.index(i) + shift) % 26])    
        elif i.strip() and i in upperCaseLetters:                  
            data.append(upperCaseLetters[(upperCaseLetters.index(i) + shift) % 26])
        else:
            data.append(i)           
    output = ''.join(data)
    return output


shiftNum=1
while shiftNum != 0:
    shiftNum = int(input('Shift by #: '))
    UnsecuredMessage = input('Input text here: ')
    securedMessage=Encrypt(UnsecuredMessage, shiftNum)
    print("\nciphertext: " + securedMessage + "\n\n")



# print("\nplaintext: " + Decrypt(securedMessage,shiftNum))
