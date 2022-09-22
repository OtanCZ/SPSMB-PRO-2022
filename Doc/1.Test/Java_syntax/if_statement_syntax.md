# Podmínky if, else if, else

1) Do  ```if()  ``` zapisujeme vždy nějakou podmínku např. x > 0, když je pravdivá tak se provede kód v podmínce
2) Do ``` if else () ``` zapisujeme stejně jako do  ```if() ``` podmínku
3) Když není ani jedna podmínka pravdivá, tak program přejde do  ```else  ``` a nebude se ptát znovu

```java
int x = 1;
int y = 5;

if(x > y){
   System.out.println("X je větší");
  }else if(x < y){
   System.out.println("Y je větší");
  }else{
   System.out.println("Obě čísla jsou stejná");
  }
}
 ```

