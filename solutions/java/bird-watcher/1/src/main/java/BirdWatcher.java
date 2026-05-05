
class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return this.birdsPerDay;
    }

    public int getToday() {
        return this.birdsPerDay[this.birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {
        this.birdsPerDay[this.birdsPerDay.length - 1]++;
    }

    public boolean hasDayWithoutBirds() {
        for (int birds : birdsPerDay) {
            if (birds == 0) {
                return true;
            }
        }
        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int totalCount = 0;

        int limit = numberOfDays > this.birdsPerDay.length ? this.birdsPerDay.length : numberOfDays;

        for (int i = 0; i < limit; i++) {
            totalCount += this.birdsPerDay[i];
        }
        return totalCount;
    }

    public int getBusyDays() {
        // Busy days are where five or more birds have visited your garden
        int busyDays = 0;
        for (int birds : this.birdsPerDay) {
            if (birds > 4) {
                busyDays++;
            }
        }
        return busyDays;
    }
}
