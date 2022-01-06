package frc.util.pathGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.wpi.first.wpilibj.Filesystem;
import frc.robot.Constants;

public class Path {
    public Point[] left;
    public Point[] right;
    private double startAngle;


/**
 * 
 * @param autoName - the name of the auto
 * @param startAngle - the start angle
 */
    Path(String autoName, double startAngle) {
        this.startAngle = startAngle;
        String pathFolder = Filesystem.getDeployDirectory().toString() + "/" + autoName;
        right = loudFromCsv(pathFolder + "/" + autoName + ".right.csv");
        left = loudFromCsv(pathFolder + "/" + autoName + ".left.csv");
    }

    /**
     * 
     * @param index
     * @return the angle from this point
     */
    double getAngle(int index) {
        return startAngle + ((left[index].pos - right[index].pos) / Constants.ROBOT_WIDTH);
    }

    /**
     * 
     * @param filePath the path of the file 
     * @return array of points
     */
    Point[] loudFromCsv(String filePath) {
        List<Point> points = new ArrayList<Point>();
        try {
            File csvFile = new File(filePath);
            //TODO this is may cause problem
            Scanner myReader = new Scanner(csvFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.charAt(0) == 'a'){
                    continue;
                }
                String[] pointArr = data.split(",", 2);
                //move the scv to list
                Point point = new Point(pointArr[0], pointArr[1], pointArr[2]);
                points.add(point);
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        Point[] pointsArray = new Point[points.size()];
        return points.toArray(pointsArray);
    }
}