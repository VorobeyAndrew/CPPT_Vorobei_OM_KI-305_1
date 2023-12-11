import math
import struct
import os

def cotangent(x):
    return 1 / math.tan(x)

def calculate_and_save_result(output_text_filename, output_binary_filename, input_data):
    # Обчислення результату
    result = cotangent(input_data)

    print(f"Результат: {result}")

    # Запис результату у текстовий файл
    with open(output_text_filename, 'w') as file:
        file.write(str(result))

    # Запис результату у двійковий файл
    with open(output_binary_filename, 'wb') as file:
        file.write(struct.pack('d', result))  # Використовуємо 'd' для подвійного упаковування

# Перевірка існування файлу та обчислення та збереження результату
output_text_filename = 'output_text.txt'
output_binary_filename = 'output_binary.bin'

# Зчитування початкових даних з окремих змінних
input_data = 45
if not os.path.exists(output_text_filename):
    calculate_and_save_result(output_text_filename, output_binary_filename, input_data)

# Виведення результатів
with open(output_text_filename, 'r') as file:
    print(f"Зчитані дані з текстового файлу: {file.read()}")

with open(output_binary_filename, 'rb') as file:
    binary_data = file.read()
    unpacked_data = struct.unpack('d', binary_data)
    print(f"Зчитані дані з двійкового файлу: {unpacked_data[0]}")