#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>

main (){
	srand(time(NULL));
	/*Random numbers for the x and y*/
	float x = ((float)rand()/RAND_MAX);
	float y = ((float)rand()/RAND_MAX);
	
	float h = (float) sqrt((x*x)+(y*y));
	
	/*Test prints*/
	printf("x is %lf and y is %lf\n", x, y);
	printf("Hypotenuse is %f\n", h);
}
