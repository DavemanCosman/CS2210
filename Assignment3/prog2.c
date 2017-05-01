#include <stdio.h>
main(){
/* Calculates the ramaining balance on a loana after each of the first n
monthly payments*/
double loan = -1; /*amount in the loan, user input*/
double rate = -1; /*the yearly interest rate, user input*/
double m = -1; /*amount of monthly payments, user input*/
int n = -1; /*number of monthly payments, user input*/

while (loan<0){
	printf("Enter the amount of the loan\n");
	scanf("%lf", &loan);
}
while (rate<0){
	printf("Enter the amount of the yearly interest rate\n");
        scanf("%lf", &rate);
}
while (m < 0){
printf("Enter the amount of the monthly payment\n");
        scanf("%lf", &m);
}
while (n < 0){
	printf("Enter the number of monthly payments\n");
        scanf("%d", &n);
}
float balance = loan;
int i;
for (i = 0 ; i < n ; i++)
{
	balance = balance + loan*((rate/12)*0.01)-m;
	if (balance > 0){
		printf("Balance of account after %d months will be;", (i+1));
		printf("$%.2lf \n", balance);
	}
	else {
		printf("SUCCESS; fully paid at month %d\n", (i+1));
		break;
	}
}
}
