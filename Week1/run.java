import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class run {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("생성할 폴더 이름을 입력하세요: ");
        String directoryPath = scanner.nextLine().trim();
        scanner.close();
        
        List<String> problemNumbers = List.of("24416", "2775", "2579", "11053", "1932", "2193", "11057", "11054", "1904", "2565");
        
        // 폴더 생성
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdir();
        }
        
        // 파일 생성
        for (String problemNumber : problemNumbers) {
            String fileName = "B" + problemNumber + ".java";
            File file = new File(directoryPath + File.separator + fileName);
            
            if (!file.exists()) {
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write("package " + directoryPath + ";\n\n");
                    writer.write("import java.io.IOException;\n\n");
                    writer.write("public class B" + problemNumber + " {\n");
                    writer.write("    public static void main(String[] args) throws IOException {\n");
                    writer.write("        \n");
                    writer.write("    }\n");
                    writer.write("}\n");
                } catch (IOException e) {
                    System.out.println("파일 생성 중 오류 발생: " + fileName);
                }
            }
        }
        System.out.println("파일 생성 완료.");
    }
}