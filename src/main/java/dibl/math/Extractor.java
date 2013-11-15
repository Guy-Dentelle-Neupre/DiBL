// @formatter:off
/*
 * Copyright 2013, J. Pol
 *
 * This file is part of free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation.
 *
 * This package is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * See the GNU General Public License for more details. A copy of the GNU General Public License is
 * available at <http://www.gnu.org/licenses/>.
 */
// @formatter:on
package dibl.math;

public class Extractor
{
    public static String[][] shift(String[][] mat, int row, int col)
    {
        final int M = mat.length;
        final int N = mat[0].length;
        String[][] ret = new String[N][M];
        for (int r = 0; r < M; r++)
            for (int c = 0; c < N; c++)
                ret[r][c] = mat[(r + row) % M][(c + col) % N];
        return ret;
    }

    public static String[][] skewDown(String[][] mat)
    {
        final int M = mat.length;
        final int N = mat[0].length;
        String[][] ret = new String[N][M];
        for (int r = 0; r < M; r++)
            for (int c = 0; c < N; c++)
                ret[r][c] = mat[(r + c) % M][c];
        return ret;
    }

    public static String[][] skewUp(String[][] mat)
    {
        final int M = mat.length;
        final int N = mat[0].length;
        String[][] ret = new String[N][M];
        for (int r = 0; r < M; r++)
            for (int c = 0; c < N; c++)
                ret[r][c] = mat[(r + M - c) % M][c];
        return ret;
    }
}