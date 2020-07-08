import org.junit.Test;

import static org.junit.Assert.*;

public class TrackingServiceTest {

    TrackingService ts = new TrackingService();

    @Test
    public void testAddCalories_add10_resultGetTotal10() {
        ts.addCalories(10);

        assertEquals(10, ts.getTotal());
    }

    @Test(expected = NumberFormatException.class)
    public void testAddCalories_addNegativeNumber_resultGetTotal10() {
        ts.addCalories(-10);
    }

    @Test
    public void testAddCalories_add10AndAdd25_resultTotal35() {
        ts.addCalories(10);
        ts.addCalories(25);

        assertEquals(35, ts.getTotal());
    }

    @Test
    public void testAddCalories_add10AndAdd25And2_resultEqualsListGetIndexFrom1To3WithExpected() {
        ts.addCalories(10);

        assertEquals(1, ts.getHistory().get(0).getId());
        assertEquals(10, ts.getHistory().get(0).getAmount());
        assertEquals("add", ts.getHistory().get(0).getOperation());
        assertEquals(10, ts.getHistory().get(0).getTotal());

        ts.addCalories(25);

        assertEquals(2, ts.getHistory().get(1).getId());
        assertEquals(25, ts.getHistory().get(1).getAmount());
        assertEquals("add", ts.getHistory().get(1).getOperation());
        assertEquals(35, ts.getHistory().get(1).getTotal());

        ts.addCalories(2);

        assertEquals(3, ts.getHistory().get(2).getId());
        assertEquals(2, ts.getHistory().get(2).getAmount());
        assertEquals("add", ts.getHistory().get(2).getOperation());
        assertEquals(37, ts.getHistory().get(2).getTotal());
    }

    @Test
    public void testAddCalories_add100Elt_resultListSize100AndLastId100() {
        int iterationNumber = 100;

        for (int i = 0; i < iterationNumber; i++)
            ts.addCalories(i);

        int size = ts.getHistory().size();
        assertEquals(iterationNumber, size);
        assertEquals(iterationNumber, ts.getHistory().get(size - 1).getId());
    }

    @Test(expected = NumberFormatException.class)
    public void testRemoveCalories_enterNegativeNumber_resultThrowException() {
        ts.removeCalories(-10);
    }

    @Test
    public void testActionIdRemoveAndAdd_add100CaloriesAndRemove20_resultTotal80() {
        ts.addCalories(100);
        ts.removeCalories(20);

        assertEquals(80, ts.getTotal());
    }

    @Test
    public void testActionIdRemoveAndAdd_add100CaloriesAndRemove120_resultTotal0() {
        ts.addCalories(100);
        ts.removeCalories(120);

        assertEquals(0, ts.getTotal());
    }

    @Test
    public void testActionIdRemoveAndAdd_add5Operations_resultHistoryItemEqualsExpected() {
        ts.addCalories(50);

        assertEquals(1, ts.getHistory().get(0).getId());
        assertEquals(50, ts.getHistory().get(0).getAmount());
        assertEquals("add", ts.getHistory().get(0).getOperation());
        assertEquals(50, ts.getHistory().get(0).getTotal());

        ts.removeCalories(10);

        assertEquals(2, ts.getHistory().get(1).getId());
        assertEquals(10, ts.getHistory().get(1).getAmount());
        assertEquals("remove", ts.getHistory().get(1).getOperation());
        assertEquals(40, ts.getHistory().get(1).getTotal());

        ts.addCalories(25);

        assertEquals(3, ts.getHistory().get(2).getId());
        assertEquals(25, ts.getHistory().get(2).getAmount());
        assertEquals("add", ts.getHistory().get(2).getOperation());
        assertEquals(65, ts.getHistory().get(2).getTotal());

        ts.removeCalories(50);

        assertEquals(4, ts.getHistory().get(3).getId());
        assertEquals(50, ts.getHistory().get(3).getAmount());
        assertEquals("remove", ts.getHistory().get(3).getOperation());
        assertEquals(15, ts.getHistory().get(3).getTotal());

        ts.addCalories(25);

        assertEquals(5, ts.getHistory().get(4).getId());
        assertEquals(25, ts.getHistory().get(4).getAmount());
        assertEquals("add", ts.getHistory().get(4).getOperation());
        assertEquals(40, ts.getHistory().get(4).getTotal());
    }

    @Test
    public void testCalculation_calculateAddAndRemove() {
        //operation name                id
        ts.addCalories(10);     //1
        ts.removeCalories(60);  //2
        ts.addCalories(50);     //3
        ts.removeCalories(12);  //4
        ts.addCalories(27);     //5
        ts.removeCalories(10);  //6
        ts.addCalories(100);    //7

        assertEquals("id_1", 10, ts.getHistory().get(0).getTotal());
        assertEquals("id_2", 0, ts.getHistory().get(1).getTotal());
        assertEquals("id_3", 50, ts.getHistory().get(2).getTotal());
        assertEquals("id_4", 38, ts.getHistory().get(3).getTotal());
        assertEquals("id_5", 65, ts.getHistory().get(4).getTotal());
        assertEquals("id_6", 55, ts.getHistory().get(5).getTotal());
        assertEquals("id_7", 155, ts.getHistory().get(6).getTotal());
    }

    @Test
    public void testActionIdRemoveAndAdd_add100EltAndRemove50Elt_resultListSize150AndLastId150() {
        int iterationNumberAdd = 100;
        int iterationNumberRemove = 50;

        for (int i = 0; i < iterationNumberAdd; i++)
            ts.addCalories(i);

        for (int i = 0; i < iterationNumberRemove; i++)
            ts.removeCalories(i);

        int size = ts.getHistory().size();

        assertEquals(iterationNumberAdd + iterationNumberRemove, size);
        assertEquals(iterationNumberAdd + iterationNumberRemove, ts.getHistory().get(size - 1).getId());
    }

    @Test
    public void testIsGoalMe_goal1000Total900_resultFalse() {
        ts.setGoal(1000);
        ts.addCalories(900);

        assertFalse(ts.isGoalMeet());
    }

    @Test
    public void testIsgoalMe_goal1000Total1900_resultTrue() {
        ts.setGoal(1000);
        ts.addCalories(1900);

        assertTrue(ts.isGoalMeet());
    }

    @Test
    public void testIsgoalMe_goal1000Total1000_resultTrue() {
        ts.setGoal(1000);
        ts.addCalories(1000);

        assertTrue(ts.isGoalMeet());
    }
}
