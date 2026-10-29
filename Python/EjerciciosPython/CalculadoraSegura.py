

def calculadora():
    entrada = ""
    while entrada.lower != "salir":
        
        try:
            entrada = input("Introduce el primer numero: ")
            num1 = int(entrada)
    
            entrada = input("Introduce el segundo numero: ")
            num2 = int(entrada)
    
            entrada = input("Introduce la operacion a realizar: (+,-,*,/) ")
            operacion = str(entrada)
            match operacion:
                    case "+":
                        print("La suma de los numeros es: ", num1 + num2)
                    case "-":
                        print("La resta de los numeros es: ", num1 - num2)
                    case "*":
                        print("La multiplicacion de los numeros es: ", num1 * num2)
                    case "/":
                        print("La division de los numeros es: ", num1 / num2)
        except ZeroDivisionError:
            print("No se puede dividir entre 0")
        except Exception:
            if entrada.lower() != "salir":
                calculadora()
            else:
                print("Has salido del programa")
                break



calculadora()
   
        
