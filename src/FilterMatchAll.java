import java.util.HashSet;

public class FilterMatchAll implements IFilter {
    Integer filterIdentifier = Integer.MAX_VALUE;
    String[] filterTerms;

    public FilterMatchAll(int filterIdentifier, String filterString) {
        this.filterIdentifier = filterIdentifier;
        buildFilterTerms(filterString);
    }
    @Override
    public int getFilterIdentifier() {
        return filterIdentifier;
    }
    @Override
    public boolean doMatch(HashSet<String> line) {
        int i;
        boolean match = true;
        for(i=0;match && i<filterTerms.length;i++)
            match = line.contains(filterTerms[i]);
        return match;
    }
    @Override
    public String getTerms() {
        String ret = "";
        if (filterTerms.length > 0) {
            ret=filterTerms[0];
            for (int i = 1; i < filterTerms.length; i++)
            ret += " "+filterTerms[i];
        }
        return ret;
    }
    private void buildFilterTerms(String filterString){
        String normalizeFilterString = filterString.trim().toLowerCase();
        filterTerms = normalizeFilterString.split(" ");

    }
}
