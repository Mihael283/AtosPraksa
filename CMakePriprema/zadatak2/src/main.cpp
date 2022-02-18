#include <iostream>
#include <cstring>
#include </home/mikeee/Documents/zadatak2/src/Student.cpp>
#include </home/mikeee/Documents/zadatak2/src/Professor.cpp>
using namespace std;



int main(){
    string name;
    cout << "Enter student's name: ";
    cin >> name;
    Student student(name);
    cout << "Enter professors's name: ";
    cin >> name;
    Professor professor(name);

    cout << "\n";
    cout << "Student's name: " << student.getName() << "\n";
    cout << "Professors's name: " << professor.getName() << "\n";
    return 0;
};

