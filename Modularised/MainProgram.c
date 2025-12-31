#include <stdio.h>
#include <stdlib.h> 
#include <string.h>
#include "MobileRanges.h"
#include "SimRanges.h"
#include "MobileSimPairing.h"

int main(){
int op;
//Mobile Number Params
 MobileNumber* mobno = NULL;
    int countOfNumber = 0;
    int i;
   long startingNumber;
   //Sim No Params
   SIMNumber* simno = NULL;
    int countOfSimNumber = 0;
    long startingSIMNumber;
    //Mobile_SIM Pairing params
    Mobile_SIM_PAIRING* msp=NULL;
    int countOfMsp = 0;
printf("Welcome\n");
while(1){
printf("Select your option\n");
printf("1-Create Mobile Number Range\n2-Create Sim Number Range\n3-View Range\n a-Mobile Range b-Sim Range\n4-Activate Mobile Number\n5-Deactivate Mobile Number\n6-View Mobile-sim Prairing\n7-Release Number\n8-Exit\n");
scanf("%d",&op);
switch(op){
  case 1:
     printf("\nEnter Starting Number");
     scanf("%ld",&startingNumber);
      for (i = 0; i < 100; ++i) {
          saveMobileNumberRanges(&mobno, &countOfNumber,startingNumber);
          displayMob(mobno[countOfNumber - 1]);
          startingNumber++;
      }
           break;
  case 2:
         printf("Enter starting Number\n");
  scanf("%ld",&startingSIMNumber);
      for (i = 0; i < 100; ++i) {
          saveSimNumberRanges(&simno, &countOfSimNumber,startingSIMNumber);
          display(simno[countOfSimNumber - 1]);
  startingSIMNumber++;
      }
          break;
  case 3:viewRange(mobno,simno);
         break;
  case 4:activateMobileNumber(&mobno,&simno,&countOfNumber,&countOfSimNumber,&msp,&countOfMsp);
         break;
  case 5:deactivateMobileNumber(&msp,&countOfMsp);
         break;
  case 6:viewMobileSimPairing(msp,&countOfMsp);
         break;
  case 7:releaseNumber(&msp,&countOfMsp,&mobno,&simno,&countOfNumber,&countOfSimNumber);
         break;
  case 8:shutdown(&mobno,&simno,&msp);
         break;
  default:printf("No options Selected");
  }
}
return 0;
}