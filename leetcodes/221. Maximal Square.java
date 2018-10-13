
public int maximalSquare( char[][] m ) {

        if ( m.length == 0 || m[0].length == 0 ) {
            return 0;
        }

        final int rows = m.length;
        final int cols = m[0].length;

        int max = 0;

        int[] b = new int[cols + 1];
        int[] prev_s = new int[cols + 1];
        int[] curr_s = new int[cols + 1];

        for ( int i = rows - 1 ; i >= 0 ; i-- ) {

            int right = 0;
            int[] temp = prev_s;
            prev_s = curr_s;
            curr_s = temp;
            //Arrays.fill(curr_s,0);
            //Arrays.fill(curr_s,0);

            for ( int j = cols - 1 ; j >= 0 ; j-- ) {

                if ( m[i][j] == '0' ) {
                    curr_s[j]=0;
                    b[j] = 0;
                    right = 0;
                    continue;
                }

                int inside = prev_s[j + 1];

                if ( inside == 0 ) {

                    curr_s[j] = 1;
                    b[j] ++;
                    right++;

                    max = (max==0) ? 1 : max;

                    continue;
                }

                int wing = Math.min( right , b[j] );

                int pre_square = Math.min( wing , inside );

                int square_side = pre_square + 1;

                curr_s[j] = square_side;
                b[j]++;
                right++;

                max = Math.max( max , square_side );
            }
        }

        return max * max;
    }
}
