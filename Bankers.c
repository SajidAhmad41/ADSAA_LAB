
#include <stdio.h>
#define MAX 10  
int isSafe(int p, int r, int avail[MAX], int max[MAX][MAX], int alloc[MAX][MAX]) {
    int need[MAX][MAX], work[MAX], finish[MAX] = {0}, seq[MAX], count = 0;
    for (int i = 0; i < p; i++)  // Calculate need matrix
        for (int j = 0; j < r; j++)
            need[i][j] = max[i][j] - alloc[i][j];
    for (int i = 0; i < r; i++) work[i] = avail[i];  // Copy available resources
    while (count < p) {
        int found = 0;
        for (int i = 0; i < p; i++) {
            if (!finish[i]) {
                int j;
                for (j = 0; j < r && need[i][j] <= work[j]; j++);
                if (j == r) {  // If all needs are met
                    for (int k = 0; k < r; k++) work[k] += alloc[i][k];
                    seq[count++] = i;
                    finish[i] = found = 1;
                }
            }
        }
        if (!found) return printf("System is in an unsafe state.\n"), 0;
    }
    printf("Safe sequence: ");
    for (int i = 0; i < p; i++) printf("P%d ", seq[i]);
    printf("\n");
    return 1;
}
int main() {
    int p, r, alloc[MAX][MAX], max[MAX][MAX], avail[MAX];
    printf("Enter number of processes & resources: ");
    scanf("%d %d", &p, &r);
    printf("Enter allocated resource matrix:\n");
    for (int i = 0; i < p; i++) for (int j = 0; j < r; j++) scanf("%d", &alloc[i][j]);
    printf("Enter maximum resource matrix:\n");
    for (int i = 0; i < p; i++) for (int j = 0; j < r; j++) scanf("%d", &max[i][j]);
    printf("Enter available resources: ");
    for (int i = 0; i < r; i++) scanf("%d", &avail[i]);
    isSafe(p, r, avail, max, alloc);
    return 0;
}
