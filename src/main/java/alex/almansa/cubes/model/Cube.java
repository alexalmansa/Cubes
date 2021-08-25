package alex.almansa.cubes.model;

import org.springframework.lang.Nullable;

public class Cube {

    private int id;
    private final double minX;
    private final double maxX;
    private final double minY;
    private final double maxY;
    private final double minZ;
    private final double maxZ;

    public Cube(@Nullable int id, Point3D centerPoint, double edgeLength) {
        this.id = id;
        if (edgeLength <= 0) {
            throw new IllegalArgumentException("Invalid edge length value. Length has to be a positive number.");
        }
        this.minX = centerPoint.getX() - edgeLength / 2;
        this.maxX = centerPoint.getX() + edgeLength / 2;
        this.minY = centerPoint.getY() - edgeLength / 2;
        this.maxY = centerPoint.getY() + edgeLength / 2;
        this.minZ = centerPoint.getZ() - edgeLength / 2;
        this.maxZ = centerPoint.getZ() + edgeLength / 2;
    }

    /**
     * Returns if both cubes intersect
     *
     * @param cube The cube to check the intersection with
     * @return A boolean indicating if they intersect
     */
    public boolean hasInterception(Cube cube) {
        return (this.getMinX() <= cube.getMaxX() && this.getMaxX() >= cube.getMinX()) &&
                (this.getMinY() <= cube.getMaxY() && this.getMaxY() >= cube.getMinY()) &&
                (this.getMinZ() <= cube.getMaxZ() && this.getMaxZ() >= cube.getMinZ());
    }

    public float calculateIntersection(Cube cube) {
        return (float) (Math.max(Math.min(this.getMaxX(), cube.getMaxX()) - Math.max(this.getMinX(), cube.getMinX()), 0) *
                Math.max(Math.min(this.getMaxY(), cube.getMaxY()) - Math.max(this.getMinY(), cube.getMinY()), 0) *
                Math.max(Math.min(this.getMaxZ(), cube.getMaxZ()) - Math.max(this.getMinZ(), cube.getMinZ()), 0));
    }

    public double getMinX() {
        return minX;
    }

    public double getMaxX() {
        return maxX;
    }

    public double getMinY() {
        return minY;
    }

    public double getMaxY() {
        return maxY;
    }

    public double getMinZ() {
        return minZ;
    }

    public double getMaxZ() {
        return maxZ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
