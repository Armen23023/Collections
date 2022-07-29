import java.util.*;
import java.util.List;
import java.util.Map;

public class CollectionUtil {

    //    վերադարձնել text-ի մեջ տառերի մասին ինֆորմասիան, այսինքն թե որ տառր որ համարի ինդեքսներում է հանդիպում
//  օռինակ text="Hello World" - >{d=[9], o=[4, 6], r=[7], W=[5], H=[0], l=[2, 3, 8], e=[1]}
    public Map<Character, List<Integer>> getCharInfo(String text) {
        Map<Character, List<Integer>> data = new TreeMap<>();
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            List<Integer> integers = data.get(aChar);
            if (integers == null) {
                List<Integer> indexes = new ArrayList<>();
                indexes.add(i);
                data.put(aChar, indexes);
            }else {
                integers.add(i);
            }
        }
        return data;
    }


//userData-ում պահվում են ուսերների մասին ինֆորմասիան, անուն + ասգանունը որպես բանալի, և տարիքը որպես value,
//    պարզել արդյոք userData -ում կա տրված fullName -ով  և տրված age-ով user
 public boolean isExists(Map<String, Integer> userData, String fullName,Integer age){
   for (Map.Entry<String,Integer> entry : userData.entrySet()){
       if (entry.getKey()==fullName && entry.getValue()==age){
           return true;
       }
   }
   return false;
 }
//    Ստենալով text-ը վերադարձնել ինֆո այն մասին թե, որ բառը քանի անգամ է կրկնվում տրված տեքստում
    //օր abc asd dfg abc asd qwe asd dfg ->[abc=2, asd=3, dfg=2, qwe=1]
    public Map<String, Integer> wordsData(String text){
        Map<String,Integer> map = new HashMap<>();
        int i =0;
        String [] words = text.split(" ");
        for (String word:words){
            map.put(word,i);
        }
        for (String word:words) {
        if (map.containsKey(word));
            map.put(word,(map.get(word)) + 1);
        }
        return map;
    }
// մեթոդը ընդունում է 2 տեքստ, վերադարձնել ինֆո այն մասին,
// թե առաջին տեքստի յուրաքանչյուր բառ քանի անգամ է կրկնվում 2-ռդ տեքստի մեջ
    public Map<String, Integer> calculateWordCount(String text1, String text2){
        Map<String,Integer> map = new HashMap();
        String [] words = text1.split(" ");
        for (String word:words){
            map.put(word,0);
        }
        String [] words2 = text2.split(" ");
        for (String word:words2){
            if (map.containsKey(word)){
                map.put(word, map.get(word)+1);
            }
        }
        return map;
    }
//    data-ի միջին վերադարձնել տրված value ունեցող ամենամեծ key-ը, որը int տիպի է։
//    example data=[5="poxos", 2="petros", 8="martiros", 12="poxos", 7="petros"]
//            value = "pxoso"   - > retrun 12
    public int getMaxKeyByValue(Map<Integer, String> data, String value){
        Integer mm =0;
    for (Map.Entry<Integer,String>entry:data.entrySet()){

        if(entry.getValue() == value){
             if (mm<entry.getKey()){
                 mm = entry.getKey();
             }
        }
    }
        return mm;
    }


}