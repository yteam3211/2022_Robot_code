/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.util.pathGeneratorNew;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import edu.wpi.first.wpilibj.Filesystem;

/**
 * @author Amitai Algom
 */
public class ReadPath {
    private String line = "", splitBy = ",";
    private ArrayList<PointSegments> PointSegments = new ArrayList<PointSegments>();
    private BufferedReader path;

    public ReadPath(String path2Csv) {
        // employeeDouble: 0 = left pos, 1 = right pos, 2 = vel left, 3 = vel right,4 =
        // acc left, 5 =
        // acc right, 6 = angle, 7 = x, 8 =y
        try {
            // parsing a CSV file into BufferedReader class constructor
            path = new BufferedReader(new FileReader(Filesystem.getDeployDirectory().toString() + "/" + path2Csv));
            int first = 0;

            while ((line = path.readLine()) != null) // returns a Boolean value
            {
                if (first != 0) {
                    String[] employee = line.split(splitBy); // use comma as separator

                    Double[] employeeDouble = new Double[employee.length];

                    for (int i = 0; i < employee.length; i++) {
                        employeeDouble[i] = Double.valueOf(employee[i]);
                    }

                    Segment leftSegment = new Segment(employeeDouble[0].doubleValue(), employeeDouble[2].doubleValue(),
                            employeeDouble[4].doubleValue());

                    Segment rightSegment = new Segment(employeeDouble[1].doubleValue(), employeeDouble[3].doubleValue(),
                            employeeDouble[5].doubleValue());

                    double angle = employeeDouble[6].doubleValue();

                    PointSegments.add(new PointSegments(leftSegment, rightSegment, angle));
                } else {
                    first++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (path != null) {
                try {
                    path.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public PointSegments[] read() {
        return PointSegments.toArray(new PointSegments[PointSegments.size()]);
    }
}