package LeetCode.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q36 {

    /*
    Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
    Note:

    A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    Only the filled cells need to be validated according to the mentioned rules.

    */

    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> characterRowSetList = new ArrayList<>() {{
            add(new HashSet<>());
            add(new HashSet<>());
            add(new HashSet<>());
            add(new HashSet<>());
            add(new HashSet<>());
            add(new HashSet<>());
            add(new HashSet<>());
            add(new HashSet<>());
            add(new HashSet<>());
        }};
        List<Set<Character>> characterColumnSetList = new ArrayList<>() {{
            add(new HashSet<>());
            add(new HashSet<>());
            add(new HashSet<>());
            add(new HashSet<>());
            add(new HashSet<>());
            add(new HashSet<>());
            add(new HashSet<>());
            add(new HashSet<>());
            add(new HashSet<>());
        }};
        List<List<Set<Character>>> blockSetlistList = new ArrayList<>() {{
            add(new ArrayList<>() {{
                add(new HashSet<>());
                add(new HashSet<>());
                add(new HashSet<>());
            }});
            add(new ArrayList<>() {{
                add(new HashSet<>());
                add(new HashSet<>());
                add(new HashSet<>());
            }});
            add(new ArrayList<>() {{
                add(new HashSet<>());
                add(new HashSet<>());
                add(new HashSet<>());
            }});
        }};

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (characterRowSetList.get(i).contains(board[i][j])
                        || characterColumnSetList.get(j).contains(board[i][j])
                        || blockSetlistList.get(i / 3).get(j / 3).contains(board[i][j])) {
                    return false;
                }
                characterRowSetList.get(i).add(board[i][j]);
                characterColumnSetList.get(j).add(board[i][j]);
                blockSetlistList.get(i / 3).get(j / 3).add(board[i][j]);
            }
        }
        return true;
    }
}
