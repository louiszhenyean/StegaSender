# StegaSender
Data Compression and Data Hiding using Steganography for MySQL query and forward to a HDFS storage.  

# How this works?
1. User's input for .wav file, db name & query, HDFS destination IP & directory.    
2. The application first compress the data retrieved from MySQL to binary string.  
3. The binary string is then hidden into the .wav file that is uploaded by the user.  
4. The stega-file (.wav file with hidden data) is then forwarded to HDFS.  

# Usage
Run this Java Web Application on a RDBMS  

# Requirements
- TomCat, Java and MySQL is installed on the running machine  
- Input .wav file is smaller than 64 MB  
- Database Query has to be smaller than 64MB  
