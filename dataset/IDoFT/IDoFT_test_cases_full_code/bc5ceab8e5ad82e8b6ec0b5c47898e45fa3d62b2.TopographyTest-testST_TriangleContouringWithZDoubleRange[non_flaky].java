@Test public void testST_TriangleContouringWithZDoubleRange() throws SQLException {
  Statement st=connection.createStatement();
  try {
    st.execute("DROP TABLE IF EXISTS TIN");
    st.execute("CREATE TABLE TIN AS SELECT 'POLYGON ((-9.19 3.7 1, 0.3 1.41 4.4, -5.7 -4.15 4, -9.19 3.7 1))'::geometry the_geom");
    ResultSet rs=st.executeQuery("select * from ST_TriangleContouring('TIN', DOUBLERANGE(2,6,1)) order by idiso");
    assertEquals(2,rs.getMetaData().getColumnCount());
    assertTrue(rs.next());
    assertGeometryBarelyEquals("POLYGON ((-6.4 3.03 2, -9.19 3.7 1, -8.02 1.09 2, -6.4 3.03 2))",rs.getObject(1));
    assertEquals(0,rs.getInt("idiso"));
    assertTrue(rs.next());
    assertGeometryBarelyEquals("POLYGON ((-6.86 -1.53 3, -6.05 -0.56 3, -6.4 3.03 2, -6.86 -1.53 3))",rs.getObject(1));
    assertEquals(1,rs.getInt("idiso"));
    assertTrue(rs.next());
    assertGeometryBarelyEquals("POLYGON ((-6.86 -1.53 3, -6.4 3.03 2, -8.02 1.09 2, -6.86 -1.53 3))",rs.getObject(1));
    assertEquals(1,rs.getInt("idiso"));
    assertTrue(rs.next());
    assertGeometryBarelyEquals("POLYGON ((-6.05 -0.56 3, -3.61 2.35 3, -6.4 3.03 2, -6.05 -0.56 3))",rs.getObject(1));
    assertEquals(1,rs.getInt("idiso"));
    assertTrue(rs.next());
    assertGeometryBarelyEquals("POLYGON ((-6.86 -1.53 3, -5.7 -4.15 4, -6.05 -0.56 3, -6.86 -1.53 3))",rs.getObject(1));
    assertEquals(2,rs.getInt("idiso"));
    assertTrue(rs.next());
    assertGeometryBarelyEquals("POLYGON ((-1.52 0.85 4, -0.82 1.68 4, -6.05 -0.56 3, -1.52 0.85 4))",rs.getObject(1));
    assertEquals(2,rs.getInt("idiso"));
    assertTrue(rs.next());
    assertGeometryBarelyEquals("POLYGON ((-0.82 1.68 4, -3.61 2.35 3, -6.05 -0.56 3, -0.82 1.68 4))",rs.getObject(1));
    assertEquals(2,rs.getInt("idiso"));
    assertTrue(rs.next());
    assertGeometryBarelyEquals("POLYGON ((-1.52 0.85 4, -6.05 -0.56 3, -5.7 -4.15 4, -1.52 0.85 4))",rs.getObject(1));
    assertEquals(2,rs.getInt("idiso"));
    assertTrue(rs.next());
    assertGeometryBarelyEquals("POLYGON ((-1.52 0.85 4, 0.3 1.41 4.4, -0.82 1.68 4, -1.52 0.85 4))",rs.getObject(1));
    assertEquals(3,rs.getInt("idiso"));
    assertTrue(rs.next());
    assertGeometryBarelyEquals("POLYGON ((-5.7 -4.15 4, 0.3 1.41 4.4, -1.52 0.85 4, -5.7 -4.15 4))",rs.getObject(1));
    assertEquals(3,rs.getInt("idiso"));
    assertFalse(rs.next());
  }
  finally {
    st.close();
  }
}
