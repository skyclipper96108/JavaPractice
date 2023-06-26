package cn.kevin.leetcode;

public class LC1401 {

    /**
     * 给你一个以 (radius, xCenter, yCenter) 表示的圆和一个与坐标轴平行的矩形 (x1, y1, x2, y2) ，其中 (x1, y1) 是矩形左下角的坐标，而 (x2, y2) 是右上角的坐标。
     *
     * 如果圆和矩形有重叠的部分，请你返回 true ，否则返回 false?。
     *
     * 换句话说，请你检测是否 存在 点 (xi, yi) ，它既在圆上也在矩形上（两者都包括点落在边界上的情况）。
     *
     */
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        if(xCenter>=x1&&xCenter<=x2){
            if(yCenter>=y1-radius&&yCenter<=y2+radius){
                return true;
            }
        }else if(yCenter<=y2&&yCenter>=y1){
            if(xCenter>=x1-radius&&xCenter<=x2+radius){
                return true;
            }
        }else {
            double r2 = Math.pow(radius, 2);
            if(Math.pow(xCenter-x1,2)+Math.pow(yCenter-y1,2)<=r2){
                return true;
            }
            if(Math.pow(xCenter-x2,2)+Math.pow(yCenter-y1,2)<=r2){
                return true;
            }
            if(Math.pow(xCenter-x1,2)+Math.pow(yCenter-y2,2)<=r2){
                return true;
            }
            if(Math.pow(xCenter-x2,2)+Math.pow(yCenter-y2,2)<=r2){
                return true;
            }
        }
        return false;
    }
}
