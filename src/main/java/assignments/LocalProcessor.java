package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private Long period = 10_000_000_000_000L;
    protected String ProcessorVersion;
    private Integer valueofCheap;
    private Scanner informationscanner;
    public static LinkedList<String> stringArrayList = new LinkedList<>();

    public LocalProcessor(String processorName, long period,
                          String processorVersion, int valueOfCheap) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listiterator(LinkedList<String> stringList) {
       stringArrayList = stringList;
        for (String str: stringList) {
            if (str != null) {
                System.out.println(str.hashCode());
                System.out.println(processorName == null ? "" : processorName);
            }
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullnameProcessorgenerator(LinkedList<String> stringList) {
         processorName = processorName == null ? "" : processorName;
        return processorName += String.join(" ", stringList);
    }

    @ReadFullProcessorNameAnnotation
    public void readfullprocessorname(File file) throws FileNotFoundException {
           try (Scanner informationScanner = new Scanner(file)) {
            this.informationScanner = informationScanner;
            StringBuilder version = new StringBuilder(processorVersion == null ?
                    "" : processorName);
            while (informationScanner.hasNext()) {
                version.append(informationScanner.nextLine());
            }
            processorVersion = version.toString();
        }
    }
}
