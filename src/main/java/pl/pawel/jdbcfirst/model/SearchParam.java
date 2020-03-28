package pl.pawel.jdbcfirst.model;

public class SearchParam {
    private String odSearch;
    private String doSearch;

    public SearchParam() {
    }


    public String getOdSearch() {
        return odSearch;
    }

    public void setOdSearch(String odSearch) {
        this.odSearch = odSearch;
    }

    public String getDoSearch() {
        return doSearch;
    }

    public void setDoSearch(String doSearch) {
        this.doSearch = doSearch;
    }

    @Override
    public String toString() {
        return "SearchParam{" +
                "odSearch='" + odSearch + '\'' +
                ", doSearch='" + doSearch + '\'' +
                '}';
    }
}
