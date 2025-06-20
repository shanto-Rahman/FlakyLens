/** 
 * @see #1216
 */
@Test void testAllIanaLinkRelationsHaveStringConstant(){
  Set<String> linkRelations=Arrays.stream(IanaLinkRelations.class.getDeclaredFields()).filter(ReflectionUtils::isPublicStaticFinal).filter(field -> LinkRelation.class.equals(field.getType())).map(it -> ReflectionUtils.getField(it,null)).filter(Objects::nonNull).map(LinkRelation.class::cast).map(LinkRelation::value).collect(Collectors.toSet());
  Set<String> stringConstants=Arrays.stream(IanaLinkRelations.class.getDeclaredFields()).filter(ReflectionUtils::isPublicStaticFinal).filter(field -> String.class.equals(field.getType())).map(it -> ReflectionUtils.getField(it,null)).filter(Objects::nonNull).map(String.class::cast).collect(Collectors.toSet());
  assertEquals(linkRelations,stringConstants);
}
