package priv.bobson.tools.controller;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.bobson.tools.model.Commodity;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class Spider4BiggoController {

    private static Map<String, Set<Commodity>> map1 = new HashMap<>();
    private static Map<String, Set<Commodity>> map2 = new HashMap<>();
    private static Map<String, Set<Commodity>> map3 = new HashMap<>();
    private static final int PAGE_NUMBER = 100;


    public static void main(String[] args) {
        map1 = Spider4BiggoController.loop4All("銀伴戰獸");
        map2 = Spider4BiggoController.loop4All("銀伴戰獸");
        map3 = Spider4BiggoController.loop4All("洛茲");

        map2.forEach((key, value) -> {
            if (map1.containsKey(key) && map3.containsKey(key)) {
                printDetail(key);
            }
        });
    }

    @GetMapping("/test")
    public String test(){
        map1 = Spider4BiggoController.loop4All("ptcg 基拉祈");
        map2 = Spider4BiggoController.loop4All("ptcg 滑板");
        StringBuilder result =new StringBuilder();
        map2.forEach((key, value) -> {
            if (map1.containsKey(key)) {
                result.append(combinDetail(key));
            }
        });
        return result.toString();
    }

    private static String combinDetail(String shop) {
        StringBuilder sb =new StringBuilder();
        sb.append(shop+"<br>");
//        System.out.println(shop);
        map1.get(shop).forEach(e -> {
            sb.append(e.getKeyword() + " " + e.getPrice() + "元 : " + "<a href=\""+ e.getLink() + "\">"+ e.getName() +"</a><br>");
//            System.out.println(e.getKeyword() + " " + e.getPrice() + "元 : " + e.getLink() + "   " + e.getName());
        });
        map2.get(shop).forEach(e -> {
            sb.append(e.getKeyword() + " " + e.getPrice() + "元 : " + "<a href=\""+ e.getLink() + "\">"+ e.getName() +"</a><br>");
//            System.out.println(e.getKeyword() + " " + e.getPrice() + "元 : " + e.getLink() + "   " + e.getName());
        });
        sb.append("<br>");
//        System.out.println();
        return sb.toString();
    }

    private static void printDetail(String shop) {
        System.out.println(shop);
        map1.get(shop).forEach(e -> {
            System.out.println(e.getKeyword() + " " + e.getPrice() + "元 : " + e.getLink() + "   " + e.getName());
        });
        map2.get(shop).forEach(e -> {
            System.out.println(e.getKeyword() + " " + e.getPrice() + "元 : " + e.getLink() + "   " + e.getName());
        });
        map3.get(shop).forEach(e -> {
            System.out.println(e.getKeyword() + " " + e.getPrice() + "元 : " + e.getLink() + "   " + e.getName());
        });
        System.out.println();
    }

    public static Map<String, Set<Commodity>> loop4All(String keyword) {
        int i = 0;
        int tmp = 0;
        List<Commodity> commodities = new ArrayList<>();

        try {
            while (i < PAGE_NUMBER) {
                System.out.println("搜尋\"" + keyword + "\"現在爬到第" + i + "頁,共" + (tmp+1) + "筆");
                Document document = Jsoup.connect("https://biggo.com.tw/s/" + keyword + "/?p=" + i++).get();
                Elements div = document.body().getElementsByClass("col-12 product-row ");

//                Elements gaobj = div.get(0).getElementsByClass("gaobj");
//                Elements elementsByClass = div.get(2).getElementsByClass("line-clamp-1");
//                System.out.println(elementsByClass.text());


                tmp += div.size();

                div.forEach(e -> {
                    Elements gaobj = e.getElementsByClass("gaobj");
                    String shop = e.getElementsByClass("line-clamp-1").text();


                    Commodity commodity = Commodity.builder()
                            .name(gaobj.attr("data-title"))
                            .price(Integer.parseInt(gaobj.attr("data-price")))
                            .shop(shop)
                            .market(gaobj.attr("data-id"))
                            .link(gaobj.attr("data-href"))
                            .keyword(keyword)
                            .build();
                    commodities.add(commodity);
                });

            }
            Map<String, List<Commodity>> collect = commodities.stream().collect(Collectors.groupingBy(Commodity::getShop));
            Map<String, Set<Commodity>> result = new HashMap<>();
            collect.entrySet().stream().forEach(e -> {
                HashSet<Commodity> commoditySet = new HashSet<>(e.getValue());
                result.put(e.getKey(), commoditySet);
            });
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("總筆數: " + tmp);
        }
        return null;
    }
}
