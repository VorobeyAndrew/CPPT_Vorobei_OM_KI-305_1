size = int(input("Введіть розмір: "))
symbol = input("Введіть символ: ")
probil = " "

zubchatiy_masiv = [[' ' for _ in range(i + 1)] for i in range(size)]

for i in range(size):
    for j in range(i + 1):
        if i < size // 2:
            zubchatiy_masiv[i][j] = symbol
        elif i >= size // 2:
            if j < size // 2:
                zubchatiy_masiv[i][j] = probil
            else:
                zubchatiy_masiv[i][j] = symbol

# Виведення результату
for row in zubchatiy_masiv:
    print(' '.join(row))