@Test public void should_raise_an_error_because_of_missing_getter(){
assertThat(error).hasMessage("No getter for property 'salary' in org.assertj.core.util.Employee");
}