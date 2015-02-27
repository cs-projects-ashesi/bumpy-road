     ***************************************************************************************
     *	Project Title: Classification Of Road Surface Quality Using Android Mobile Devices *
     *	Author:        Francis Delali Vorgbe						   *
     *	Supervisor:    Dr. G. Ayorkor Korsah						   *
     *						   					   *
     *  Ashesi University College                                                          *		                                                   
     ***************************************************************************************

This study explores the use of an Android-based mobile application to detect and report
the surface quality of roads. A logistic regression machine learning algorithm is used to 
train a road surface classifier based on the accelerometer readings collected.

*********************************************************************************************************

This Disk contains the following:
# Project Writeup
# RSQC_Data.apk - Android installation file for data collection application
# RSQC_Dataset
# Java Programs for feature extraction
# Octave programs for linear regression implementation


*********************************************************************************************************

The project writeup is a .pdf document detailing the following:

# Introduction/Background
# Related Literature
# Methodology
# Experimentation and Testing
# Conclusion/Findings

*********************************************************************************************************

How to install and use RSQC_Data.apk:

1. Copy apk file to android powered device
2. Locate apk file on device install
3. To run, select launch icon from list of installed applications

*********************************************************************************************************

The RSQC_Dataset folder contains data collected using accelerometer and GPS sensors. Each line, corresponding
to one data segment, is organised as follows:

	<timestamp, 3-axes acceleration, 3-axes linear acceleration, GPS coordinates>


The folder contains the following:

RSQC_Dataset/
	/dataset —- contains the complete dataset collected throughout the study

	/train_data —- contains data used to train the classification algorithm

	/test_data — contains data used to test the classification algorithm

*********************************************************************************************************

The following java classes for feature extraction are included in the folder /feature_extraction_programme

# DataCrawler.java
# DataPoints.java
# FeatureComputer.java
# FeatureExtraction.java

To run feature extraction do the following:

2. Open a Java IDE and import the class FeatureExtraction.java
3. Compile and run the program 
4. Text files containing the extracted features will be created and saved in the directory 
   /RSQC_Dataset/features

*********************************************************************************************************

The following octave scripts are included in the folder /linear_regression_scripts

# costFunction.m
# linearRegression.m
# sigmoid.m

To run linear regression follow these steps:

1. Edit linearRegression.m to include appropriate training and test feature sets
2. Open GNU octave and load linearRegression.m
3. Run linearRegression.m

Note: linearRegression.m is a binary classifier. As such to test multi class classification edit FeatureExtraction.java 
and specify appropriate classes by grouping two classes into one and classifying against remaining class

