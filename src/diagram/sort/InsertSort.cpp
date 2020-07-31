#include <iostream>

using namespace std;

// double insertSort(double *array, int n);
void insertSort(double array[], int n);

int main(){
    double ARR[] = {2.1, 0.67, 8.45, 6.66, 4, 2.24, 0.8, 5.4, 10};
    double *res;
    insertSort(ARR, 9);
    cout << "sorted array:" << endl;
    for (int i = 0; i < 9; i++)
    {
        cout << *(ARR + i) << ", ";
    }
    
    return 0;
}

// double insertSort(double *array, int n){
//     for (int i = 1; i < n; i ++){
//         double x = *(array + i);
//         int j = i - 1;
//         while (*(array + j) > x && j > 0){
//             (array + j + 1) = *(array + j);
//             j--;
//         }
//         (array + j + 1) = x;
//     }
// }

void insertSort(double array[], int n){
    for (int i = 1; i < n; i ++){
        double x = array[i];
        int j = i - 1;
        while (array[j] > x && j >= 0){
            array[j + 1] = array[j];
            j--;
        }
        array[j + 1]= x;
    }
}
