package com.icarusrises.caseyellowgateway.domain.test.model;

import java.util.List;

/**
 * Created by Dan on 24/10/2016.
 */
public class Test {

    private String testID;
    private SystemInfo systemInfo;
    private String speedTestWebsiteIdentifier;
    private List<ComparisonInfo> comparisonInfoTests;

    public Test() {
    }

    private Test(TestBuilder testBuilder) {
        this.testID = testBuilder.testID;
        this.systemInfo = testBuilder.systemInfo;
        this.speedTestWebsiteIdentifier = testBuilder.speedTestWebsiteIdentifier;
        this.comparisonInfoTests = testBuilder.comparisonInfoTests;
    }


    public String getTestID() {
        return testID;
    }

    public void setTestID(String testID) {
        this.testID = testID;
    }

    public String getSpeedTestWebsiteIdentifier() {
        return speedTestWebsiteIdentifier;
    }

    public void setSpeedTestWebsiteIdentifier(String speedTestWebsiteIdentifier) {
        this.speedTestWebsiteIdentifier = speedTestWebsiteIdentifier;
    }

    public SystemInfo getSystemInfo() {
        return systemInfo;
    }

    public void setSystemInfo(SystemInfo systemInfo) {
        this.systemInfo = systemInfo;
    }

    public List<ComparisonInfo> getComparisonInfoTests() {
        return comparisonInfoTests;
    }

    public void setComparisonInfoTests(List<ComparisonInfo> speedTests) {
        this.comparisonInfoTests = speedTests;
    }

    public void addComparisonInfo(ComparisonInfo comparisonInfo) {
        comparisonInfoTests.add(comparisonInfo);
    }

    @Override
    public String toString() {
        return "Test{" +
                "testID='" + testID + '\'' +
                ", systemInfo=" + systemInfo +
                ", speedTestWebsiteIdentifier='" + speedTestWebsiteIdentifier + '\'' +
                ", comparisonInfoTests=" + comparisonInfoTests +
                '}';
    }

    // TestBuilder Helper
    public static class TestBuilder {

        // Fields
        private String testID;
        private SystemInfo systemInfo;
        private String speedTestWebsiteIdentifier;
        private List<ComparisonInfo> comparisonInfoTests;

        public TestBuilder(String testID) {
            this.testID = testID;
        }

        public TestBuilder addSystemInfo(SystemInfo systemInfo) {
            this.systemInfo = systemInfo;
            return this;
        }

        public TestBuilder addSpeedTestWebsiteIdentifier(String speedTestWebsite) {
            this.speedTestWebsiteIdentifier = speedTestWebsite;
            return this;
        }

        public TestBuilder addComparisonInfoTests(List<ComparisonInfo> comparisonInfoTests) {
            this.comparisonInfoTests = comparisonInfoTests;
            return this;
        }

        public Test build() {
            return new Test(this);
        }
    }
}
