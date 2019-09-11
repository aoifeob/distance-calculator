package com.example.distancecalculator.util;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileReaderUtilTest {

  @Autowired
  private FileReaderUtil fileReaderUtil;

  @Test
  public void testFileReaderReadsFileLineByLine() {
    List<String> expectedOutput = Arrays
        .asList(
            "{\"latitude\": \"53.761389\", \"user_id\": 30, \"name\": \"Nick Enright\", \"longitude\": \"-7.2875\"}",
            "{\"latitude\": \"54.080556\", \"user_id\": 23, \"name\": \"Eoin Gallagher\", \"longitude\": \"-6.361944\"}",
            "{\"latitude\": \"52.833502\", \"user_id\": 25, \"name\": \"David Behan\", \"longitude\": \"-8.522366\"}");
    assertEquals("", expectedOutput, fileReaderUtil.readFile("src/test/resources/customers.txt"));
  }

  @Test
  public void testFileReaderReturnsEmptyListWhenFileNotFound() {
    List<String> expectedOutput = Collections.emptyList();
    assertEquals("", expectedOutput, fileReaderUtil.readFile("nonexistentfile.data"));
  }
}
