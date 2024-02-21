import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {

    public List<Integer> readFile(String path) {
        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }else{
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = "";
                while ((line = br.readLine()) != null) {
                    numbers.add(Integer.parseInt(line));
                }
                br.close();
            }
        } catch (Exception e) {
            System.err.println("File không tồn tại hoặc nội dung có lỗi");
        }
        return numbers;
    }
    public void writeFile(String filePath, int max) {
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Giá trị lớn nhất là: " + max);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public static int findMax(List<Integer> numbers) {
            int max =Integer.parseInt(String.valueOf(numbers.get(0)));
            for (int i = 0; i < numbers.size(); i++) {
                if (max < Integer.parseInt(String.valueOf(numbers.get(i)))) {
                    max = Integer.parseInt(String.valueOf(numbers.get(i)));
                }
            }
            return max;
        }



    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("src\\numbers.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("results.txt", maxValue);
    }
}


