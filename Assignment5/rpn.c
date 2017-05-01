#include <stdio.h>
#include <stdlib.h>
#include "stackADT.c"

/*entering the reverse polish notation in the command line*/
main (int argc, char *argv[])  {
	int result = 0;
	int temp, num1, num2;
	Stack numbers = create();
	if (argc==1){
		printf("Usage;\t[0 < integers < 9] [operators]\n");
		exit(0);
	}
	int i;
	for (i = 1 ; i< argc; i++){
		temp = argv[i][0] - '0';
		/*x is 72 in temp, so make sure multiplication isn't illegal*/
		if(temp > 9){
			if (temp != 13 && temp!=72){
				printf("Multi-character token is not allowed: %d\n",
temp);
				exit(0);
			}
		}
	}
	i = 1;
	for (i = 1 ; i< argc; i++){
		temp = argv[i][0] - '0';
		/*check if it's a number between 0 and 9*/
		if (temp <= 9 && temp >= 0){
			push(numbers, temp);
		}
		/*for every operation, a different code will run*/
		/*addition*/			
		if (argv[i][0] == '+')
		{
			num1 = pop(numbers);
			num2 = pop(numbers);
			result = num1 + num2;
			push(numbers, result);
		}
		/*substraction*/
		if (argv[i][0] == '-')
		{
			num1 = pop(numbers);
			num2 = pop(numbers);
			result = num2 - num1;
			push(numbers, result);
		}
		/*multiplication*/
		if (argv[i][0] == 'x')
		{
			num1 = pop(numbers);
			num2 = pop(numbers);
			result = num1 * num2;
			push(numbers, result);
		}
		/*division (check for division by 0)*/
		if (argv[i][0] == '/')
		{
			num1 = pop(numbers);
			/*terminate if there is a division by 0*/
			if (num1 == 0){
				printf("division by 0");
				exit(0);
			}
			num2 = pop(numbers);
			result = num2/num1;
			push(numbers, result);
		}
		if (argv[i][0] == '=')
		{
			result = pop(numbers);
		}
	}
	if (result == 0)
	{
		printf("Missing the '=' operator\n");
		exit(0);
	}
	printf("The answer is %d \n", result);
}
