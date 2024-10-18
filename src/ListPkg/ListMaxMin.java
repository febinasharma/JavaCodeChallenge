package ListPkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ListMaxMin {
	int indexValue=0, count=0,sum=0,avg=0;
	
	
	public static void main(String args[])
	{
	List<Object> imvList=new ArrayList<Object>(Arrays.asList(1,5,null,null,1,2,2,null,2,2,null,3));
	
	maxSum(imvList);
	
	minAvg(imvList);
	}

	public static void maxSum(List<Object> imvList) {
		List<Integer> tempList=new ArrayList<Integer>();
		ArrayList<Integer> maxArray=new ArrayList<Integer>();
		System.out.println(imvList);
//		Iterator<Object> it=maxList.iterator();
//		while(it.hasNext())
//		{
//			System.out.println(it.next());
//			if(it.next()!=null)
//			{
//				intList.add((Integer) it.next());
//				
//			}
//		}
		int k=0;
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
					maxArray.addAll(tempList);
				}
				System.out.println(tempList);
				tempList = new ArrayList<Integer>();
			}
//			System.out.println(maxArray);
		}
		
	}


	
	public static void minAvg(List<Object> minList)
	{
//		System.out.println(minList);
	}
}
