
## Bonusová úloha

Napište program, který bude kontrolovat změny v původním poli typu int. Program by měl číst data ze standardního vstupu a vypisovat záznamy do standardního výstupu. Na vstupu jsou vždy dvě pole. První pole je původní beze změn. Druhé pole je již po provedených změnách. Změnou může být chápáno přidání čísla nebo smazání čísla. Z toho by mělo být patrné, že velikosti těchto vstupních polí mohou být rozdílné. Pokud číslo bylo vloženo vypíše program INST ČÍSLO, pokud číslo bylo z původního pole smazáno, tak program vypíše DEL ČÍSLO.

První hodnotou na vstupu programu je velikost prvního - původního - pole, následuje sekvence hodnot, která slouží k naplnění prvního pole. Další hodnotou je - po těch předchozích - je velikost druhého - upraveného pole. Znovu následuje sekvence čísel k naplnění pole.

Příklad vstupu:

**5**

**1**
**2**
**3**
**4**
**5**

**6**

**1**
**3**
**4**
**5**
**6**
**7**

Očekávaný výstup:

**DEL 2**

**INS 6**

**INS 7**
