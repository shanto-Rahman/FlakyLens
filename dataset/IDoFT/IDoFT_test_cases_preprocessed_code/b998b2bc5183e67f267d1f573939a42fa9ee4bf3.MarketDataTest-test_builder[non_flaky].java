@Test public void test_builder(){
assertThat(test.getValuationDate()).isEqualTo(VAL_DATE);
assertThat(test.getValues().get(ID1)).isEqualTo("123");
assertThat(test.getValues().get(ID2)).isEqualTo("124");
assertThat(test.getIds()).containsExactlyInAnyOrder(ID1,ID2,ID3);
assertThat(test.getTimeSeries().get(ID4)).isEqualTo(TIME_SERIES);
}