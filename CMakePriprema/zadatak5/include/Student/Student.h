#include <string>
#ifndef StudentHeader
#define StudentHeader

class Student {
    private:
        std::string studentName;

    public:
        std::string getName(){ return studentName;}
        inline Student(std::string name);
        
    
};

#endif