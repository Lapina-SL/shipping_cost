package ru.yandex.practicum.task;

public class Solution {

    public static double countCoast(double distance, boolean isFragile, Size size, WorkLoad load) {
        double resultCost = 0;

        if (isFragile) {
            if (distance > 30) {
                throw new ShippingCoastException("Хрупкие грузы нельзя возить на расстояние более 30 км");
            }
            resultCost += 300;
        }

        resultCost += countDistanceCost(distance);
        resultCost += size.cost;
        resultCost *= load.coefficient;

        return resultCost > 400.00 ? ceilResult(resultCost) : 400.00;
    }

    static double countDistanceCost(double distance) {
        if (distance <= 0) {
            throw new ShippingCoastException("Введено недопустимое расстояние до пункта назначения");
        }

        if (distance > 30) {
            return 300;
        } else if (distance > 10) {
            return 200;
        } else if (distance > 2) {
            return 100;
        } else {
            return 50;
        }
    }

    private static double  ceilResult(double result) {
        double r = result * 1000;
        r = Math.ceil(r);
        return r / 1000;
    }
}

enum WorkLoad {
    VERY_HIGH(1.6),
    HIGH(1.4),
    INCREASED(1.2),
    OTHER(1.0);

    float coefficient;

    WorkLoad(double coefficient) {
        this.coefficient = (float) coefficient;
    }

}

enum Size {
    BIG(200),
    SMALL(100);

    int cost;

    Size(int cost) {
        this.cost = cost;
    }
}

class ShippingCoastException extends RuntimeException {
    public ShippingCoastException(String message) {
        super(message);
    }
}