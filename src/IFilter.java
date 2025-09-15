import java.util.HashSet;

public interface IFilter {
    public int getFilterIdentifier();
    //public boolean doMatch(String line);
    public boolean doMatch(HashSet<String> line);
    public String getTerms();
}
