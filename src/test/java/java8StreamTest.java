import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * UTF-8
 * Created by czy  Time : 2020/2/2 20:42
 *
 * @version 1.0
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class java8StreamTest {

    int cccc=0;

    @Test
    public void testListStream(){
        Integer [] element={1,2,3,4,5,6,7,8,9};
        List<Integer> list= Arrays.asList(element);
        list.stream().filter(el->el>4).forEach(System.out::println);
        list.stream().map(el->el*2).forEach(System.out::println);
        System.out.println(list);//原数据

        String [] strings={"122","1221","ssa"};
        List<String> stringList=Arrays.asList(strings);
        Stream<String> sListStream=stringList.stream();
        sListStream.filter(el->el.length()>3).forEach(System.out::println);


//        Stream<String> stringStream= Stream.<String>builder().add("ssss").build();
        Stream<String> stringStream= Stream.<String>builder().add("ssss").build();
        stringStream.filter(el->el.length()>9).forEach(System.out::println);
    }

    @Test
    public void testStreamnei(){
        List<Integer> integers=Arrays.asList(1,2,3,5);
        int[] count = {0};//会隐式加上finall 变成 final int [] count={0}.
        integers.stream().forEach(el->{
            el=el+1;
            count[0] = count[0] +1;
        });
        System.out.println(count[0]);

        //类成员变量不用
        integers.stream().forEach(el->{
            el=el+1;
            cccc = cccc +1;
        });
        System.out.println(cccc);

    }

    @Test
    public void testStream(){
        List<String> words = Arrays.asList("hello c++", "hello java", "hello python");
        List<String[]> result = words.stream()
                // 将单词按照空格切合，返回Stream<String[]>类型的数据
                .map(word -> word.split(" "))
                // 将Stream<String[]>转换为Stream<String>
                //.flatMap(Arrays::stream)
                // 去重
                .distinct()
                .collect(Collectors.toList());
        System.out.println(result.size()); //3
        System.out.println(result.get(1).length);//2
        System.out.println(result.get(2)[1]);//python
    }

    @Test
    public void testStreamflatmp(){
        List<String> words = Arrays.asList("hello c++", "hello java", "hello python");
        List<String> result = words.stream()
                // 将单词按照空格切合，返回Stream<String[]>类型的数据
                //map的返回类型是map中函数返回类型的stream类型，既是 Stream<函数返回类型>
                .map(word -> word.split(" "))
                // 将Stream<String[]>转换为Stream<String>
                //flatMap是将Stream中类型数组扁平化为Stream类型
                //既是Stream<类型[]> ----> Stream<类型>
                .flatMap(Arrays::stream)
                // 去重
                .distinct()
                .collect(Collectors.toList());
        System.out.println(result.size());//4
        System.out.println(result);//[hello, c++, java, python]


    }

    @Test
    public void testMap(){
        Map<Integer,String> map=new TreeMap<>();
        map.put(1,"sss");
        map.put(1,"234");
        map.put(2,"czy");
        map.put(3,"asd");
        //使用iter快捷键
        for (Integer key : map.keySet()) {
            System.out.print("键为："+ key);
            System.out.println("值为："+ map.get(key));
        }
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> next : entries) {
            System.out.print("键为：" + next.getKey());
            System.out.println("值为：" + next.getValue());

        }

        Iterator<Map.Entry<Integer, String>> entryIterator = entries.iterator();
        while (entryIterator.hasNext()){
            Map.Entry<Integer, String> next = entryIterator.next();
            System.out.print("键为："+ next.getKey());
            System.out.println("值为："+ next.getValue());

        }
        LinkedList<Integer> llist = new LinkedList<Integer>();
    }
}
