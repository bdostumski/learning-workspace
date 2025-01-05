#!/usr/bin/env python3.8
#- -* coding: utf-8 - *- 

"""
CAESAR CIPHER

Plain:    ABCDEFGHIJKLMNOPQRSTUVWXYZ
Cipher:   XYZABCDEFGHIJKLMNOPQRSTUVW

Encryption En(x) = (x + n) mod 26
Decription Dn(x) = (x - n) mod 26
"""

TEXT = input("Enter (text): ")

while True:
    KEY = int(input("Encryption key (between 1 and 25): "))
    if (KEY >= 1) and (KEY <= 25):
        break
    else:
        print("Invalid value")

CODE = ""

for X in range(0, len(TEXT)):
    if TEXT[X].islower():
        CODE += chr((((ord(TEXT[X]) - 97) + KEY) % 26) + 97)
    else:
        CODE += chr((((ord(TEXT[X]) - 65) + KEY) % 26) + 65)

print(CODE)

while True:
    KEY = int(input("Decryption key (between 1 and 25): "))
    if(KEY >= 1) and (KEY <= 25):
        break
    else:
        print("Invalid value")
    
DECODE = ""

for X in range(0, len(CODE)):
    if TEXT[X].islower():
        DECODE += chr((((ord(CODE[X]) - 97) - KEY) % 26) + 97)
    else:
        DECODE += chr((((ord(CODE[X]) - 65) - KEY) % 26) + 65)

print(DECODE)
