package org.example.excelparser.app.service;

import org.example.excelparser.app.util.QuickSelect;
import org.example.excelparser.app.util.XlsxReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FinderService {
    private static final Logger log = LoggerFactory.getLogger(FinderService.class);

    public int findNthMin(String path, int n) {
        long startTotal = System.nanoTime();

        long startRead = System.nanoTime();
        Set<Integer> numbers = XlsxReader.readFile(path);
        long endRead = System.nanoTime();

        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }
        if (n < 1 || n > numbers.size()) {
            throw new IllegalArgumentException("N out of bound: 1.." + numbers.size());
        }

        int[] arr = new int[numbers.size()];
        int i = 0;
        for (int v : numbers)
            arr[i++] = v;

        long startSelect = System.nanoTime();
        int result = QuickSelect.select(arr, n - 1);
        long endSelect = System.nanoTime();

        long endTotal = System.nanoTime();

        log.info("File read time:   {} ms", (endRead - startRead) / 1000000);
        log.info("QuickSelect time: {} ms", (endSelect - startSelect) / 1000000);
        log.info("Total time:       {} ms", (endTotal - startTotal) / 1000000);
        log.info("Result ({}-th min): {}", n, result);

        return result;
    }
}
