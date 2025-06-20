/** 
 * @see #142
 */
@Test void rendersMultipleCuries() throws Exception {
  CollectionModel<Object> resources=CollectionModel.of(Collections.emptySet());
  resources.add(Link.of("foo","myrel"));
  CurieProvider provider=new DefaultCurieProvider("default",UriTemplate.of("/doc{?rel}")){
    @Override public Collection<? extends Object> getCurieInformation(    Links links){
      return Arrays.asList(new Curie("foo","bar"),new Curie("bar","foo"));
    }
  }
;
  assertThat(getCuriedObjectMapper(provider).writeValueAsString(resources)).isEqualTo(MULTIPLE_CURIES_DOCUMENT);
}
