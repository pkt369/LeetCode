class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> list = new LinkedList<>();
        for (int i = 0; i < position.length; i++) {
            Car car = new Car(position[i], speed[i], target);
            list.add(car);
        }

        Collections.sort(list);
        Queue<Car> q = new LinkedList<>(list);
        int count = 0;
        while (!q.isEmpty()) {
            Car standard = q.poll();
            count++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Car compare = q.poll();
                // System.out.println("standard: " + standard.time + ", compare: " + compare.time);
                if (standard.time < compare.time) {
                    q.offer(compare);
                    continue;
                }
            }
        }

        return count;
    }
}

class Car implements Comparable<Car> {
    int start;
    int speed;
    double time;

    public Car(int start, int speed, int target) {
        this.start = start;
        this.speed = speed;

        time = (double)(target - start) / speed;
    }

    @Override
    public int compareTo(Car car) {
        return car.start - this.start;
    }
}