#include <bits/stdc++.h>
using namespace std; 
const int MM = 1e5 + 2;
int N, M, p[MM];
bool check (int x){
    int cnt = 1, lst = p[0];
    for (int i=1; i < N; i++){
        if (p[i]- lst >= x){
            lst = p[i]; cnt++;
        }
    }
    return cnt >=M;
}
int main(){
    cin >> N >> M;
    for (int i =0; i<N; i++) cin >> p[i];
    sort (p, p+N);
    int lo = 1, hi = 1e9, ans = 0;
    while (lo<=hi){
        int mid = (lo+hi)/2;
        if (check (mid)){
            ans = mid;
            lo = mid+1;
        }
        else
        hi = mid-1;
    }
    cout << ans << "\n";
}