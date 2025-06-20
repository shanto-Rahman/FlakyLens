@Test public void testToString(){
assertThat(statistics.toString(),is("dubbo://10.20.153.10"));
Assert.assertThat(statisticsWithDetailInfo.getServer(),equalTo(statistics.getServer()));
Assert.assertThat(statisticsWithDetailInfo.getService(),equalTo(statistics.getService()));
Assert.assertThat(statisticsWithDetailInfo.getMethod(),equalTo(statistics.getMethod()));
Assert.assertThat(statisticsWithDetailInfo.getGroup(),equalTo(statistics.getGroup()));
Assert.assertThat(statisticsWithDetailInfo,not(equalTo(statistics)));
}