#include <stdio.h>
#define boolean int
#define true 1
#define false 0
main(){
int timeOfDay;
int timeDuration;
int hour;
boolean check = false;

printf("Enter the time of the day in 24h format;\n");
scanf("%d", &timeOfDay);
while (check==false)
{
	int i;
	for (i = 0; i < 24; i++)
	{
		hour = i*100;
		/* if the time has less hours than the hour counter*/
		if (hour > timeOfDay)
		{
		/*declare an illegal time when the number of minutes remaining*/
		/*is greater than 59*/
			if ((hour - timeOfDay) < 41)
			{
				check = false;
				break;
			}
			else
			{
				check = true;
				break;
			}
		}
	}
	/*Check the hours secondly*/
	if (timeOfDay > 2359)
	{
		check = false;
	}
	/*if one of the tests fails, try again*/
	if (check == false)
	{
		printf("Try again. Enter a valid 24h time of day\n");
		scanf("%d", &timeOfDay);
	}
}
printf("Enter the duration of time;\n");
scanf("%d", &timeDuration);
boolean check2 = false;
while (check2==false)
{
	int i;
        for (i = 0; i < 24; i++)
        {
                hour = i*100;
                /* if the time has less hours than the hour counter*/
                if (hour > timeDuration)
                {
                /*declare an illegal time when the number of minutes*/
		/*remaining is greater than 59*/
                        if ((hour - timeDuration) < 41)
                        {
                                check2 = false;
                                break;
                        }
                        else
                        {
                                check2 = true;
                                break;
			}
		}
	}
	if(check2==false)
	{
		printf("Enter the duration of time;\n");
        	scanf("%d", &timeDuration);
	}
}
/* calculate the total time */
int totalTime = timeOfDay+timeDuration;
while (totalTime > 2359){
	totalTime = totalTime - 2400;
}
printf("The total time from %d to %d is %d \n", timeOfDay, totalTime,
timeDuration);
}
