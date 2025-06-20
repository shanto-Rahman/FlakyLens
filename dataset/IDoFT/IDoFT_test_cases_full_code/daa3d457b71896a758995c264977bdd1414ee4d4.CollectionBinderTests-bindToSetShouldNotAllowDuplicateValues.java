@Test public void bindToSetShouldNotAllowDuplicateValues(){
  MockConfigurationPropertySource source=new MockConfigurationPropertySource();
  source.put("foo.items-set","a,b,c,c");
  this.sources.add(source);
  ExampleCollectionBean result=this.binder.bind("foo",ExampleCollectionBean.class).get();
  assertThat(result.getItemsSet()).hasSize(3);
  assertThat(result.getItemsSet()).containsExactly("a","b","c");
}
