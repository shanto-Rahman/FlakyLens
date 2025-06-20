@Test public void test_combinedWith_noClash(){
assertThat(test.getValue(ID1)).isEqualTo(VAL1);
assertThat(test.getValue(ID2)).isEqualTo(VAL2);
assertThat(test.getIds()).containsExactlyInAnyOrder(ID1,ID2);
}