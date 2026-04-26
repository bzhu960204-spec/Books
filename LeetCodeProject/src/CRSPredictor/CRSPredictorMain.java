package CRSPredictor;

import CRSPredictor.pojo.CRSHistoryDraw;
import CRSPredictor.utils.LineChart_AWT;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CRSPredictorMain {
    public static List<CRSHistoryDraw> EEPoolHistoryDraws;
    public static final int numberOfDraws = 10;

    public static LineChart_AWT numberOfCandidatesAbove481Trend() {
        return new LineChart_AWT(
                "Express Entry Invitation Trend",
                "Number of Candidates Above 481 Trend",
                "Round of Invitation",
                "Number of Candidates",
                CRSPredictorMain.addTotalCandidateNumberDataSet(new DefaultCategoryDataset(), getDrawDataAfterAllProgrammeDrawStarted())
        );
    }

    public static LineChart_AWT numberOfCandidatesAbove481DeclineSpeedTrend() {
        return new LineChart_AWT(
                "Express Entry Invitation Trend",
                "Number of Candidates Above 481 Subtracted Trend",
                "Round of Invitation",
                "Number of Candidates",
                CRSPredictorMain.speedOfDeclining(new DefaultCategoryDataset(), getDrawDataAfterAllProgrammeDrawStarted())
        );
    }

    public static LineChart_AWT totalNumberOfCandidatesDespiteDrawTrend() {
        return new LineChart_AWT(
                "Express Entry Invitation Trend",
                "Number of Candidates Despite Draw Trend",
                "Round of Invitation",
                "Number of Candidates",
                CRSPredictorMain.addTotalCandidateNumberDespiteDrawDataSet(new DefaultCategoryDataset(), getDrawDataAfterAllProgrammeDrawStarted())
        );
    }

    public static LineChart_AWT totalNumberOfCandidatesAddingSpeedDespiteDrawTrend() {
        return new LineChart_AWT(
                "Express Entry Invitation Trend",
                "Number of Candidates Added Above 481",
                "Round of Invitation",
                "Number of Candidates",
                CRSPredictorMain.speedOfAddingDespiteDrawDataSet(new DefaultCategoryDataset(), getDrawDataAfterAllProgrammeDrawStarted())
        );
    }

    public static LineChart_AWT candidatesAbove600AddingTrend() {
        return new LineChart_AWT(
                "Express Entry Invitation Trend",
                "Number of Candidates Added Above 600",
                "Round of Invitation",
                "Number of Candidates",
                CRSPredictorMain.candidatesAbove600AddingTrend(new DefaultCategoryDataset(), getDrawDataAfterAllProgrammeDrawStarted())
        );
    }

    public static LineChart_AWT candidates500_600AddingTrend() {
        return new LineChart_AWT(
                "Express Entry Invitation Trend",
                "Number of Candidates Added Above 501-600",
                "Round of Invitation",
                "Number of Candidates",
                CRSPredictorMain.candidates500_600AddingTrend(new DefaultCategoryDataset(), getDrawDataAfterAllProgrammeDrawStarted())
        );
    }

    public static LineChart_AWT candidates491_500AddingTrend() {
        return new LineChart_AWT(
                "Express Entry Invitation Trend",
                "Number of Candidates Added Above 491 - 500",
                "Round of Invitation",
                "Number of Candidates",
                CRSPredictorMain.candidates491_500AddingTrend(new DefaultCategoryDataset(), getDrawDataAfterAllProgrammeDrawStarted())
        );
    }

    public static LineChart_AWT candidates481_490AddingTrend() {
        return new LineChart_AWT(
                "Express Entry Invitation Trend",
                "Number of Candidates Added Above 481 - 490",
                "Round of Invitation",
                "Number of Candidates",
                CRSPredictorMain.candidates481_490AddingTrend(new DefaultCategoryDataset(), getDrawDataAfterAllProgrammeDrawStarted())
        );
    }


    public static double numberOfDrawLeftPredict(int averageIncrease, int averageDraw) {
        List<CRSHistoryDraw> crsHistoryDrawList = getDrawDataAfterAllProgrammeDrawStarted();
        if (averageIncrease == 0) {
            List<Integer> totalInvitedList = new ArrayList<>();
            List<Integer> speedList = new ArrayList<>();
            int totalNumberOfDraw = 0;
            for (CRSHistoryDraw crsHistoryDraw : getDrawDataAfterAllProgrammeDrawStarted()) {
                totalInvitedList.add(crsHistoryDraw.getTotalCandidateNumber() + totalNumberOfDraw);
                totalNumberOfDraw += crsHistoryDraw.getNumberOfCandidatesDraw();
            }
            int totalSpeed = 0;
            for (int i = 1; i < totalInvitedList.size(); i++) {
                speedList.add(totalInvitedList.get(i) - totalInvitedList.get(i - 1));
                totalSpeed += (totalInvitedList.get(i) - totalInvitedList.get(i - 1));
            }
            averageIncrease = totalSpeed / speedList.size();
//            System.out.println(speedList.get(speedList.size() - 1));
            System.out.println(averageIncrease);
//            System.out.println(crsHistoryDrawList.get(crsHistoryDrawList.size() - 1).getTotalCandidateNumber());
        }
        return (double) crsHistoryDrawList.get(crsHistoryDrawList.size() - 1).getTotalCandidateNumber() / (averageDraw - averageIncrease);
    }

    public static double numberOfDrawLeftPredictStrategyII(int averageDraw) {
        List<CRSHistoryDraw> crsHistoryDrawList = getDrawDataAfterAllProgrammeDrawStarted();
        int averageIncrease = 0;
        List<Integer> numberAddedAbove600 = new ArrayList<>();
        List<Integer> numberAdded501_600 = new ArrayList<>();
        List<Integer> numberAdded491_500 = new ArrayList<>();
        List<Integer> numberAdded481_490 = new ArrayList<>();
        for (int i = 1; i < crsHistoryDrawList.size(); i++) {
            CRSHistoryDraw previousDraw = crsHistoryDrawList.get(i - 1);
            int remainingPeople500_600;
            int remainingPeople491_500;
            int remainingPeople481_490;
            numberAddedAbove600.add(crsHistoryDrawList.get(i).getCandidatesDistributions().get("601-1200"));
            if (previousDraw.getNumberOfCandidatesDraw() > previousDraw.getCandidatesDistributions().get("601-1200")) {
                remainingPeople500_600 = previousDraw.getCandidatesDistributions().get("501-600") - (previousDraw.getNumberOfCandidatesDraw() - previousDraw.getCandidatesDistributions().get("601-1200"));
            } else {
                remainingPeople500_600 = previousDraw.getCandidatesDistributions().get("501-600");
            }
            remainingPeople500_600 = Math.max(remainingPeople500_600, 0);
            numberAdded501_600.add(crsHistoryDrawList.get(i).getCandidatesDistributions().get("501-600") - remainingPeople500_600);

            if (previousDraw.getNumberOfCandidatesDraw() > (previousDraw.getCandidatesDistributions().get("601-1200") + previousDraw.getCandidatesDistributions().get("501-600"))) {
                remainingPeople491_500 = previousDraw.getCandidatesDistributions().get("491-500") - (previousDraw.getNumberOfCandidatesDraw() - (previousDraw.getCandidatesDistributions().get("601-1200") + previousDraw.getCandidatesDistributions().get("501-600")));
            } else {
                remainingPeople491_500 = previousDraw.getCandidatesDistributions().get("491-500");
            }
            remainingPeople491_500 = Math.max(remainingPeople491_500, 0);
            numberAdded491_500.add(crsHistoryDrawList.get(i).getCandidatesDistributions().get("491-500") - remainingPeople491_500);


            if (previousDraw.getNumberOfCandidatesDraw() > (previousDraw.getCandidatesDistributions().get("601-1200") + previousDraw.getCandidatesDistributions().get("501-600") + previousDraw.getCandidatesDistributions().get("491-500"))) {
                remainingPeople481_490 = previousDraw.getCandidatesDistributions().get("481-490") - (previousDraw.getNumberOfCandidatesDraw() - (previousDraw.getCandidatesDistributions().get("601-1200") + previousDraw.getCandidatesDistributions().get("501-600") + previousDraw.getCandidatesDistributions().get("491-500")));
            } else {
                remainingPeople481_490 = previousDraw.getCandidatesDistributions().get("481-490");
            }
            remainingPeople481_490 = Math.max(remainingPeople481_490, 0);
            numberAdded481_490.add(crsHistoryDrawList.get(i).getCandidatesDistributions().get("481-490") - remainingPeople481_490);
        }

        int sum = 0;
        int sumSpecial = 0;
        // normal flow
        for (int i = 0; i < numberAddedAbove600.size(); i++) {
            sum += numberAdded501_600.get(i);
            sum += numberAdded481_490.get(i);
        }
        final int length = numberAddedAbove600.size();
        // special flow
        for (int i = 0; i < length; i++) {
            // 使用 switch 现在一共十轮邀请，九轮增加
            switch (i) {
                case 8:
                    continue;
                case 9:
                    continue;
            }
            sumSpecial += numberAddedAbove600.get(i);
            sumSpecial += numberAdded491_500.get(i);
        }

        averageIncrease = sum / numberAddedAbove600.size() + sumSpecial / (numberAddedAbove600.size() - 1);
        System.out.println(averageIncrease);
        return (double) crsHistoryDrawList.get(crsHistoryDrawList.size() - 1).getTotalCandidateNumber() / (averageDraw - averageIncrease);
    }

    public static void main(String[] args) {

        LineChart_AWT chart = CRSPredictorMain.numberOfCandidatesAbove481Trend();
//        LineChart_AWT chart = CRSPredictorMain.totalNumberOfCandidatesDespiteDrawTrend();
//        LineChart_AWT chart = CRSPredictorMain.totalNumberOfCandidatesAddingSpeedDespiteDrawTrend();
//        LineChart_AWT chart1 = CRSPredictorMain.numberOfCandidatesAbove481DeclineSpeedTrend();
//        LineChart_AWT chart = CRSPredictorMain.candidatesAbove600AddingTrend();
//        LineChart_AWT chart1 = CRSPredictorMain.candidates500_600AddingTrend();
//        LineChart_AWT chart2 = CRSPredictorMain.candidates491_500AddingTrend();
//        LineChart_AWT chart3 = CRSPredictorMain.candidates481_490AddingTrend();
        chart.pack();
//        chart1.pack();
//        chart2.pack();
//        chart3.pack();

//        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
//        chart1.setVisible(true);
//        chart2.setVisible(true);
//        chart3.setVisible(true);
//        System.out.println(CRSPredictorMain.numberOfDrawLeftPredict(3000, 4750));
//        System.out.println(CRSPredictorMain.numberOfDrawLeftPredict(3500, 4750));
//        System.out.println(CRSPredictorMain.numberOfDrawLeftPredict(0, 4750));
//        System.out.println(CRSPredictorMain.numberOfDrawLeftPredictStrategyII(4750));
//        System.out.println(CRSPredictorMain.numberOfDrawLeftPredict(0, 4750));
    }

    public static DefaultCategoryDataset candidatesAbove600AddingTrend(DefaultCategoryDataset dataset, List<CRSHistoryDraw> crsHistoryDrawList) {
        if (dataset == null) {
            throw new NullPointerException("Dataset cannot be null");
        }
        for (int i = 1; i < crsHistoryDrawList.size(); i++) {
            dataset.addValue(crsHistoryDrawList.get(i).getCandidatesDistributions().get("601-1200"), "number of candidates added above 600", crsHistoryDrawList.get(i).getRoundOfDraw());
        }
        return dataset;
    }

    public static DefaultCategoryDataset candidates500_600AddingTrend(DefaultCategoryDataset dataset, List<CRSHistoryDraw> crsHistoryDrawList) {
        if (dataset == null) {
            throw new NullPointerException("Dataset cannot be null");
        }
        for (int i = 1; i < crsHistoryDrawList.size(); i++) {
            CRSHistoryDraw previousDraw = crsHistoryDrawList.get(i - 1);
            int remainingPeople500_600;
//            if (previousDraw.getCutOffScore() > 500) {
            if (previousDraw.getNumberOfCandidatesDraw() > previousDraw.getCandidatesDistributions().get("601-1200")) {
                remainingPeople500_600 = previousDraw.getCandidatesDistributions().get("501-600") - (previousDraw.getNumberOfCandidatesDraw() - previousDraw.getCandidatesDistributions().get("601-1200"));
            } else {
                remainingPeople500_600 = previousDraw.getCandidatesDistributions().get("501-600");
            }
            remainingPeople500_600 = Math.max(remainingPeople500_600, 0);
//            }
            int numberOfPeopleAddedAbove500 = crsHistoryDrawList.get(i).getCandidatesDistributions().get("501-600") - remainingPeople500_600;
            dataset.addValue(numberOfPeopleAddedAbove500, "number of candidates added 501 - 600", crsHistoryDrawList.get(i).getRoundOfDraw());
        }
        return dataset;
    }

    public static DefaultCategoryDataset candidates491_500AddingTrend(DefaultCategoryDataset dataset, List<CRSHistoryDraw> crsHistoryDrawList) {
        if (dataset == null) {
            throw new NullPointerException("Dataset cannot be null");
        }
        for (int i = 1; i < crsHistoryDrawList.size(); i++) {
            CRSHistoryDraw previousDraw = crsHistoryDrawList.get(i - 1);
            int remainingPeople491_500;
//            if (previousDraw.getCutOffScore() > 500) {
            if (previousDraw.getNumberOfCandidatesDraw() > (previousDraw.getCandidatesDistributions().get("601-1200") + previousDraw.getCandidatesDistributions().get("501-600"))) {
                remainingPeople491_500 = previousDraw.getCandidatesDistributions().get("491-500") - (previousDraw.getNumberOfCandidatesDraw() - (previousDraw.getCandidatesDistributions().get("601-1200") + previousDraw.getCandidatesDistributions().get("501-600")));
            } else {
                remainingPeople491_500 = previousDraw.getCandidatesDistributions().get("491-500");
            }
            remainingPeople491_500 = Math.max(remainingPeople491_500, 0);
//            }
            int numberOfPeopleAdded491_500 = crsHistoryDrawList.get(i).getCandidatesDistributions().get("491-500") - remainingPeople491_500;
            dataset.addValue(numberOfPeopleAdded491_500, "number of candidates added 491 - 500", crsHistoryDrawList.get(i).getRoundOfDraw());
        }
        return dataset;
    }

    public static DefaultCategoryDataset candidates481_490AddingTrend(DefaultCategoryDataset dataset, List<CRSHistoryDraw> crsHistoryDrawList) {
        if (dataset == null) {
            throw new NullPointerException("Dataset cannot be null");
        }
        for (int i = 1; i < crsHistoryDrawList.size(); i++) {
            CRSHistoryDraw previousDraw = crsHistoryDrawList.get(i - 1);
            int remainingPeople481_490;
//            if (previousDraw.getCutOffScore() > 500) {
            if (previousDraw.getNumberOfCandidatesDraw() > (previousDraw.getCandidatesDistributions().get("601-1200") + previousDraw.getCandidatesDistributions().get("501-600") + previousDraw.getCandidatesDistributions().get("491-500"))) {
                remainingPeople481_490 = previousDraw.getCandidatesDistributions().get("481-490") - (previousDraw.getNumberOfCandidatesDraw() - (previousDraw.getCandidatesDistributions().get("601-1200") + previousDraw.getCandidatesDistributions().get("501-600") + previousDraw.getCandidatesDistributions().get("491-500")));
            } else {
                remainingPeople481_490 = previousDraw.getCandidatesDistributions().get("481-490");
            }
            remainingPeople481_490 = Math.max(remainingPeople481_490, 0);
//            }
            int numberOfPeopleAdded481_490 = crsHistoryDrawList.get(i).getCandidatesDistributions().get("481-490") - remainingPeople481_490;
            dataset.addValue(numberOfPeopleAdded481_490, "number of candidates added 481 - 490", crsHistoryDrawList.get(i).getRoundOfDraw());
        }
        return dataset;
    }

    public static DefaultCategoryDataset addTotalCandidateNumberDataSet(DefaultCategoryDataset dataset, List<CRSHistoryDraw> crsHistoryDrawList) {
        if (dataset == null) {
            throw new NullPointerException("Dataset cannot be null");
        }
        for (CRSHistoryDraw crsHistoryDraw : crsHistoryDrawList) {
            dataset.addValue(crsHistoryDraw.getTotalCandidateNumber(), "total number above 481", crsHistoryDraw.getRoundOfDraw());
        }
        return dataset;
    }

    public static DefaultCategoryDataset speedOfDeclining(DefaultCategoryDataset dataset, List<CRSHistoryDraw> crsHistoryDrawList) {
        if (dataset == null) {
            throw new NullPointerException("Dataset cannot be null");
        }
        for (int i = 1; i < crsHistoryDrawList.size(); i++) {
            int decline = crsHistoryDrawList.get(i - 1).getTotalCandidateNumber() - crsHistoryDrawList.get(i).getTotalCandidateNumber();
            dataset.addValue(decline, "decline Speed", crsHistoryDrawList.get(i).getRoundOfDraw());
        }
        return dataset;
    }

    public static DefaultCategoryDataset addTotalCandidateNumberDespiteDrawDataSet(DefaultCategoryDataset dataset, List<CRSHistoryDraw> crsHistoryDrawList) {
        if (dataset == null) {
            throw new NullPointerException("Dataset cannot be null");
        }
        int totalNumberOfDraw = 0;
        for (int i = 0; i < crsHistoryDrawList.size(); i++) {
            dataset.addValue(crsHistoryDrawList.get(i).getTotalCandidateNumber() + totalNumberOfDraw, "total number of candidates despite draw", crsHistoryDrawList.get(i).getRoundOfDraw());
            totalNumberOfDraw += crsHistoryDrawList.get(i).getNumberOfCandidatesDraw();
        }
        return dataset;
    }

    public static DefaultCategoryDataset speedOfAddingDespiteDrawDataSet(DefaultCategoryDataset dataset, List<CRSHistoryDraw> crsHistoryDrawList) {
        if (dataset == null) {
            throw new NullPointerException("Dataset cannot be null");
        }
        List<Integer> totalInvitedList = new ArrayList<>();
        int totalNumberOfDraw = 0;
        for (CRSHistoryDraw crsHistoryDraw : crsHistoryDrawList) {
            totalInvitedList.add(crsHistoryDraw.getTotalCandidateNumber() + totalNumberOfDraw);
            totalNumberOfDraw += crsHistoryDraw.getNumberOfCandidatesDraw();
        }
        for (int i = 1; i < totalInvitedList.size(); i++) {
            dataset.addValue(totalInvitedList.get(i) - totalInvitedList.get(i - 1), "speed of adding trend", crsHistoryDrawList.get(i).getRoundOfDraw());
        }
        return dataset;
    }

    public static List<CRSHistoryDraw> getDrawDataAfterAllProgrammeDrawStarted() {
        List<CRSHistoryDraw> crsHistoryDrawList = new ArrayList<>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            crsHistoryDrawList = new ArrayList<>() {{
                add(new CRSHistoryDraw(sdf.parse("2022-07-06"), 1500, new HashMap<>() {{
                    put("601-1200", 669);
                    put("501-600", 8773);
                    put("491-500", 4670);
                    put("481-490", 8227);
                }}, 557, "226"));
                add(new CRSHistoryDraw(sdf.parse("2022-07-20"), 1750, new HashMap<>() {{
                    put("601-1200", 580);
                    put("501-600", 9101);
                    put("491-500", 5091);
                    put("481-490", 8857);
                }}, 542, "227"));
                add(new CRSHistoryDraw(sdf.parse("2022-08-03"), 2000, new HashMap<>() {{
                    put("601-1200", 640);
                    put("501-600", 8975);
                    put("491-500", 5343);
                    put("481-490", 9044);
                }}, 533, "228"));
                add(new CRSHistoryDraw(sdf.parse("2022-08-17"), 2250, new HashMap<>() {{
                    put("601-1200", 538);
                    put("501-600", 8221);
                    put("491-500", 5435);
                    put("481-490", 9129);
                }}, 525, "229"));
                add(new CRSHistoryDraw(sdf.parse("2022-08-31"), 2750, new HashMap<>() {{
                    put("601-1200", 466);
                    put("501-600", 7224);
                    put("491-500", 5554);
                    put("481-490", 9242);
                }}, 516, "230"));
                add(new CRSHistoryDraw(sdf.parse("2022-09-14"), 3250, new HashMap<>() {{
                    put("601-1200", 408);
                    put("501-600", 6228);
                    put("491-500", 5845);
                    put("481-490", 9505);
                }}, 510, "231"));
                add(new CRSHistoryDraw(sdf.parse("2022-09-28"), 3750, new HashMap<>() {{
                    put("601-1200", 479);
                    put("501-600", 4411);
                    put("491-500", 5985);
                    put("481-490", 9572);
                }}, 504, "232"));
                add(new CRSHistoryDraw(sdf.parse("2022-10-12"), 4250, new HashMap<>() {{
                    put("601-1200", 601);
                    put("501-600", 2785);
                    put("491-500", 6384);
                    put("481-490", 9784);
                }}, 500, "233"));
                add(new CRSHistoryDraw(sdf.parse("2022-10-26"), 4750, new HashMap<>() {{
                    put("601-1200", 762);
                    put("501-600", 937);
                    put("491-500", 6226);
                    put("481-490", 9956);
                }}, 496, "234"));
                add(new CRSHistoryDraw(sdf.parse("2022-11-09"), 4750, new HashMap<>() {{
                    put("601-1200", 958);
                    put("501-600", 1206);
                    put("491-500", 4366);
                    put("481-490", 10270);
                }}, 494, "235"));
                add(new CRSHistoryDraw(sdf.parse("2022-11-23"), 4750, new HashMap<>() {{
                    put("601-1200", 876);
                    put("501-600", 1227);
                    put("491-500", 3031);
                    put("481-490", 10517);
                }}, 491, "236"));
                add(new CRSHistoryDraw(sdf.parse("2023-01-12"), 5500, new HashMap<>() {{
                    put("601-1200", 2995);
                    put("501-600", 3897);
                    put("491-500", 3141);
                    put("481-490", 11783);
                }}, 507, "237"));
                add(new CRSHistoryDraw(sdf.parse("2023-01-18"), 5500, new HashMap<>() {{
                    put("601-1200", 614);
                    put("501-600", 1918);
                    put("491-500", 3384);
                    put("481-490", 11848);
                }}, 507, "238"));
            }};
        } catch (Exception e) {
            e.printStackTrace();
        }
        return crsHistoryDrawList;
    }
}
