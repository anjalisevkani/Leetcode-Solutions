class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n=bills.length;
        int i;
        int five=0;
        int ten=0;
        for(i=0;i<n;i++){
            int money=bills[i];
            if(money==5){
                five++;
            }else if(money==10){
                if(five==0){
                    return false;
                }
                ten++;
                five--;
            }else if(money==20){
                if(ten>0){
                    ten--;
                    if(five==0){
                        return false;
                    }
                    five--;
                }else{
                    if(five<3){
                        return false;
                    }
                    five=five-3;
                }
            }
        }
        return true;
    }
}