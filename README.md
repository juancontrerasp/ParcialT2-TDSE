# ParcialT2-TDSE Math and Proxy servers

---

## Juan Pablo Contreras Parra

---

### Video 

https://www.youtube.com/watch?v=iz-defNg9qA

---

This repository contains a mathematical service includes the funcion for fibonnaci calculation with Window K = 3
Example:

Fibonacci: F_0=0, F_1=1, F_n=F_{n-1}+F_{n-2} para n ≥ 2.
Ventana K=3: para la lista [a0, a1, …, am], la suma móvil es [a0+a1+a2, a1+a2+a3, …].

This repository also contains a proxy service that chooses between two mathematical services for the endpoint calculation, in case one fails.

## Running project

First we clone the repository:

``
git clone https://github.com/juancontrerasp/ParcialT2-TDSE
``

In both MathService folder and ProxyService folder:

``
mvn clean compile
``

``
chmox +x mvnw
``

``
./mvnw spring-boot:run
``

And that's it, both will be running and the proxy will choose whatever math service is available

## How it works

The class ProxyController receives the first input and it tries to use one of the Math services, the MathController simply calculates the fibonacci sequence using Recurrence and adds all the digits into a simple list.

## Local testing

- Test with n = 10:

    http://localhost:8081/fibwin?n=10

    ![img.png](images%2Fimg.png)
- Test with n = 30:

    http://localhost:8081/fibwin?n=30
    ![img_1.png](images%2Fimg_1.png)


## Instances deployment and AWS testing

- Running instances
  ![img_4.png](images%2Fimg_4.png)


  - Math service 1
  ![img_5.png](images%2Fimg_5.png)

    ![img_2.png](images%2Fimg_2.png)
  

- Math service 2
  ![img_6.png](images%2Fimg_6.png)
  ![img_3.png](images%2Fimg_3.png)
  

- Proxy Service
 
  ![imagee.png](images%2Fimagee.png)
  ![imagee2.png](images%2Fimagee2.png)

## Video proof

In the video we can check that the service runs when one of the math services is up, since the proxy server chooses whatever server is working, it works if only one is up.

https://www.youtube.com/watch?v=iz-defNg9qA







