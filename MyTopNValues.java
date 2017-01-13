import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MyTopNValues implements TopValues {

    // Initial value of K should be zero.
    public int K;
    public long[] topNList;
    public List<Long> listOfLongValues;

    public MyTopNValues(final int topKvalues) {

	// TO DO: constructor
	K = topKvalues;
	topNList = new long[K];
	listOfLongValues = new ArrayList<Long>();
    }

    public void consume(final long value) {

	// TO DO: consume/process a new value
	if (listOfLongValues.size() < K) {

	    // Insert the new value in sorted order.
	    listOfLongValues.add(value);
	} else {

	    // Or if the queue or capacity is reached, check if the new value is
	    // greater than the smallest value in
	    // the list. If yes, remove the smallest value, insert the new
	    // value.
	    if (value > listOfLongValues.get(0)) {

		listOfLongValues.remove(0);
		listOfLongValues.add(value);
	    }
	}

	// If the list is not empty, sort it. Maintain the list in sorted order
	// always.
	if (!listOfLongValues.isEmpty()) {
	    Collections.sort(listOfLongValues);
	}

    }

    public long[] top() {

	// TO DO: return the top K values consumes
	topNList = this.toArray(listOfLongValues);
	return topNList;
    }

    public void display() {

	System.out
	.println("Printing the list at this time with capacity: " + K);
	for (long l : topNList) {
	    System.out.println(l);
	}
    }

    /*
     * Method to convert the collection of Long objects into array of long
     * types.
     */
    private long[] toArray(final List<Long> values) {

	long[] result = new long[values.size()];
	int i = 0;
	for (Long longValue : values) {
	    if (longValue == null) {
		// assigning default value of zero in array for null values in
		// collection.
		result[i++] = 0L;
	    } else {
		result[i++] = longValue;
	    }
	}
	return result;
    }
}
