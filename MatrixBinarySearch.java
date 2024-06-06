class MatrixBinarySearch {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int startX = 0, startY = 0;
        int endX = matrix.length - 1, endY = matrix[0].length - 1;

        while (startX <= endX) {
            int midX = (startX + endX) / 2;
            if (matrix[midX][endY] < target) {
                startX = midX + 1;
            } else if (matrix[midX][0] > target) {
                endX = midX - 1;
            } else {
                break;
            }
        }

        if (endX < startX) {
            return false;
        }

        int midX = (startX + endX) / 2;
        while (startY <= endY) {
            int midY = (startY + endY) / 2;
            if (matrix[midX][midY] < target) {
                startY = midY + 1;
            } else if (matrix[midX][midY] > target) {
                endY = midY - 1;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main (String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target)); 
        

    }
}