package ListPkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindMaxMin3 {

	int indexValue=0;
	static float tempListAvg=0,avg=0;
	static int key=0, minKey=0;
	static int sum=0, count=0, index=0,tempListSum=0, minCount=0,indexMin=0, minSum=0;
	
	
	public static void main(String args[])
	{
	List<Object> imvList=new ArrayList<Object>(Arrays.asList(1,7,5,null,null,1,2,2,null,2,1,2,null,2,2,1,0,null,7,6,8));
	
	System.out.println("MaxSum for the given list is : "+maxSum(imvList));
	
	minAvg(imvList);
	}

	public static List<Integer> maxSum(List<Object> imvList) {

		List<Integer> tempList=new ArrayList<Integer>();
		HashMap<Integer,List<Integer>>  map= new HashMap<Integer,List<Integer>>();
		System.out.println(imvList);
		
		for(Object arr:imvList)
		{
			if(arr!=null)
			{
				tempList.add((Integer) arr);
			}		
			else
			{
				if(tempList.size()>0)
				{

					map.put(key, new ArrayList<Integer>(tempList));
					key=key+1;
					listSum(tempList);

					if(tempListSum==sum)
					{
						if(tempList.size()>count)
						{
							findMax(tempList);
						}
					}
					else if(tempListSum>sum)
					{
						findMax(tempList);
					}
    				tempListSum=0;
					tempList.clear();
					
				}
			}
		}
		if(tempList.size()>0)
		{
			map.put(key, new ArrayList<Integer>(tempList));
			listSum(tempList);
			if(tempListSum>sum)
			{
				findMax(tempList);
				index = key;
			}
		}
	
	return map.get(index);
	}

	public static void findMax(List<Integer> list)
	{
		sum=tempListSum;
		count=list.size();
		index = (key-1);
	}

	public static void listSum(List<Integer> list)
	{
		for(int j=0;j<list.size();j++)
		{			
			tempListSum+=list.get(j);
		}
	}
	
	public static int listAvg(List<Integer> list)
	{
//		for(int j=0;j<list.size();j++)
//		{			
//			tempListSum+=list.get(j);
//		}
		return(tempListSum/list.size());
		
	}
	
	public static void minAvg(List<Object> minList)
	{
		List<Integer> tempListMin=new ArrayList<Integer>();
		HashMap<Integer,List<Integer>>  map= new HashMap<Integer,List<Integer>>();
		System.out.println(minList);
		
		for(Object arr:minList)
		{
			if(arr!=null)
			{
				tempListMin.add((Integer) arr);
			}		
			else
			{
				if(tempListMin.size()>0)
				{

					map.put(minKey, new ArrayList<Integer>(tempListMin));
					minKey=minKey+1;
					for(int j=0;j<tempListMin.size();j++)
					{			
						tempListSum+=tempListMin.get(j);
					}
					System.out.println("TempListSum: "+tempListSum);
					tempListAvg=tempListSum/(float)tempListMin.size();  // calculate average
					System.out.println("tempListAvg -Avg: "+tempListAvg);
					if(tempListSum==minSum)
					{
						if(tempListMin.size()>minCount)
						{
							minSum=tempListSum;
							minCount=tempListMin.size();
							indexMin = (minKey-1);
						}
					}
					else if(tempListSum>minSum)
					{
						minSum=tempListSum;
						minCount=tempListMin.size();
						indexMin = (minKey-1);
					}
					if(map.size()==1)
					{
						avg=tempListAvg;
						System.out.println("Average1:"+avg);
						minCount=tempListMin.size();
						indexMin=map.size()-1;
						System.out.println("Index1:"+indexMin);
						System.out.println("MapSize:"+map.size());
					}
					else if(tempListAvg==avg)
					{
						if(tempListMin.size()>minCount)
						{
							avg=tempListAvg;
							System.out.println("Average2:"+avg);
							minCount=tempListMin.size();
							indexMin=map.size()-1;
							System.out.println("Index2:"+indexMin);
						}
					}
					else if(tempListAvg<avg)
					{
						avg=tempListAvg;
						System.out.println("Average3:"+avg);
						minCount=tempListMin.size();
						indexMin=map.size()-1;
						System.out.println("Index3:"+indexMin);
						System.out.println("MapSize3:"+map.size());
					}
					
					tempListSum=0;
					tempListMin.clear();
				}
	         }
	   }
		if(tempListMin.size()>0)
		{
			if(tempListAvg<avg)
			{
				avg=tempListAvg;
				System.out.println("Average4:"+avg);
				minCount=tempListMin.size();
				indexMin=map.size()-1;
				System.out.println("Index4:"+indexMin);
			}
		}
		System.out.println("result : "+map.get(indexMin));
	}

}
