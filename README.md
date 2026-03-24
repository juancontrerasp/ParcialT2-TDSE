# ParcialT2-TDSE Math and Proxy servers

---

## Juan Pablo Contreras Parra

---

This repository contains a mathematical service includes the funcion for fibonnaci calculation with Window K = 3
Example:

Fibonacci: F_0=0, F_1=1, F_n=F_{n-1}+F_{n-2} para n ≥ 2.
Ventana K=3: para la lista [a0, a1, …, am], la suma móvil es [a0+a1+a2, a1+a2+a3, …].

This repository also contains a proxy service that chooses between two mathematical services for the endpoint calculation, in case one fails.

## Running project

In both MathService folder and ProxyService folder:

``
./mvnw spring-boot:run
``

## Local testing

- Test with n = 10:

    http://localhost:8081/fibwin?n=10

    ![img.png](images%2Fimg.png)
- Test with n = 30:

    http://localhost:8081/fibwin?n=30
    ![img_1.png](images%2Fimg_1.png)


## 

