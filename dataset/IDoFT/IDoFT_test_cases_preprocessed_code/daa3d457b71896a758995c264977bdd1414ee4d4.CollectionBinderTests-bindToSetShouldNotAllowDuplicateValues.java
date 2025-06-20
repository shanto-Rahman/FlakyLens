@Test public void bindToSetShouldNotAllowDuplicateValues(){
assertThat(result.getItemsSet()).hasSize(3);//IT
assertThat(result.getItemsSet()).containsExactly("a","b","c");//IT
}