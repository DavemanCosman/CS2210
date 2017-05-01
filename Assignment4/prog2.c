#include <stdio.h>
main (){
	/*size of array*/
	int n=100;
	printf("How big is this magic square? ");
	scanf("%d",	&n);
	while (n%2==0 || n<1 || n > 99){
		if (n%2 == 0){
			printf("Enter an odd number please\n");
		}
		if (n<1 || n>99){
			printf("Enter a number between 1 and 99\n");
		}
		printf("How big is this magic square? ");
		scanf("%d",	&n);
	}
	/*the array that will store the magic square*/
	int z [n][n];
	
	/*Store the array with 0*/
	int i;
	int j;
	for (i = 0 ; i < n ; i++){
		for (j = 0 ; j < n ; j++){
			z [i][j]=0;
		}
	}
	
	/*the length of the tree*/
	int length = n-1;
	/*the total length of the square, n^2*/
	int bigL = n*n;
	/*current number being filled*/
	int current = 1;
	/*coordinates for the rows (x) and columns (y)*/
	int x = 0;
	int y = (length - (length/2));
	/*temporary variables for shifting coordinates*/
	int xtemp;
	int ytemp;
	/*fill the first spot in the array with 1*/
	z [x] [y] = current;
	for (i = 0 ; i < bigL-1 ; i++){
		current++;
		
		/*Gathering coordinates*/
		xtemp = x-1;
			if ( xtemp < 0 )
			{
				/* last possible row in the array */
				xtemp = n-1; 
			}
		ytemp = y+1;
			if ( ytemp >= n)
			{
				/* first possible column in the array */
				ytemp = 0; 
			}
		
		/*inserting the number*/
		if (z [xtemp] [ytemp] != 0){
			if (x+1 == n){
				x = 0;
				z [x][y] = current;
			}
			else{
				x = x+1;
				z [x][y] = current;
			}
		}
		else{
			x = xtemp;
			y = ytemp;
			z [x] [y] = current;
		}
	}
	for (i = 0 ; i < n ; i++){
		for (j = 0 ; j < n ; j++){
			printf("%d\t", z [i][j]);
			if (j == n-1){
				printf("\n");
			}
		}
	}
}
