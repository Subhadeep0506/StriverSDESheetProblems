from typing import List


class CourseScheduleII:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        preq_map = {i:[] for i in range(numCourses)}
        
        for course, preq in prerequisites:
            preq_map[course].append(preq)
        
        visited, cycle = set(), set()
        res = []

        def dfs(course):
            if course in cycle:
                return False
            if course in visited:
                return True

            cycle.add(course)
            for preq in preq_map[course]:
                if dfs(preq) == False:
                    return False
            # We remove the course fromcycle because it's no longer in 
            # the path that we will be further visiting
            cycle.remove(course)
            visited.add(course)
            res.append(course)
            return True

        for course in range(numCourses):
            if dfs(course) == False:
                return []
        return res