import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class FeatureExtraction{
  public static void main(String args[]){
     final int NUM_GOOD_WINDOWS=221; 
     final int NUM_FAIR_WINDOWS=76; 
     final int NUM_BAD_WINDOWS=149;
     final int NUM_GOOD_WINDOWS_TEST=95; 
     final int NUM_FAIR_WINDOWS_TEST=33; 
     final int NUM_BAD_WINDOWS_TEST=65;
    
    PrintWriter printWriter;
    DataCrawler dataCrawler = new DataCrawler();
    
    
       
    /*
     * Feature extraction for training data
     */ 
    

    DataPoints goodLogPoints = new DataPoints();
    FeatureComputer goodComputer = new FeatureComputer(goodLogPoints);
    
    
    DataPoints fairLogPoints = new DataPoints();
    FeatureComputer fairComputer = new FeatureComputer(fairLogPoints);
    
 
    DataPoints badLogPoints = new DataPoints();
    FeatureComputer badComputer = new FeatureComputer(badLogPoints);
    
    String goodInputFile = "../RSQC_Dataset/train_data/good_road_train.txt";
    dataCrawler.read(goodLogPoints,goodInputFile);
    
    String fairInputFile = "../RSQC_Dataset/train_data/fair_road_train.txt";
    dataCrawler.read(fairLogPoints,fairInputFile);
    
    String badInputFile = "../RSQC_Dataset/train_data/bad_road_train.txt";
    dataCrawler.read(badLogPoints,badInputFile);
    
    
    try {
      printWriter = new PrintWriter(new BufferedWriter(new FileWriter("../RSQC_Dataset/features/train_features.txt", true)));
      
      for(int i=0;i<NUM_GOOD_WINDOWS;i++){
        goodComputer.window();
        
        printWriter.println(goodComputer.computeZMean() + "," + goodComputer.computeZVariance() + "," + 
                            goodComputer.computeZStandardDeviation() + "," + goodComputer.highestZPeak() + "," +
                            goodComputer.lowestZTrough()+",3");
      }
      
      
      for(int i=0;i<NUM_FAIR_WINDOWS;i++){
        fairComputer.window();
        
        printWriter.println(fairComputer.computeZMean() + "," + fairComputer.computeZVariance() + "," + 
                            fairComputer.computeZStandardDeviation() + "," + fairComputer.highestZPeak() + "," +
                            fairComputer.lowestZTrough()+",2");
      }
      
      
      for(int i=0;i<NUM_BAD_WINDOWS;i++){
        badComputer.window();
        
        printWriter.println(badComputer.computeZMean() + "," + badComputer.computeZVariance() + "," + 
                            badComputer.computeZStandardDeviation() + "," + badComputer.highestZPeak() + "," +
                            badComputer.lowestZTrough()+",1"); 
      }
      
      
      printWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }  
    
    
    
    
    /*
     * Feature extraction for test data
     */ 
    
    
    DataPoints goodLogPointsTest = new DataPoints();
    FeatureComputer goodComputerTest = new FeatureComputer(goodLogPointsTest);
    
    
    DataPoints fairLogPointsTest = new DataPoints();
    FeatureComputer fairComputerTest = new FeatureComputer(fairLogPointsTest);
    
   
    DataPoints badLogPointsTest = new DataPoints();
    FeatureComputer badComputerTest = new FeatureComputer(badLogPointsTest);
    
    
    String goodInputFileTest = "../RSQC_Dataset/test_data/good_road_test.txt";
    dataCrawler.read(goodLogPointsTest,goodInputFileTest);
    
    String fairInputFileTest = "../RSQC_Dataset/test_data/fair_road_test.txt";
    dataCrawler.read(fairLogPointsTest,fairInputFileTest);
    
    String badInputFileTest = "../RSQC_Dataset/test_data/bad_road_test.txt";
    dataCrawler.read(badLogPointsTest,badInputFileTest);
    

    
    try {
      printWriter = new PrintWriter(new BufferedWriter(new FileWriter("../RSQC_Dataset/features/test_features.txt", true)));
      
      for(int i=0;i<NUM_GOOD_WINDOWS_TEST;i++){
        goodComputerTest.window();
        
        printWriter.println(goodComputerTest.computeZMean() + "," + goodComputerTest.computeZVariance() + "," + 
                            goodComputerTest.computeZStandardDeviation() + "," + goodComputerTest.highestZPeak() + "," +
                            goodComputerTest.lowestZTrough()+",3");
      }
      
      
      for(int i=0;i<NUM_FAIR_WINDOWS_TEST;i++){
        fairComputerTest.window();
        
        printWriter.println(fairComputerTest.computeZMean() + "," + fairComputerTest.computeZVariance() + "," + 
                            fairComputerTest.computeZStandardDeviation() + "," + fairComputerTest.highestZPeak() + "," +
                            fairComputerTest.lowestZTrough()+",2");
      }
      
      
      for(int i=0;i<NUM_BAD_WINDOWS_TEST;i++){
        badComputerTest.window();
        
        printWriter.println(badComputerTest.computeZMean() + "," + badComputerTest.computeZVariance() + "," + 
                            badComputerTest.computeZStandardDeviation() + "," + badComputerTest.highestZPeak() + "," +
                            badComputerTest.lowestZTrough()+",1"); 
      }
      
      
      printWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }  
    
  }
}