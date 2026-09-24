###
# exercises.py
# Ejercicios para practicar los conceptos aprendidos en las lecciones.
###

import os
import subprocess

# Comprobamos el tipo de sistema operativo
if os.name == "nt":
    # Si el sistema es Windows, usamos el comando 'cls'
    comando = "cls"
else:
    # Si es cualquier otro sistema (Mac o Linux), usamos 'clear'
    comando = "clear"

# Ejecuta el comando seleccionado en la terminal
subprocess.run(comando, shell=True)

print("\nEjercicio 1: Imprimir mensajes")
print("Escribe un programa que imprima tu nombre y tu ciudad en líneas separadas.")

print("Hola me llamo Darius", end= "\n")
print("Vivo en Alcala de Henares")

print("--------------")

print("\nEjercicio 2: Muestra los tipos de datos de las siguientes variables:")
print("Usa el comando 'type()' para determinar el tipo de datos de cada variable.")
a = 15
b = 3.14159
c = "Hola mundo"
d = True
e = None

print("La variable a es:", type(a))
print("La variable a es:", type(b))
print("La variable c es:", type(c))
print("La variable d es:", type(d))
print("La variable e es:", type(e))

print("--------------")

print("\nEjercicio 3: Casting de tipos")
print("Convierte la cadena \"12345\" a un entero y luego a un float.")
print("Convierte el float 3.99 a un entero. ¿Qué ocurre?")

cadena = 12345
enteroCadena = int(cadena)
floatCadena = float(cadena)
f = 3.99

enteroFloat = int(f)

print(enteroCadena)
print(floatCadena)
print(enteroFloat)

print("--------------")

print("\nEjercicio 4: Variables")
print("Crea variables para tu nombre, edad y altura.")
print("Usa f-strings para imprimir una presentación.")

# "Hola! Me llamo midudev y tengo 39 años, mido 1.70 metros"

nombre = "Darius"
edad = 19
altura = 1.75

print(f"Hola! Me llamo {nombre} y tengo {edad}, mido {altura}")

print("--------------")

print("\nEjercicio 5: Números")
print("1. Crea una variable con el número PI (sin asignar una variable)")
print("2. Redondea el número con round()")
print("3. Haz la división entera entre el número que te salió y el número 2")
print("4. El resultado debería ser 1")

resultado = int(round(3.1416) / 2)
print(3.1416)
print("PI redondeado: ", round(3.1416))
print(resultado)   