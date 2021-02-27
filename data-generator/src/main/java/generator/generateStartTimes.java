package generator;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import model.PointsParam;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @version 1.0
 * @program: dataStructure
 * @description:
 * @author: bifenglin
 * @create: 2020-11-26 14:13
 */
public class generateStartTimes {
    public static void main(String[] args) {
        getArimaData();
    }

    public static void getArimaData() {
        Integer times = 6 * 8 * 30;
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.MAY, 10, 0, 0);
        Date date = calendar.getTime();
        Random random = new Random();
        List<PointsParam> pointsParamList = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            PointsParam pointsParam = new PointsParam();
            String value = DateUtil.format(date, "yyyy-MM-dd HH:mm");
            date = DateUtil.offsetMinute(date, 1);
            System.out.println(value);
            pointsParam.setPointId(i + "");
            pointsParam.setX(value);
            int fact = RandomUtil.randomInt(4, 6);
            int y;
            if (fact % 2 == 0) {
                y = RandomUtil.randomInt(fact, fact+4);
            } else {
                y = RandomUtil.randomInt(fact, fact+2);
            }
            pointsParam.setY(y + "");
            pointsParamList.add(pointsParam);
        }


        System.out.println(pointsParamList.size());
        PointsToCsvFile("arima", pointsParamList);
    }

    public static void getNormalData() {
        Integer times = 6 * 8 * 30;
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.MAY, 10, 0, 0);
        Date date = calendar.getTime();
        Random random = new Random();
        List<PointsParam> pointsParamList = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            PointsParam pointsParam = new PointsParam();
            String value = DateUtil.format(date, "yyyy-MM-dd HH:mm");
            date = DateUtil.offsetMinute(date, 1);
            System.out.println(value);
            pointsParam.setPointId(i + "");
            pointsParam.setX(value);
            int fact = RandomUtil.randomInt(17) + 4;
            int y;
            if (fact % 2 == 0) {
                y = RandomUtil.randomInt(fact);
                if (y < 13 && fact < 5) {
                    y = y + 3;
                }
            } else {
                y = RandomUtil.randomInt(fact);
            }
            pointsParam.setY(y + "");
            pointsParamList.add(pointsParam);
        }


        System.out.println(pointsParamList.size());
        PointsToCsvFile("normal",pointsParamList);
    }


    public static void getSeasonData() {
        Integer times = 6 * 8;
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.MAY, 10, 0, 0);
        Date date = calendar.getTime();
        Random random = new Random();
        List<PointsParam> pointsParamList = new ArrayList<>();
        for (int j = 0; j < 30; j++) {
            for (int i = 0; i < times; i++) {
                PointsParam pointsParam = new PointsParam();
                String value = DateUtil.format(date, "yyyy-MM-dd HH:mm");
                date = DateUtil.offsetMinute(date, 1);
                System.out.println(value);
                pointsParam.setPointId(i + "");
                pointsParam.setX(value);
                int fact = RandomUtil.randomInt(j + 1) + 1;
                int y;
                if (j > 10 && j < 22) {
                    if (fact % 2 == 0) {
                        int d = RandomUtil.randomInt(fact);
                        y = RandomUtil.randomInt(3) + RandomUtil.randomInt(5) + d;
                    } else {
                        y = RandomUtil.randomInt(3) + RandomUtil.randomInt(5) + 5;
                    }
                    if (y < 3 && fact < 5) {
                        y = y + 3;
                    }
                } else if (j == 22) {
                    if (fact % 2 == 0) {
                        int d = RandomUtil.randomInt(fact);
                        y = RandomUtil.randomInt(3) + RandomUtil.randomInt(5) + d;
                    } else {
                        y = RandomUtil.randomInt(5);
                    }
                } else if (j > 22 && j < 28) {
                    int d = RandomUtil.randomInt(5);
                    y = RandomUtil.randomInt(5) + d;
                } else if (j == 28 || j == 29) {
                    int d = RandomUtil.randomInt(5);
                    y = RandomUtil.randomInt(d + 1);
                } else {
                    int d = RandomUtil.randomInt(fact);
                    y = RandomUtil.randomInt(3) + d;
                }
                pointsParam.setY(y + "");
                pointsParamList.add(pointsParam);
            }
        }

        System.out.println(pointsParamList.size());
        PointsToCsvFile("complex", pointsParamList);
    }

    /**
     * 生成csv文件
     *
     * @param pointsList
     * @return
     */
    private static void PointsToCsvFile(String title, List<PointsParam> pointsList) {
        if (pointsList != null && pointsList.size() > 0) {
            // 表格头
            String[] headArr = new String[]{"PointId", "X", "Y"};
            //CSV文件路径及名称
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            String filePath = "D:\\TestCsvDirectory\\noSeason"; //CSV文件路径
            String fileName = "CSV_" + title + df.format(localDateTime) + ".csv";//CSV文件名称
            File csvFile = null;
            BufferedWriter csvWriter = null;
            try {
                csvFile = new File(filePath + File.separator + fileName);
                File parent = csvFile.getParentFile();
                if (parent != null && !parent.exists()) {
                    parent.mkdirs();
                }
                csvFile.createNewFile();

                // GB2312使正确读取分隔符","
                csvWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "GB2312"), 1024);

                //这部分在第一行居中展示文件名称，根据实际情况，可选择取消注释
            /*int num = headArr.length / 2;
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < num; i++) {
                buffer.append(",");
            }
            csvWriter.write(buffer.toString() + fileName + buffer.toString());
            csvWriter.newLine();*/

                // 写入文件头部标题行
                csvWriter.write(String.join(",", headArr));
                csvWriter.newLine();

                // 写入文件内容
                for (PointsParam points : pointsList) {
                    csvWriter.write(points.toRow());
                    csvWriter.newLine();
                }
                csvWriter.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    csvWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
