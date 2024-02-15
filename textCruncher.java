import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class NumberCruncher {
    public static void main(String[] args) {
        // Generate random grades for 10 students
        ArrayList<String> students = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            String studentName = "Student " + i;
            int grade = (int) (Math.random() * 101); // Random grade between 0 and 100
            students.add(studentName + "\t" + grade);
        }

        // Write data to "numbercruncher.txt"
        try (PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\2004h\\OneDrive\\Documents\\cruncher.txt"))) {
            writer.println("Student Name\tGrade");
            for (String student : students) {
                writer.println(student);
            }
            System.out.println("Data written to numbercruncher.txt successfully.");
        } catch (IOException e) {
            System.err.println("Error writing data to numbercruncher.txt: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        // Read grades from "numbercruncher.txt" and calculate statistics
        ArrayList<Integer> grades = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\2004h\\OneDrive\\Documents\\numbercruncher.txt"))) {
            String line;
            reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                int grade = Integer.parseInt(parts[1]);
                grades.add(grade);
            }
        } catch (IOException e) {
            System.err.println("Error reading data from numbercruncher.txt: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        // Calculate statistics
        double average = calculateAverage(grades);
        int median = calculateMedian(grades);
        int mode = calculateMode(grades);
        double stdDev = calculateStandardDeviation(grades);

        // Write calculations' results to "summary.txt"
        try (PrintWriter writer = new PrintWriter(new FileWriter("summary.txt"))) {
            writer.printf("Average Grade: %.2f\n", average);
            writer.println("Median Grade: " + median);
            writer.println("Mode Grade: " + mode);
            writer.printf("Standard Deviation: %.2f\n", stdDev);
            System.out.println("Statistics written to summary.txt successfully.");
        } catch (IOException e) {
            System.err.println("Error writing statistics to summary.txt: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static double calculateAverage(ArrayList<Integer> grades) {
        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    private static int calculateMedian(ArrayList<Integer> grades) {
        Collections.sort(grades);
        int size = grades.size();
        if (size % 2 == 0) {
            return (grades.get(size / 2 - 1) + grades.get(size / 2)) / 2;
        } else {
            return grades.get(size / 2);
        }
    }

    private static int calculateMode(ArrayList<Integer> grades) {
        int mode = 0;
        int maxFrequency = 0;
        for (int grade : grades) {
            int frequency = Collections.frequency(grades, grade);
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                mode = grade;
            }
        }
        return mode;
    }

    private static double calculateStandardDeviation(ArrayList<Integer> grades) {
        double mean = calculateAverage(grades);
        double sum = 0;
        for (int grade : grades) {
            sum += Math.pow(grade - mean, 2);
        }
        return Math.sqrt(sum / grades.size());
    }
}
