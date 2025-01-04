#!/usr/bin/env python3.8
#- -* coding: utf-8 - *-

"""
VIGENERE CIPHER

Plaintext: 	    ATTACKATDAWN
Key: 	        LEMONLEMONLE
Ciphertext: 	LXFOPVEFRNHR

Encription: Ci = Ek(Mi) = (Mi + Ki) mod 26
Decription: Mi = Dk(Ci) = (Ci - Ki) mod 26

M -> message
C -> ciphertext
K -> key
"""

TEXT = list(input("Plain (upper case text): "))
KEY = list(input("Encryption (keyword): "))

if len(TEXT) != len(KEY):
    for X in range(0, len(TEXT) - len(KEY)):
        KEY.append(KEY[X % len(KEY)])
        
CODE = ""

for X in range(0, len(TEXT)):
    if TEXT[X].islower():
        CODE += chr((((ord(TEXT[X]) - 97) + ord(KEY[X]) - 97) % 26) + 97)
    else:
        CODE += chr((((ord(TEXT[X]) - 65) + ord(KEY[X]) - 65) % 26) + 65)
print(CODE)

KEY = list(input("Decryption (key): "))

DECODE = ""

if len(TEXT) != len(KEY):
    for X in range(0, len(TEXT) - len(KEY)):
        KEY.append(KEY[X % len(KEY)])

for X in range(0, len(CODE)):
    if TEXT[X].islower():
        DECODE += chr((((ord(CODE[X]) - 97) - ord(KEY[X]) - 97) % 26) + 97)
    else:
        DECODE += chr((((ord(CODE[X]) - 65) - ord(KEY[X]) - 65) % 26) + 65)
print(DECODE)
