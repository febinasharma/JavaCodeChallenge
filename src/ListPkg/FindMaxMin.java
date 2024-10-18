package ListPkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindMaxMin {

	int indexValue=0, count=0;
	int avg=0;
	
	
	public static void main(String args[])
	{
	List<Object> imvList=new ArrayList<Object>(Arrays.asList(1,5,null,1,2,2,null,2,2));
	
	maxSum(imvList);
	
	minAvg(imvList);
	}

	public static void maxSum(List<Object> imvList) {
		int key=0, sum=0, tempListSum=0, count=0, index=0;
		List<Integer> tempList=new ArrayList<Integer>();
		ArrayList<Integer> maxArray=new ArrayList<Integer>();
		HashMap<Integer,List<Integer>>  map= new HashMap<Integer,List<Integer>>();
		System.out.println(imvList);

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
					map.put(key, tempList);
					System.out.println(map.get(key));
					key=key+1;
//					System.out.println("Map Content:"+map);
//					System.out.println("Key:"+key);
					for(int j=0;j<tempList.size();j++)
					{						
//						System.out.println(tempList.get(j));
						tempListSum+=tempList.get(j);
					}
//					System.out.println("tempListSum:"+tempListSum);
//					System.out.println("Sum: "+sum);
//					System.out.println("tempListSize: "+tempList.size());
//					System.out.println("count: "+count);
//					
					if(tempListSum==sum)
					{
						if(tempList.size()>count)
						{
							sum=tempListSum;
							count=tempList.size();
							index = k-1;
						}
					}
					else if(tempListSum>sum)
					{
						sum=tempListSum;
						count=tempList.size();
						index = k-1;
					}
					tempListSum=0;
					tempList.clear();
//					System.out.println("Sum: "+sum);
				}
			}
		}
		System.out.println("result : "+map.getOrDefault(0,tempList ));
		System.out.println("result : "+map);
	}


	
	public static void minAvg(List<Object> minList)
	{
//		System.out.println(minList);
	}

}
