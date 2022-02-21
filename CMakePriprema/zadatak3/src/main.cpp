#include <iostream>
#include <cstring>
#include "Professor.cpp"
#include "Student.cpp"
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

