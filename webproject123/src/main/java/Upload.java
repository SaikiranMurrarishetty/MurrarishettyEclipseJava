

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import java.util.*;
/**
 * Servlet implementation class Upload
 */
public class Upload extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	
	{
	
	  //Build the basicAWScredentials object with credentials of aws account 
	  BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials("AKIAIRFF35MKAANGP56Q", "6hjM5t0DoJcXfnjm6oW0akBsPE1M2VHF3CKGwMau");
		
		 /*
		//Get the credentials of aws account
    	AWSCredentials credentials = null;
        try {
            	credentials = new ProfileCredentialsProvider("default").getCredentials();
        	} 
        catch (Exception e)
        {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. " +
                    "Please make sure that your credentials file is at the correct " +
                    "location (C:\\Users\\Kittu\\.aws\\credentials), and is in valid format.",
                    e);
        }
		*/
		 
       //Creating aws s3 object using the credentials object and region name
        AmazonS3 s3 = AmazonS3ClientBuilder.standard()
            .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
            .withRegion("us-west-2")
            .build();

        //Create  a New bucket in s3 provide bucket name 
        String bucketName = "msk-first-bucket"+ UUID.randomUUID();
        s3.createBucket(bucketName);
        
        //You should Provide Unique Key for each object in the object 
        String key = "MyObjectKey1";

        try
        {
        	//Insert the object "Image file" in the created bucket
            s3.putObject(new PutObjectRequest(bucketName, key, new File(request.getParameter("myImage"))));
            PrintWriter pw = response.getWriter();
            pw.println("File Successfully uploaded to AWS");
            
         } 
        catch (AmazonServiceException ase) 
        {
            System.out.println("Caught an AmazonServiceException, which means your request made it "
                    + "to Amazon S3, but was rejected with an error response for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        }
        catch (AmazonClientException ace) 
        {
            System.out.println("Caught an AmazonClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with S3, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
        }
	}



}
