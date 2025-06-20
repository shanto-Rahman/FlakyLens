@Test public void shouldCreateQueryWithMultipleDiscriminatorValuesWithFilter(){
  assertQuery("from CommunityMemberST c where c.project = 'Hibernate OGM'","MATCH (c:PersonST) WHERE c.project = \"Hibernate OGM\" AND c.DTYPE IN [\"EMP\", \"CMM\"] RETURN c",CommunityMemberST.class);
}
