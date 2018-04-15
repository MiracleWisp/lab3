public enum FoodType {
    MEAT{

        public boolean isLiquid(){
            return false;
        }
    }, SAUCE{

        public boolean isLiquid(){
            return true;
        }
    }, SOUP{

        public boolean isLiquid(){
            return true;
        }
    }, POTATO{

        public boolean isLiquid(){
            return false;
        }
    }, CHICKEN{

        public boolean isLiquid(){
            return false;
        }
    }, FISH{

        public boolean isLiquid(){
            return false;
        }
    };
    public boolean isLiquid(){
        return false;
    }
}
