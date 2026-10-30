def numEntero():
    num = 0
    while num <= 0:
        try:
            num = int(input("Introduce un numero entero positivo: "))
        except KeyboardInterrupt:
            print("Adios!")
            break

    for numero in range(0, num):
        print(numero)

numEntero()
    
    