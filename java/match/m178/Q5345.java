package match.m178;


import java.util.*;

public class Q5345 {


    public String rankTeams(String[] votes) {
        if (votes == null && votes.length == 0)
            return "";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < votes.length; i++) {
            char c[] = votes[i].toCharArray();
            for (int j = 0; j < c.length; j++) {
                Integer count = map.get(c[j]);
                if (count == null) {
                    map.put(c[j], j * 10);
                } else {
                    map.put(c[j], count + (j * 10));
                }
            }
        }
        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry s : list) {
            System.out.println(s.getKey() + "     " + s.getValue());
            stringBuffer.append(s.getKey());
        }

        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        Q5345 q5345 = new Q5345();
        System.out.println(q5345.rankTeams(new String[]{"FVSHJIEMNGYPTQOURLWCZKAX", "AITFQORCEHPVJMXGKSLNZWUY", "OTERVXFZUMHNIYSCQAWGPKJL", "VMSERIJYLZNWCPQTOKFUHAXG", "VNHOZWKQCEFYPSGLAMXJIUTR", "ANPHQIJMXCWOSKTYGULFVERZ", "RFYUXJEWCKQOMGATHZVILNSP", "SCPYUMQJTVEXKRNLIOWGHAFZ", "VIKTSJCEYQGLOMPZWAHFXURN", "SVJICLXKHQZTFWNPYRGMEUAO", "JRCTHYKIGSXPOZLUQAVNEWFM", "NGMSWJITREHFZVQCUKXYAPOL", "WUXJOQKGNSYLHEZAFIPMRCVT", "PKYQIOLXFCRGHZNAMJVUTWES", "FERSGNMJVZXWAYLIKCPUQHTO", "HPLRIUQMTSGYJVAXWNOCZEKF", "JUVWPTEGCOFYSKXNRMHQALIZ", "MWPIAZCNSLEYRTHFKQXUOVGJ", "EZXLUNFVCMORSIWKTYHJAQPG", "HRQNLTKJFIEGMCSXAZPYOVUW", "LOHXVYGWRIJMCPSQENUAKTZF", "XKUTWPRGHOAQFLVYMJSNEIZC", "WTCRQMVKPHOSLGAXZUEFYNJI"}));
    }
}

