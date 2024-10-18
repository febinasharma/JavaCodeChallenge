
package ListPkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FindMaxMin2 {

	private static int sum=0, count=0, index=0,key=0,tempListSum=0;
	private static int minKey=0,indexMin=0,listcount=0;
	private static float tempListAvg=0,avg=0;
	private static List<Integer> tempList;
	private static HashMap<Integer,List<Integer>> map;
	private static List<Integer> tempListMin;
	
	public static void main(String args[])
	{
	List<Object> imvList=new ArrayList<Object>(Arrays.asList(1,1,5,0,null,5,1,0,1,null,5,null,1,5,0,1,4,null,null));
	
	System.out.println("MaxSum for the given list is : "+maxSum(imvList));
	System.out.println("MinAvg for the given list is : "+minAvg(imvList));
	}

	public static List<Integer> maxSum(List<Object> maxList) {
		
		tempList=new ArrayList<Integer>();
		map= new HashMap<Integer,List<Integer>>();
		System.out.println("Monitoring Window: "+maxList);
		System.out.println(maxList.size());
		for(int i=0;i<maxList.size();i++)
		{
			if(maxList.get(i)!=null)
			{
				tempList.add((Integer)maxList.get(i));
				if(maxList.size()==i+1) {
					addToMaxList();
				}
			}		
			else
			{
				addToMaxList();
			}
		}
		
		if(map.size()==0)
		{	
				return Collections.emptyList();			
		}
	
	return map.get(index);
	}
	
	private static void addToMaxList()
	{
		if(tempList.size()>0)
		{
			map.put(key, new ArrayList<Integer>(tempList));
			key=key+1;
			tempListSum=sumOfList(tempList);

			if(tempListSum==sum)
			{
				if(tempList.size()>count)
				{
					findMax(tempList,key,tempListSum);
				}
			}
			else if(tempListSum>sum)
			{
				findMax(tempList,key,tempListSum);
			}
			tempListSum=0;
			tempList.clear();			
		}
	}

	private static void findMax(List<Integer> list, int tempKey, int tempSum)
	{
		sum=tempSum;
		count=list.size();
		index = (tempKey-1);
	}
	
	private static int sumOfList(List<Integer> list)
	{
		int tempsum=0;
		for(int j=0;j<list.size();j++)
		{			
			tempsum+=list.get(j);
		}
		return tempsum;
	}
	
	public static List<Integer> minAvg(List<Object> minList)
	{
		
		tempListMin=new ArrayList<Integer>();
		map= new HashMap<Integer,List<Integer>>();
				
		for(int i=0;i<minList.size();i++)
		{
			if(minList.get(i)!=null)
			{
				tempListMin.add((Integer) minList.get(i));
				if(minList.size()==i+1) {
					addToMinList();
				}
			}		
			else
			{
				addToMinList();
				
	         }
	   }
		if(map.size()==0)
		{	
			return Collections.emptyList();			
		}
		return(map.get(indexMin));
	}
	
	private static void addToMinList()
	{
		if(tempListMin.size()>0)
		{

			map.put(minKey, new ArrayList<Integer>(tempListMin));
			minKey=minKey+1;
			listcount=sumOfList(tempListMin);
			tempListAvg=listcount/(float)tempListMin.size();
			
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
			
			listcount=0;
			tempListMin.clear();
		}
	}

}
