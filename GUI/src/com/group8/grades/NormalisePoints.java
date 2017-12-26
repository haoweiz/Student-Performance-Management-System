package com.group8.grades;

public final class NormalisePoints {

	
	public  double[] normalisePoints(double scores[][]) 
	{
		   if (scores == null)   //null input
				   return null; 
		   
		   double total = 0.0; //sum of total in each row
 		   int rows = scores.length;
		   int cols = 3; //Professionalism, Meeting Participation,Work Evaluation - 3 metrics
		   double res[] = new double[rows]; //Store result sum across each row
		   double finalscore[] = new double[rows]; //For storing the calculated value
		   
		   for ( int i=0;i<rows;i++)  //Checks the input length for cols
		   {   if(scores[i].length<3 || scores[i].length>3)
				   return (new double[] {-1});   
		   }
		   
		   for (int i =0;i<rows;i++)
		   { for(int j =0;j<cols;j++)
				   { 
			   			if(scores[i][j]>5 || scores[i][j]<0)
			   				return (new double[] {-1});
			   			else
			   				res[i] += scores[i][j];  //calculates the sum 
			          //System.out.println(res[i]);
				   }
		   total += res[i];
		   //System.out.println(total);
		   
		   }
			 
		  for (int i=0;i<res.length;i++)
		  {
			  finalscore[i] =  (res[i])/total;    //normalize
			  finalscore[i] = Math.round(finalscore[i] * 100)/100.0;  //round off to two digits
		  }
		return finalscore;
	}

	/*public static void main(String args[])
	{
		double[] res = new double[3];
		double scores[][] = new double[][] {{4.5,4.5,4.5},{4.5,4.5,4.5}};
		res = normalisePoints(scores);
		System.out.println("Final Scores:");
	    for(int i =0;i<res.length;i++)
	    {
	    	System.out.println(i+1 + "--->" + res[i]);
	    	//System.out.println(i+1 + "--->" + (Math.round(res[i] * 100)/100.0));
	    }
	}*/
}
