#include <stdio.h>

main ()
{
	char a = 'x';
	int x = a - '0';

	if (a!='x' && x > 9)
	{
		printf("Houston, we have a problem\n");
	}
	if (a == 'x')
		printf("The character %c is number %d \n", a, x);
	else 
		printf("error\n");
}
