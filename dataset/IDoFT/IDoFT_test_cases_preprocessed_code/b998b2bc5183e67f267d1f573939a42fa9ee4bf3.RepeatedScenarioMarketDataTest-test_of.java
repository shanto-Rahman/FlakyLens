@Test public void test_of(){
assertThat(test.getScenarioCount()).isEqualTo(2);
assertThat(test.getUnderlying()).isEqualTo(BASE_DATA);
assertThat(test.getValuationDate()).isEqualTo(MarketDataBox.ofSingleValue(VAL_DATE));
assertThat(test.containsValue(ID1)).isEqualTo(true);
assertThat(test.containsValue(ID2)).isEqualTo(true);
assertThat(test.containsValue(ID3)).isEqualTo(false);
assertThat(test.getValue(ID1)).isEqualTo(MarketDataBox.ofSingleValue(VAL1));
assertThat(test.getValue(ID2)).isEqualTo(MarketDataBox.ofSingleValue(VAL2));
assertThat(test.findValue(ID1)).isEqualTo(Optional.of(MarketDataBox.ofSingleValue(VAL1)));
assertThat(test.findValue(ID2)).isEqualTo(Optional.of(MarketDataBox.ofSingleValue(VAL2)));
assertThat(test.findValue(ID3)).isEqualTo(Optional.empty());
assertThat(test.getIds()).containsExactly(ID1,ID2);
assertThat(test.findIds(ID1.getMarketDataName())).isEqualTo(ImmutableSet.of(ID1));
assertThat(test.getTimeSeries(ID4)).isEqualTo(TIME_SERIES);
}