import java.util.*;
import java.util.stream.Stream;

public class StreamFilter {
    Map<Integer, IFilter> filters;
    public StreamFilter(){
        filters=new HashMap<>();
    }
    public String filter(String line){
        String ret = line;
        //System.out.println(line);
        if(line.startsWith("QF:"))
            ret = processFilter(line);
        else if(line.startsWith("LOL:"))
            ret = processLogOfLine(line);
        return ret;
    }
    private String processFilter(String line){
        String ret = line;
        String normalizedLine = line.substring("QF:".length()).trim();
        //synchronized - begin
        int filterIdentifier = filters.size()+1;
        IFilter aFilter = new FilterMatchAll(filterIdentifier,normalizedLine);
        filters.put(filterIdentifier,aFilter);
        //synchronized - end
        ret = "A:"+aFilter.getTerms()+"; FID="+filterIdentifier+"";
        return ret;
    }
    private String processLogOfLine(String line){
        String ret = null;
        String normalizedLine = line.substring("LOL:".length()).trim();
        HashSet<String> lineSet = new HashSet<>();
        Stream.of(normalizedLine.toLowerCase().split(" ")).forEach(lineSet::add);
        List<Integer> filterIdentifiers = new ArrayList<>();
        for(Integer key : filters.keySet())
            if(filters.get(key).doMatch(lineSet)) filterIdentifiers.add(key);
        if(filterIdentifiers.size()>0){
            ret = "M:"+normalizedLine+"; FID="+filterIdentifiers.get(0)+"";
            for(int i=1;i<filterIdentifiers.size();i++)
                ret += ", "+filterIdentifiers.get(i)+"";
        }
        return ret;
    }
}
