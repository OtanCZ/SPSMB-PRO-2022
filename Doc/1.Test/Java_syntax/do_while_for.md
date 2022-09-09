# Cyklus for

```java 
for (int i = 0; i < 5; i++) {
  System.out.println(i);
}

for (int i=0; i<N; i++ ) { // inicializátor; podmínka; inkrement
  // tělo cyklu
}
```

1) V prvé řadě si definujeme proměnnou i
2) V druhé řadě začneme porovnávat naši danou proměnnou číslem nebo další proměnnou.
3) V třetí řadě si určíme kolik se bude přidávat hodnot během jednoho cyklu.
4) A nakonec zadáme, co vlastně ten cyklus bude při každém opakování vykonávat za kód.

# Do While
```java 
int i = 0;
do {
  System.out.println(i);
  i++;
}
while (i < 5);
```

1) Nejprve se zadáme libovolnou proměnnou např``` string ```nebo```  int```
2) Za druhé si zadáme kód do bloku ``` do{}``` . Tento kód se provede minimálně jednou, dál budeme mít svojí podmínku uvnitř  ```while()``` a ta bude sloužit k tomu, jestli má jet cyklus dál. Pokud se podmínka splní, tak cyklus pojede dál pokud ne, cyklus skončí.
