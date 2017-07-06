// Patrick Guerrette
// CSE2100-002
// 9/7/16
// Homework 1 Birthday Paradox

import java.text.DecimalFormat;
import java.util.Random;

public class Main 
{

	
	public static void main(String[] args) 
	{
		Random rand = new Random();
		DecimalFormat df = new DecimalFormat("#.000");
		DecimalFormat pdf = new DecimalFormat("#.00000");
		int n = 5;
			for(n=5;n<=100;n+=5)
			{
				int accumulator = 1;
				int success = 0;
				while(accumulator <= 100000)
				{
					double[] numbers =  new double[(int) n];
					for(int x=0;x<n;x++)
						numbers[x] = rand.nextInt(366) + 1;
					
					CompareLoop:
					for(int y=0;y<numbers.length;y++)
					{
						for(int z=y+1;z<numbers.length;z++)
						{
							if(numbers[y] == numbers[z])
							{
								success++;
								break CompareLoop;
							}
						}	
					}
					
					accumulator++;
				}
				System.out.println(success + " successes out of a group of " + n);
				double dsuccess = (double)success;
				double probability = dsuccess/100000;
				double percent = probability * 100;
				System.out.println("The probability is " + pdf.format(probability)
				+ " and percent is " + df.format(percent) + "%");
			}
	}
}
