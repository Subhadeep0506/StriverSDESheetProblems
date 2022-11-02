from typing import List
import collections


class ValidSudoku:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = collections.defaultdict(set)
        cols = collections.defaultdict(set)
        blocks = collections.defaultdict(set)

        for row in range(9):
            for col in range(9):
                if board[row][col] == '.':
                    continue
                # If the 
                if (board[row][col] in rows[row] or
                    board[row][col] in cols[col] or
                    board[row][col] in blocks[(row // 3, col // 3)]):
                    return False

                rows[row].add(board[row][col])
                cols[col].add(board[row][col])
                blocks[(row // 3, col // 3)].add(board[row][col])
        return True