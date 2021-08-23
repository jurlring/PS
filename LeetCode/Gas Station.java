class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        if (n==1&&gas[0]>=cost[0])
            return 0;
        for(int i=0;i<n;i++) {
        	if (gas[i]>cost[i]) {
        		if (best(gas,cost,1,gas[i],i+1))
        			return i;
        	}
        }
        return -1;
    }
	public boolean best (int[] gas,int[] cost,int count,int tank,int i) {
        if (tank-cost[(i-1)%gas.length]<0) 
			return false;
		if (count==gas.length) {
			if (tank>0)
				return true;
			else
				return false;
		}
		
		return best(gas,cost,count+1,tank-cost[(i-1)%gas.length]+gas[i%gas.length],i+1);
	}
}
		public static void main(String[] args) {
        int [][] ans={{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		System.out.println(solution(ans).toString());
		
		//System.out.println("gos".compareTo("gz"));
    }
}