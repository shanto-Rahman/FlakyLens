@Test public void testResultSetStaticCallWithResultMapping() throws Exception {
  inTransaction(entityManager -> {
    StoredProcedureQuery storedProcedureQuery=entityManager.createNamedStoredProcedureQuery("returnNamedParametersWithMapping");
    storedProcedureQuery.setParameter(RESULT_SET_PROC_ID_PARAM,2);
    storedProcedureQuery.setParameter(RESULT_SET_PROC_TITLE_PARAM,"title'2");
    @SuppressWarnings("unchecked") List<Car> listResult=storedProcedureQuery.getResultList();
    assertThat(listResult).containsExactly(new Car(2,"title'2"));
  }
);
}
