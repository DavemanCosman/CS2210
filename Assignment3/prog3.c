#include <stdio.h>
main(){ 
float e = 1;
int i = 1; /* keeping track of the loop */
int factorial = 1; /* help for computing factorials */
float term = 1; /* the first term */
float n; /* user input of a float */
int count = 0; /* amount of terms taken */

printf("Write a very small decimal number\n");
scanf("%f \n", &n);

while (term > n)
{
	factorial = factorial*i;
	term = 1/factorial;
	e = e + term;
	i++;
	count++;
	printf("The value of e is %f \n", &e);
	printf("The value of terms required are %d\n", &count);
}

printf("The value of e is %f \n", &e);
printf("The value of terms required are %d\n", &count);
}
