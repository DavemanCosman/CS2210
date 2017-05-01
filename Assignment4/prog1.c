#include <stdio.h>
main (){
/*default values for z and n*/
        int z;
        int n;
        printf("enter a value for z^n; \n");
        scanf("%d", &z);
        scanf("%d", &n);
		/*If z is negative, make z positive*/
		while (n < 0)
		{
			printf("make the exponent positive please\n");
			scanf("%d", &n);
		}
        printf("%d \n", power(z,n));
}


/* z is the number being multiplied*/
/* n is the amount of times z is multiplied*/
int power(int z, int n){
        if (n == 0){
                return 1;}
        else {  /* if n is odd */
                if (n%2 == 1){
                        return z*power(z, n-1);
                }
                else{
                        return power(z, n/2) *power(z, n/2);
                }
        }
}
