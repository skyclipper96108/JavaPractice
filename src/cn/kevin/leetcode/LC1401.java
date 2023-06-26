package cn.kevin.leetcode;

public class LC1401 {

    /**
     * ����һ���� (radius, xCenter, yCenter) ��ʾ��Բ��һ����������ƽ�еľ��� (x1, y1, x2, y2) ������ (x1, y1) �Ǿ������½ǵ����꣬�� (x2, y2) �����Ͻǵ����ꡣ
     *
     * ���Բ�;������ص��Ĳ��֣����㷵�� true �����򷵻� false?��
     *
     * ���仰˵���������Ƿ� ���� �� (xi, yi) ��������Բ��Ҳ�ھ����ϣ����߶����������ڱ߽��ϵ��������
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
