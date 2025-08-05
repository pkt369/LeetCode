class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = speed.length;
        List<Car> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(new Car(position[i], speed[i], target));
        }
        Collections.sort(list);

        int count = 0;
        Queue<Car> q = new LinkedList<>(list);
        while (!q.isEmpty()) {
            count++;
            Car standard = q.poll();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Car compare = q.poll();
                if (standard.time >= compare.time) {
                    continue;
                }
                q.add(compare);
            }
        }

        return count;
    }
}

class Car implements Comparable<Car> {
    int position;
    int speed;
    double time;

    public Car (int position, int speed, int target) {
        this.position = position;
        this.speed = speed;
        this.time = (double) (target - position) / speed;
    }

    @Override
    public int compareTo(Car car) {
        return car.position - this.position;
    }
}