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
package dibl.matrix;

import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

public class MatrixTest
{
    private static MatrixTransformer<Transformer<String>> transformer;
    private static String[][] m = { {"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};

    @BeforeClass
    public static void init()
    {
        transformer = new MatrixTransformer<Transformer<String>>(new Transformer<String>()
        {
            public String flipLeftRight(String o)
            {
                return o;
            }

            public String flipBotomUp(String o)
            {
                return o;
            }

            public String rotate180(String o)
            {
                return o;
            }
        });
    }

    @Test
    public void skewDown()
    {
        String s = Arrays.deepToString(Extractor.skewDown(m));
        assertThat(s, is("[[1, 5, 9], [4, 8, 3], [7, 2, 6]]"));
    }

    @Test
    public void skewUp()
    {
        String s = Arrays.deepToString(Extractor.skewUp(m));
        assertThat(s, is("[[1, 8, 6], [4, 2, 9], [7, 5, 3]]"));
    }

    @Test
    public void shift()
    {
        String s = Arrays.deepToString(Extractor.shift(m, 1, 1));
        assertThat(s, is("[[5, 6, 4], [8, 9, 7], [2, 3, 1]]"));
    }

    @Test
    public void flipBottomUp()
    {
        String s = Arrays.deepToString(transformer.flipBottomUp(m));
        assertThat(s, is("[[7, 8, 9], [4, 5, 6], [1, 2, 3]]"));
    }

    @Test
    public void flipLeftRight()
    {
        String s = Arrays.deepToString(transformer.flipLeftRight(m));
        assertThat(s, is("[[3, 2, 1], [6, 5, 4], [9, 8, 7]]"));
    }

    @Test
    public void rotate180()
    {
        String s = Arrays.deepToString(transformer.rotate180(m));
        assertThat(s, is("[[9, 8, 7], [6, 5, 4], [3, 2, 1]]"));
    }
}
