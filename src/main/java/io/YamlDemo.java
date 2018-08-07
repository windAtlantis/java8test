package io;

import org.yaml.snakeyaml.Yaml;

import java.util.Map;

/**
 * @author wangzengjian
 * @Description
 * @date 2018/8/6 16:05
 */
public class YamlDemo {

	public static void main(String[] args) {
		String s =
				"空调:  \n" +
				"  - 维修:  \n" +
				"      111711: 机型\n" +
				"      111712: 匹数\n" +
				"      111713: 压缩机\n" +
				"      111727: 计费单位\n" +
				"  - 拆装:  \n" +
				"      111711: 机型\n" +
				"      111714: 拆装项目\n" +
				"      111727: 计费单位\n" +
				"  - 清洗:  \n" +
				"      111711: 机型\n" +
				"      111715: 清洗保养项目\n" +
				"      111727: 计费单位\n" +
				"电视:  \n" +
				"  维修:  \n" +
				"    111716: 小类\n" +
				"    111707: 维修故障\n" +
				"    111727: 计费单位\n" +
				"洗衣机:  \n" +
				"  维修:  \n" +
				"    111711: 机型\n" +
				"    111717: 品牌\n" +
				"    111727: 计费单位\n" +
				"  清洗:  \n" +
				"    111711: 机型\n" +
				"    111717: 品牌\n" +
				"    111727: 计费单位\n" +
				"冰箱:  \n" +
				"  维修:  \n" +
				"    111730: 门款式\n" +
				"    111717: 品牌\n" +
				"    111713: 压缩机\n" +
				"    111727: 计费单位\n" +
				"  拆装:  \n" +
				"    111730: 门款式\n" +
				"    111714: 拆装项目\n" +
				"    111727: 计费单位\n" +
				"  清洗:  \n" +
				"    111730: 门款式\n" +
				"    111717: 品牌\n" +
				"    111727: 计费单位\n" +
				"热水器:  \n" +
				"  维修:  \n" +
				"    111716: 小类\n" +
				"    111717: 品牌\n" +
				"    111727: 计费单位\n" +
				"  拆装:  \n" +
				"    111716: 小类\n" +
				"    111714: 拆装项目\n" +
				"    111727: 计费单位\n" +
				"厨房家电:  \n" +
				"  维修:  \n" +
				"    111716: 小类\n" +
				"    111727: 计费单位\n" +
				"  拆装:  \n" +
				"    111716: 小类\n" +
				"    111727: 计费单位\n" +
				"小家电:  \n" +
				"  维修:  \n" +
				"    111716: 小类\n" +
				"    111727: 计费单位\n" +
				"  拆装:  \n" +
				"    111716: 小类\n" +
				"    111727: 计费单位";

//		s = "key: {child-key: value, child-key2: value2}";

		Yaml yaml = new Yaml();
		Map<String, String> map = yaml.load(s);
		System.out.println(map);

		//language=JSON
//		s = "{\"key\": {\"child-key\": \"value\", \"child-key2\": \"value2\"}}";
//		JSONObject jsonObject = JSON.parseObject(s);
//		System.out.println(jsonObject);
	}
}
