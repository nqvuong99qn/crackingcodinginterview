#include <stdio.h>

class HelloWorld
{
public:
    HelloWorld();
    ~HellowWorld();

    void print()
    {
        printf("Hello");
    }
};

int main()
{
    HelloWorld a;
    a.print();
    return 0;
}