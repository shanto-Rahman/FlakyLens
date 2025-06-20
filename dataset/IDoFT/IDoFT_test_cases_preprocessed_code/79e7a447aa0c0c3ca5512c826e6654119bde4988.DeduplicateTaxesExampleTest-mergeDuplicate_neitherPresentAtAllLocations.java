@Test public void mergeDuplicate_neitherPresentAtAllLocations(){
assertThat(result.getPresentAtAllLocations()).isFalse();
assertThat(result.getPresentAtLocationIds()).containsExactly("L1","L2","L3");
assertThat(result.getAbsentAtLocationIds()).isNullOrEmpty();
}