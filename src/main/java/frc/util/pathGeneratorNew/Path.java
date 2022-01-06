package frc.util.pathGeneratorNew;

/**
 * @author Amitai Algom
 */
public class Path {
    private ReadPath readPath;
    private int point;
    private PointSegments[] points;

    public Path(String pathCsv) {
        readPath = new ReadPath(pathCsv);
        points = readPath.read();
    }

    public void resetPath() {
        point = -1;
    }

    public PointSegments getNextPoint() {
        point++;
        return points[point];
    }

    public boolean isPathEnd() {
        return points.length <= point + 1;
    }
}