package cn.xyc.kujiale;

import java.util.*;

public class Seats {

    /*电影院售票
    此程序能够监听命令行输入，可以输入三类命令：
            1: init 5 10
            2: sell 4 6
            3: print
    第一条命令创建一个5排一排10座的影厅。
    第二条命令售出4排6座的票。
    第三条命令输出当前影厅的座位情况，'X'表示售出，'O'表示未售。
    按顺序执行上面三条命令后输出如下：
    OOOOOOOOOO
            OOOOOOOOOO
    OOOOOOOOOO
            OOOOOXOOOO
    OOOOOOOOOO￼*/


    /**
     * 初始化座位信息
     * @param rows
     * @param cols
     * @return
     */
    public char[][] init(int rows, int cols){

        char[][] seats = new char[rows][cols];

        // 初始化操作
        for (int i = 0; i < rows; i++) {
            Arrays.fill(seats[i], 'O');
        }

        return seats;
    }

    /**
     * 售出电影票
     * @param row
     * @param col
     * @return
     */
    public boolean sell(int row, int col, char[][] seats){

        int rows = seats.length;
        int cols = seats[0].length;

        int rowNew = row-1;
        int colNew = col-1;

        if(rowNew >= rows || colNew >= cols || rowNew < 0 || colNew < 0 || seats[rowNew][colNew] != 'O'){
            return false;
        }

        seats[rowNew][colNew] = 'X';
        return true;

    }


    /**
     * 打印出当前售出情况
     * @param seats
     */
    public void print(char[][] seats){

        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[0].length; j++) {
                System.out.print(seats[i][j]);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        Seats demo = new Seats();
        char[][] seats = demo.init(5, 10);
        demo.sell(4,6, seats);
        demo.print(seats);
    }
}
