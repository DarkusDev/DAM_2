###
# 01 - Functions
# Permiten la reutilización del código
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

#Escribir una función que muestre por pantalla el 
#saludo ¡Hola profe! cada vez que se la invoque.

def saludo_profe():
    print("Hola profe!")

saludo_profe()



#Escribir una función a la que se le pase una cadena <nombre> 
#y muestre por pantalla el saludo ¡hola <nombre>!.

def saludo_nombre(nombre):
    print("Hola ", nombre)

saludo_nombre("Darius")




#Escribir una función que reciba un número entero positivo y devuelva su factorial.

def num_factorial(num):
   return math.factorial(num)

num_factorial(6)



#Escribir una función que calcule el total de una factura tras aplicarle el IVA. 
#La función debe recibir la cantidad sin IVA y el porcentaje de IVA a aplicar, 
#y devolver el total de la factura. Si se invoca la función sin pasarle 
# el porcentaje de IVA, deberá aplicar un 21%.

def factura_iva(total, iva = 21):

    resultado = total + (total * (iva / 100))
    return resultado


#Escribir una función que calcule el área de un círculo 
#y otra que calcule el volumen de un cilindro usando la primera función.

def area_circulo(radio):
    return 3.14 * radio ** 2

def volumen_cilindro(area, altura):
    return area * altura

volumen_cilindro(area_circulo(3), 5)



#Escribir una función que reciba una muestra de números en una lista y 
#devuelva otra lista con sus cuadrados.


