#include <stdio.h>

main ()
{
        char a = '+';
        int x = a - '0';
        printf("The character %c is number %d \n", a, x);

        a = '-';
        x = a - '0';
        printf("The character %c is number %d \n", a, x);

        a = 'x';
        x = a - '0';
        printf("The character %c is number %d \n", a, x);

        a = '/';
        x = a - '0';
        printf("The character %c is number %d \n", a, x);
}
