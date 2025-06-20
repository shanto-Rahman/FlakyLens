@Test public void testResultSetDynamicCallWithResultClass() throws Exception {
  inTransaction(entityManager -> {
    StoredProcedureQuery storedProcedureQuery=entityManager.createStoredProcedureQuery(RESULT_SET_PROC,Car.class);
    storedProcedureQuery.registerStoredProcedureParameter("result",Void.class,ParameterMode.REF_CURSOR);
    storedProcedureQuery.registerStoredProcedureParameter(RESULT_SET_PROC_ID_PARAM,Integer.class,ParameterMode.IN);
    storedProcedureQuery.registerStoredProcedureParameter(RESULT_SET_PROC_TITLE_PARAM,String.class,ParameterMode.IN);
    storedProcedureQuery.setParameter(RESULT_SET_PROC_ID_PARAM,1);
    storedProcedureQuery.setParameter(RESULT_SET_PROC_TITLE_PARAM,"title");
    @SuppressWarnings("unchecked") List<Car> listResult=storedProcedureQuery.getResultList();
    assertThat(listResult).containsExactly(new Car(1,"title"));
  }
);
}
