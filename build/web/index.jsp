<form name="upload_file" method="post" action="upload_file" enctype="multipart/form-data">
        
    <h1>Data Compress & Data Hiding!!</h1>

    <h3>1. Upload the audio file where the data will be hidden into:</h3>
    
    &emsp;&emsp;&emsp;&emsp;Select .wav audio file: <input type="file" name="audio_file" accept=".wav,audio/*">
        <br><br>
        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; 
        <input type="submit" value="Upload File"/>
        <br><br>
</form>

<form name="get_input" method="post" action="Input_Servlet">
        <h3>2. Enter your Database Name:</h3>
        &emsp;&emsp;&emsp;&emsp;Database Name: <input type="text" name="db_name" placeholder="something">
        <br><br><br>
        
        <h3>3. Enter your Database Query:</h3>
        &emsp;&emsp;&emsp;&emsp;Database Query: <input type="text" name="db_query" placeholder="select * from emp;">
        <br><br><br>

        <h3>4. Enter destination HDFS IP Address:</h3>
        &emsp;&emsp;&emsp;&emsp;HDFS IP Address: <input type="text" name="hdfs_ip" placeholder="192.168.113.129">
        <br><br><br>

        <h3>5. Enter destination HDFS Directory:</h3>
        &emsp;&emsp;&emsp;&emsp;HDFS Directory: <input type="text" name="hdfs_dir" placeholder="/">
    
    <br><br><br><br>
    
    <input type="submit" value="Ingest!!"/>
    
</form>
