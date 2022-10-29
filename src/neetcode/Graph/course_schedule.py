from typing import List


class CourseSchedule:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        pre_map = {i : [] for i in range(numCourses)}

        for course, preq in prerequisites:
            pre_map[course].append(preq)
        
        visited = set()

        def dfs(course):
            if course in visited:
                return False
            if pre_map[course] == []:
                return True
            visited.add(course)
            for preq in pre_map[course]:
                if not dfs(preq):
                    return False
            visited.remove(course)
            pre_map[course] = []
            return True

        for course in range(numCourses):
            if not dfs(course):
                return False
        return True