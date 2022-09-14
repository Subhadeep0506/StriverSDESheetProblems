/*
 * You are given two integers n and k and two integer arrays speed and efficiency 
 * both of length n. There are n engineers numbered from 1 to n. speed[i] and 
 * efficiency[i] represent the speed and efficiency of the ith engineer 
 * respectively.
 * 
 * Choose at most k different engineers out of the n engineers to form a team with 
 * the maximum performance.
 * 
 * The performance of a team is the sum of their engineers' speeds multiplied by 
 * the minimum efficiency among their engineers. 
 * 
 * Return the maximum performance of this team. Since the answer can be a huge 
 * number, return it modulo 109 + 7.
 * ---------------------------------------
 * Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 2
 * Output: 60
 * Explanation: 
 * We have the maximum performance of the team by selecting engineer 2 (with 
 * speed=10 and efficiency=4) and engineer 5 (with speed=5 and efficiency=7). That 
 * is, performance = (10 + 5) * min(4, 7) = 60.
 * 
 * ---------------------------------------
 * Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 3
 * Output: 68
 * Explanation:
 * This is the same example as the first but k = 3. We can select engineer 1, 
 * engineer 2 and engineer 5 to get the maximum performance of the team. That is, 
 * performance = (2 + 10 + 5) * min(5, 4, 7) = 68.
 * ================================Approach=================================
 * 1. We take the emeployees and store them in a list
 * 2. We sort them in descending order of their efficiency
 * 3. then take each employee and add them to priority queue in ascending order
 *  of their speeds.
 * 4. Simultenously we calculate their performances.
 */

package sdesheet.Day12;

import java.util.*;

class Employee {
    int speed;
    int efficiency;
    
    Employee(int speed, int efficiency) {
        this.speed = speed;
        this.efficiency = efficiency;
    }
}

public class MaximumPerformanceOfTeam {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        // First we store the employees as list of Employees
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++)
            employees.add(new Employee(speed[i], efficiency[i]));
        
        // Then sort them in descending order of their efficiency
        Collections.sort(employees, (a, b) -> (b.efficiency - a.efficiency));
        
        // A priority queue that would store the selected employees in
        // ascending order of speed
        PriorityQueue<Employee> res = new PriorityQueue<>((p1, p2) -> (p1.speed - p2.speed));
        
        long result = 0;
        long sumSpeed = 0;
        
        for (int i = 0; i < n; i++) {
            // Get the current employee
            Employee employee = employees.get(i);
            // add it to priority queue
            res.add(employee);
            // sum its speed to total sum
            sumSpeed += employee.speed;
            // Now, if the priority queue size has exceeded, 
            // pop out the top employee, who has less speed
            if (res.size() > k) {
                sumSpeed -= res.poll().speed;
            }
            
            // As the employees are sorted in descending order of efficiency
            // the efficiency of current employee qould always be
            // lesser than previous employees' efficiency
            // So, we can calculate the performance here and only take it
            // if it is maximum
            result = Math.max(result, sumSpeed * employee.efficiency);
        }
        
        return (int)(result % 1000000007);
    }
}