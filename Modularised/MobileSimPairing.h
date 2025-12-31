#ifndef MOBILE_SIM_PAIRING_H
#define MOBILE_SIM_PAIRING_H

typedef struct Mobile_SIM_PAIRING{
 char mobile_number[100];
 char sim_number[100];
 char status[20];
}Mobile_SIM_PAIRING;

void viewRange(MobileNumber* mobno,SIMNumber* simno);
void activateMobileNumber(MobileNumber** mobno,SIMNumber** simno,int* countOfNumber,
int* countOfSimNumber,Mobile_SIM_PAIRING** msp,int* countOfMsp);
void viewMobileSimPairing(Mobile_SIM_PAIRING* msp,int* count);
void deactivateMobileNumber(Mobile_SIM_PAIRING** msp,int* countOfMsp);
void releaseNumber(Mobile_SIM_PAIRING** msp,int* countOfMsp,MobileNumber** mobno,SIMNumber** simno,int* countOfNumber,
int* countOfSimNumber);
void shutdown(MobileNumber** mobno,SIMNumber** simno,Mobile_SIM_PAIRING** msp);

#endif