#include <stdio.h>

main (int argc, char *argv[])  {
	int temp;
	if (argc==1){
		printf("Usage;\t[0 < integers < 9] [operators]\n");
		exit(0);
	}
	int i;
	printf("number of args: %d\n", argc);
	for (i = 0 ; i<argc; i++){
		temp = argv[i][0] - '0';
		printf("this is char %d ; %d\n",i, temp);
	}
}
