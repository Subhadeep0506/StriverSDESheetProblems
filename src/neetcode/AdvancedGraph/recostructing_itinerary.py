from typing import List


class ReconstructingItinerary:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        # Sort the tickets in lexicographical order
        tickets.sort()
        # Making an adjacency list for source and destination
        adj = {src: [] for src, _ in tickets}
        for src, des in tickets:
            adj[src].append(des)
        res = ["JFK"]

        # Dfs logic
        def dfs(src):
            # Base case: If length of result list is equal to length of tickets + 1
            # Return true
            if len(res) == len(tickets) + 1:
                return True
            # If source node dont exist in adjacency list, return False
            if src not in adj:
                return False
            # Make a copy of adjacency list
            temp = list(adj[src])
            # Now iterate for each neighbors of current source node
            for i, nei in enumerate(temp):
                # Remove the ith node from adjacency list
                adj[src].pop(i)
                # Add the neighbor to result array
                res.append(nei)
                # Run dfs on neighbor node
                # If it returns true, return true and stop there
                if dfs(nei):
                    return True
                # Add the removed node from adjacency list at index i
                adj[src].insert(i, nei)
                # Remove the last node from result array
                res.pop()
            # Return false if nothing works
            return False
        
        dfs("JFK")
        return res