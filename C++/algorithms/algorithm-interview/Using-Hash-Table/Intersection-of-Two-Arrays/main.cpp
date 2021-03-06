/**
 * Created by Thpffcj on 2017/9/18
 */

/**
 * Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 */

#include <iostream>
#include <vector>
#include <unordered_set>
using namespace std;

class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {

        unordered_set<int> record;
        for ( int i = 0; i < nums1.size(); i++ ) {
            record.insert( nums1[i] );
        }

        unordered_set<int> resultSet;
        for ( int i = 0; i < nums2.size(); i++ ) {
            if ( record.find( nums2[i] ) != record.end() ) {
                resultSet.insert( nums2[i] );
            }
        }

        vector<int> resultVector;
        for( unordered_set<int>::iterator iter = resultSet.begin() ; iter != resultSet.end() ; iter ++ ) {
            resultVector.push_back( *iter );
        }

        return resultVector;
    }
};

int main() {

    int nums1[] = {1, 2, 2, 1};
    vector<int> vec1(nums1, nums1 + sizeof(nums1)/sizeof(int));

    int nums2[] = {2, 2};
    vector<int> vec2(nums2, nums2 + sizeof(nums2)/sizeof(int));

    vector<int> res = Solution().intersection(vec1, vec2);
    for(int i = 0 ; i < res.size() ; i ++ )
        cout<<res[i]<<" ";
    cout<<endl;

    return 0;
}

