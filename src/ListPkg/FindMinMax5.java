package ListPkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FindMinMax5 {

	static int key=0;
	static int sum=0, count=0, index=0,tempListSum=0;
	
	
	public static void main(String args[])
	{
	List<Object> imvList=new ArrayList<Object>(Arrays.asList(1,5,null, 1,2,2,null,3,null,1,5,0));
	
	System.out.println("MaxSum for the given list is : "+maxSum(imvList));
	
	System.out.println("MinAvg for the given list is : "+minAvg(imvList));
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
		if(map.size()==0)
		{
			
				return Collections.emptyList();
			
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
	
	public static List<Integer> minAvg(List<Object> minList)
	{
		
		int  minKey=0,indexMin=0;
		float tempListAvg=0,avg=0;
		List<Integer> tempListMin=new ArrayList<Integer>();
		HashMap<Integer,List<Integer>> map= new HashMap<Integer,List<Integer>>();

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
					listSum(tempListMin);
					tempListAvg=tempListSum/(float)tempListMin.size(); 
					
					if(map.size()==1)
					{
						avg=tempListAvg;
						indexMin=map.size()-1;
					}
					else if(tempListAvg<avg)
					{
						avg=tempListAvg;
						indexMin=map.size()-1;
					}
					else
					{
						return Collections.emptyList();
					}
					
					tempListSum=0;
					tempListMin.clear();
				}
	         }
	   }
		if(tempListMin.size()>0)
		{
			map.put(minKey, new ArrayList<Integer>(tempListMin));
			listSum(tempListMin);
			tempListAvg=tempListSum/(float)tempListMin.size();
			if(tempListAvg<avg)
			{
				avg=tempListAvg;
				indexMin=map.size()-1;
			}
		}
		
		if(map.size()==0)
		{	
				return Collections.emptyList();			
		}
		return(map.get(indexMin));
	}

}
