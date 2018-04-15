public enum FoodType {
    MEAT{

        boolean isLiquid  = false;
    }, SAUCE{

        boolean isLiquid  = true;
    }, SOUP{

        boolean isLiquid  = true;
    }, POTATO{

        boolean isLiquid  = false;
    }, CHICKEN{

        boolean isLiquid  = false;
    }, FISH{

        boolean isLiquid  = false;
    };

    boolean isLiquid;

}
