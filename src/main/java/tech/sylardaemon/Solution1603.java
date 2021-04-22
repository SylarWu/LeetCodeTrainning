package tech.sylardaemon;

public class Solution1603 {
    public class ParkingSystem {
        int bigMax;
        int big;
        int mediumMax;
        int medium;
        int smallMax;
        int small;

        public ParkingSystem(int big, int medium, int small) {
            this.bigMax = big;
            this.big = 0;
            this.mediumMax = medium;
            this.medium = 0;
            this.smallMax = small;
            this.small = 0;
        }

        public boolean addCar(int carType) {
            switch(carType){
                case 1:
                    if (this.big >= this.bigMax){
                        return false;
                    }else{
                        ++this.big;
                        return true;
                    }
                case 2:
                    if (this.medium >= this.mediumMax){
                        return false;
                    }else{
                        ++this.medium;
                        return true;
                    }
                case 3:
                    if (this.small >= this.smallMax){
                        return false;
                    }else{
                        ++this.small;
                        return true;
                    }
                default:
                    return false;
            }
        }
    }
}
