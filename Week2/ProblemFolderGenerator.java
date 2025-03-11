package Week2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class ProblemFolderGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("생성할 문제 폴더 이름을 입력하세요: ");
        String directoryPath = scanner.nextLine().trim();
        scanner.close();

        List<String> problemNumbers = List.of("2630", "1992", "9184", "4779", "1491", "5639", "2263", "2872", "3049", "2447");
        
        // 폴더 생성
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            if (directory.mkdir()) {
                System.out.println("폴더 생성 완료: " + directoryPath);
            } else {
                System.out.println("폴더 생성 실패");
                return;
            }
        }
        
        // 파일 생성
        for (String problemNumber : problemNumbers) {
            String fileName = "B" + problemNumber + ".java";
            File file = new File(directoryPath + File.separator + fileName);
            
            if (!file.exists()) {
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write("package " + directoryPath + ";\n\n");
                    writer.write("import java.util.*;\n");
                    writer.write("import java.io.*;\n\n");
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
    }
}