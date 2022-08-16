def maxMin(k, arr):
    # Write your code here
    arr.sort()
    arr_copy = []
    i = 0
    count = 1
    lowest_diff = 9999
    arr_copy.append(arr[0])
    for i in range(1, len(arr)):
        diff = arr[i] - arr_copy[-1] 
        if diff < lowest_diff:
            diff = lowest_diff
            arr_copy.append(arr[i])
        
    res = max(arr_copy) - min(arr_copy)
    
    return res

arr = [100, 200, 300, 350, 400, 401, 402]
k = 2