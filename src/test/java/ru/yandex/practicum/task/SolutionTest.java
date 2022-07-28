package ru.yandex.practicum.task;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static ru.yandex.practicum.task.Solution.countCoast;

public class SolutionTest {
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void shouldThrowExceptionIfDistanceIncorrect() {
        exceptionRule.expect(ShippingCoastException.class);
        exceptionRule.expectMessage("Введено недопустимое расстояние до пункта назначения");
        countCoast(-1, false, Size.BIG, WorkLoad.OTHER);

        exceptionRule.expect(ShippingCoastException.class);
        exceptionRule.expectMessage("Введено недопустимое расстояние до пункта назначения");
        countCoast(0, false, Size.BIG, WorkLoad.OTHER);
    }

    @Test
    public void shouldEqualsCountCost() {
        assertEquals(550,countCoast(1, true, Size.BIG, WorkLoad.OTHER),  0.001);
        assertEquals(400,countCoast(1, false, Size.SMALL, WorkLoad.OTHER), 0.001);
        assertEquals(540, countCoast(2, true, Size.SMALL, WorkLoad.INCREASED),0.001);
        assertEquals(400,countCoast(2, false, Size.BIG, WorkLoad.INCREASED), 0.001);
        assertEquals(840,countCoast(9, true, Size.BIG, WorkLoad.HIGH), 0.001);
        assertEquals(400,countCoast(9, false, Size.SMALL, WorkLoad.HIGH), 0.001);
        assertEquals(800,countCoast(10, true, Size.SMALL, WorkLoad.VERY_HIGH), 0.001);
        assertEquals(480,countCoast(10, false, Size.BIG, WorkLoad.VERY_HIGH), 0.001);
        assertEquals(700,countCoast(20, true, Size.BIG, WorkLoad.OTHER), 0.001);
        assertEquals(400,countCoast(20, false, Size.SMALL, WorkLoad.OTHER), 0.001);
        assertEquals(840,countCoast(30, true, Size.BIG, WorkLoad.INCREASED), 0.001);
        assertEquals(400,countCoast(30, false, Size.SMALL, WorkLoad.INCREASED), 0.001);
        assertEquals(640,countCoast(40, false, Size.SMALL, WorkLoad.VERY_HIGH), 0.001);
    }

    @Test
    public void shouldThrowExceptionWhenFragileDistanceBiggest30() {
        exceptionRule.expect(ShippingCoastException.class);
        exceptionRule.expectMessage("Хрупкие грузы нельзя возить на расстояние более 30 км");
       countCoast(40, true, Size.BIG, WorkLoad.HIGH);
    }
}
