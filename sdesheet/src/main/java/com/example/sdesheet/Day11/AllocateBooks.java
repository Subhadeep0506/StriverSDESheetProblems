/*
 * Given an array of integers A of size N and an integer B.
 * 
 * College library has N bags,the ith book has A[i] number of pages.
 * 
 * You have to allocate books to B number of students so that maximum number of
 * pages alloted to a student is minimum.
 * 
 * 1. A book will be allocated to exactly one student.
 * 2. Each student has to be allocated at least one book.
 * 3. Allotment should be in contiguous order, for example: A student cannot be
 * allocated book 1 and book 3, skipping book 2.
 * 
 * Calculate and return that minimum possible number.
 */

package com.example.sdesheet.Day11;

import java.util.*;

public class AllocateBooks {
    public int books(ArrayList<Integer> books, int students) {
        int noOfBooks = books.size();
        // If there are more students than books
        if (students > noOfBooks) 
            return -1;
        
        // Low will be the book with least pages
        int low = books.get(0);
        // high will be the total sum of pages of all the books 
        int high = 0;
        for (int i = 0; i < noOfBooks; i++) {
            high += books.get(i);
            low = Math.min(low, books.get(i));
        }
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (isPossible(books, mid, students)){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    public boolean isPossible(ArrayList<Integer> books, int mid, int students) {
        int count = 0;
        int sumOfPages = 0;
        int len = books.size();
        for (int i = 0; i < len; i++) {
            if (sumOfPages + books.get(i) > mid) {
                count++;
                sumOfPages = books.get(i);
                if (sumOfPages > mid)
                    return false;
            }
            else {
                sumOfPages += books.get(i);
            }
        }
        
        if (count < students)
            return true;
        return false;
    }
}
