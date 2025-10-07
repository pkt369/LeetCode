class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        Map<Integer, Character> map = getRomanNum();
        int divide = 1000;
        while (divide > 0) {
            if (divide > num) {
                divide /= 10;
                continue;
            }
            
            int remainder = num / divide;
            if (remainder == 4) {
                sb.append(map.get(divide)).append(map.get(divide * 5));
            } else if (remainder == 9) {
                sb.append(map.get(divide)).append(map.get(divide * 10));
            } else {
                if (remainder >= 5) {
                    sb.append(map.get(divide * 5));
                    remainder -= 5;
                }

                for (int i = 0; i < remainder; i++) {
                    sb.append(map.get(divide));
                }
            }
            

            num %= divide;
            divide /= 10;
        }
        return sb.toString();
    }

    public Map<Integer, Character> getRomanNum() {
        Map<Integer, Character> map = new HashMap<>();
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');
        return map;
    }
}