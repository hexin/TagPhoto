#include <stdio.h>
#include <stdlib.h>
#include "jpg.h"

void openjpgfile(char *filename) {
    FILE *fp;
    fp = fopen(filename, "r");
    if (fp == NULL) {
        printf("Can't open input file %s", filename);
        exit(0);
    }
    char string;
    while(!feof(fp)){
        string = fgetc(fp);
        printf("%c", string);
    }
    fclose(fp);
}