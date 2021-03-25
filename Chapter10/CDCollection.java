package Chapter10;

public class CDCollection {
    private CD[] collection;
    private int count;
    private double totalCost;
    private int totalTracks;

//-----------------------------------------------------------------
// Creates an initially empty collection.
//-----------------------------------------------------------------
    public CDCollection () {
        collection = new CD[6];
        count = 0;
        totalCost = 0.0;
        totalTracks = 0;
    }


    public double ArrayAvg(int[ ] list, int n) {
        int sum = 0;
        for(int j = 0; j < n; j++) {
            sum += list[j];
        }
        return (double) sum / n;
    }
//

// Adds a CD to the collection, increasing the size of the
// collection if necessary.
//-----------------------------------------------------------------
    public void addCD (String title, String artist, double cost, int tracks) {
        if (count == collection.length) {
            increaseSize();
        }
        
        collection[count] = new CD (title, artist, cost, tracks);
        totalCost += cost;
        count++;
        totalTracks += tracks;
    }

//-----------------------------------------------------------------
// Returns a report describing the CD collection.
//-----------------------------------------------------------------
    public String toString() {

        String report = "******************************************\n";
        report += "My CD Collection\n\n";

        report += "Number of CDs: " + count + "\n";
        report += "Total cost: " + (totalCost) + "\n";
        report += "Average cost: " + (totalCost/count) + "\n";
        report += "Total Tracks: " + totalTracks;

        report += "\n\nCD List:\n\n";

        for (int cd = 0; cd < count; cd++) {
            report += collection[cd].toString() + "\n";
        }
        return report;
    }

//-----------------------------------------------------------------
// Doubles the size of the collection by creating a larger array
// and copying the existing collection into it.
//-----------------------------------------------------------------
    private void increaseSize () {
        CD[] temp = new CD[collection.length * 2];

        for (int cd = 0; cd < collection.length; cd++) {
            temp[cd] = collection[cd];
        }
        collection = temp;
    }
}