
package inventorysystem;

/**
 *
 * @author KL_Schweizer
 */
public class PaginationConfiguration {
    private double limit = 50.0;
    private double offset = 0.0;

    public double getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public double getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
