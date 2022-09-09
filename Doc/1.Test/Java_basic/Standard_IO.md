# Standardní vstup a výstup
## Scanner (Standardní vstup)
 Slouží pro standardní vstup užívatele
 Scanner si nejprve musíme  naimportovat pomocí  kodu:
``` java
import java.util.Scanner;
``` 
Poté si ho pojmenujeme:
``` java
Scanner název = new Scanner(system.in);
``` 
Metody Scanneru:

``` java
nextLong();
nextDouble();
nextShort();
nextByte();
nextBoolean();
nextInt();
nextLine();
nextFloat();
```
## Standardní výstup:
``` java
System.out.println();
```
- můžeme použít metody z balíku System.out
- dvě základní metody: print() a println()
- System.out.print() - vypíše obsah v závorce na monitor
- System.out.println() - vypíše obsah v závorce na monitor a odřádkuje
- Řetězce v závorce mohu spojovat pomocí operátoru + (řetězec mohu spojovat i s proměnnou)
