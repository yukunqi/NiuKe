class Paint {
public:
    int getMost(int n, int m) {
        return (n*m%2==0)?n*m/2:n*m/2+1;
    }
};