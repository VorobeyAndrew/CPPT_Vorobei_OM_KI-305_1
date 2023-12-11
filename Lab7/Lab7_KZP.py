import os
import struct

size = int(input("Введіть розмір: "))
symbol = input("Введіть символ: ")



zubchatiy_masiv = []

for i in range(size):
    zubchatiy_masiv.append([' '] * (i + 1))
    for j in range(i + 1):
        if i < size // 2:
            zubchatiy_masiv[i][j] = symbol
        else:
            if j < size // 2:
                zubchatiy_masiv[i][j] = ' '
            else:
                zubchatiy_masiv[i][j] = symbol

# Друк зубчатого масиву
for row in zubchatiy_masiv:
    print(' '.join(row))

