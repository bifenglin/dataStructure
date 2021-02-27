package model;

/**
 * @version 1.0
 * @program: dataStructure
 * @description:
 * @author: bifenglin
 * @create: 2020-11-26 14:14
 */
public class PointsParam {
    /**
     * 坐标id(由1开始，累加1，这样的：1,2,3,4,5...)
     */
    private String pointId;

    /**
     * X 坐标点
     */
    private String x;

    /**
     * X 坐标点
     */
    private String y;

    public PointsParam(){}

    public PointsParam(String pointId,String x,String y){
        this.pointId = pointId;
        this.x = x;
        this.y = y;
    }

    public String getPointId() {
        return pointId;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String toRow(){
        return String.format("%s,%s,%s",this.pointId,this.x,this.y);
    }
}
